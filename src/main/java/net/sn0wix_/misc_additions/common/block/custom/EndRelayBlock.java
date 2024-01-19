package net.sn0wix_.misc_additions.common.block.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import net.sn0wix_.misc_additions.common.block.entities.EndRelayBlockEntity;
import net.sn0wix_.misc_additions.common.block.entities.ModBlockEntities;
import net.sn0wix_.misc_additions.common.networking.custom.s2c.PortalParticleSpawnS2CPacket;
import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndRelayBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty CHARGES = Properties.CHARGES;
    public static final BooleanProperty HAS_COMPASS = BooleanProperty.of("has_compass");

    public final java.util.Random random = new java.util.Random();
    public static final ImmutableList<Vec3i> VALID_HORIZONTAL_SPAWN_OFFSETS = ImmutableList.of(new Vec3i(0, 0, -1), new Vec3i(-1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(1, 0, 0), new Vec3i(-1, 0, -1), new Vec3i(1, 0, -1), new Vec3i(-1, 0, 1), new Vec3i(1, 0, 1));
    public static final ImmutableList<Vec3i> VALID_SPAWN_OFFSETS = ((ImmutableList.Builder)((ImmutableList.Builder)((ImmutableList.Builder)((ImmutableList.Builder)new ImmutableList.Builder().addAll(VALID_HORIZONTAL_SPAWN_OFFSETS)).addAll(VALID_HORIZONTAL_SPAWN_OFFSETS.stream().map(Vec3i::down).iterator())).addAll(VALID_HORIZONTAL_SPAWN_OFFSETS.stream().map(Vec3i::up).iterator())).add(new Vec3i(0, 1, 0))).build();


    public EndRelayBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(CHARGES, 0).with(HAS_COMPASS, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //Charge logic
        if (canCharge(state) && isCorrectItem(player.getStackInHand(hand))) {
            if (!world.isClient) {
                charge(player, world, pos, state);
                if (!player.getAbilities().creativeMode) {
                    player.getStackInHand(hand).decrement(1);
                }
            }
            return ActionResult.SUCCESS;
        }

        //Inserting compass logic
        if (player.getStackInHand(hand).isOf(Items.COMPASS) && getBlockEntity(world, pos) != null) {
            if (!world.isClient) {
                if (getBlockEntity(world, pos).setCompass(player.getStackInHand(hand))) {
                    if (!player.getAbilities().creativeMode) {
                        player.getStackInHand(hand).decrement(1);
                    }

                    world.playSound(null, pos, SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.BLOCKS, 1, 0.8f);
                    world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 1, 0.8f);
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
        }

        if (player.isSneaking() && getBlockEntity(world, pos) != null && state.get(HAS_COMPASS)) {
            if (!world.isClient) {
                if (getBlockEntity(world, pos).dropCompass() && getBlockEntity(world, pos).setCompass(ItemStack.EMPTY)) {
                    world.playSound(null, pos, SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.BLOCKS, 1, 0.8f);
                    world.playSound(null, pos, SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.BLOCKS, 1, 0.8f);
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
        }

        //discharging logic
        if (isEnd(world) && state.get(CHARGES) > 0) {
            if (!world.isClient) {
                disCharge(player, world, pos, state);
            }

            return ActionResult.SUCCESS;
        }

        if (!world.isClient && !isEnd(world) && state.get(CHARGES) > 0 && !isCorrectItem(player.getStackInHand(hand))) {
            explode(state, world, pos);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(itemStack);
        if (nbtCompound != null && nbtCompound.contains("CompassItem")) {
            world.setBlockState(pos, state.with(HAS_COMPASS, true), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            return;
        }

        if (getBlockEntity(world, pos) != null) {
            getBlockEntity(world, pos).dropCompass(true);
            if (state.get(HAS_COMPASS)) {
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.BLOCKS, 1, 0.8f);
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.BLOCKS, 1, 0.8f);
            }
        }

        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(CHARGES);
        builder.add(HAS_COMPASS);
    }


    //Redstone
    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(HAS_COMPASS) ? 11 + state.get(CHARGES) : state.get(CHARGES);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getWeakRedstonePower(state, null, null, null);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }


    //Particles
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Vec3d particlePos = pos.toCenterPos().add(0, -0.2, 0);

        for (int i = 0; i < getChargeLevel(state) * 1.5; i++) {
            world.addParticle(ParticleTypes.PORTAL, this.getParticleX(0.5, particlePos), this.getRandomBodyY(particlePos) - 0.25, this.getParticleZ(0.5, particlePos), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
        }

        super.randomDisplayTick(state, world, pos, random);
    }

    //Ticker
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return EndRelayBlock.validateTicker(type, ModBlockEntities.END_RELAY_BLOCK_ENTITY, EndRelayBlockEntity::tick);
    }

    //HELPER METHODS
    public static void explode(BlockState state, World world, BlockPos explodedPos) {
        if (!world.isClient && getChargeLevel(state) != 0) {
            world.removeBlock(explodedPos, false);
            boolean bl = Direction.Type.HORIZONTAL.stream().map(explodedPos::offset).anyMatch(pos -> hasStillWater(pos, world));
            final boolean bl2 = bl || world.getFluidState(explodedPos.up()).isIn(FluidTags.WATER);
            ExplosionBehavior explosionBehavior = new ExplosionBehavior() {
                @Override
                public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
                    if (pos.equals(explodedPos) && bl2) {
                        return Optional.of(Blocks.WATER.getBlastResistance());
                    }
                    return super.getBlastResistance(explosion, world, pos, blockState, fluidState);
                }
            };
            Vec3d vec3d = explodedPos.toCenterPos();
            world.createExplosion(null, world.getDamageSources().explosion(null, null), explosionBehavior, vec3d, state.get(CHARGES) * 6, true, World.ExplosionSourceType.BLOCK);
        }
    }

    public void disCharge(@Nullable Entity disCharger, World world, BlockPos pos, BlockState state) {
        if (getBlockEntity(world, pos).teleport(null, null)) {
            BlockState blockState = state.with(CHARGES, state.get(CHARGES) - 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(disCharger, blockState));
        }

        world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1, 1);
        world.playSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.BLOCKS, 10, 3f);

        world.getPlayers().forEach(player -> {
            if (player.getPos().isInRange(pos.toCenterPos(), 256)) {
                PortalParticleSpawnS2CPacket.send((ServerPlayerEntity) player, pos.toCenterPos());
            }
        });
    }

    public void charge(@Nullable Entity charger, World world, BlockPos pos, BlockState state) {
        BlockState blockState = state.with(CHARGES, state.get(CHARGES) + 1);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(charger, blockState));

        world.playSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1, 1.2f);

        world.getPlayers().forEach(player -> {
            if (player.getPos().isInRange(pos.toCenterPos(), 256)) {
                PortalParticleSpawnS2CPacket.send((ServerPlayerEntity) player, pos.toCenterPos());
            }
        });
    }

    public double getRandomBodyY(Vec3d pos) {
        return pos.y + random.nextDouble();
    }

    public double offsetX(double widthScale, Vec3d pos) {
        return pos.x + widthScale;
    }

    public double getParticleX(double widthScale, Vec3d pos) {
        return this.offsetX((2.0 * this.random.nextDouble() - 1.0) * widthScale, pos);
    }

    public double offsetZ(double widthScale, Vec3d pos) {
        return pos.z + widthScale;
    }

    public double getParticleZ(double widthScale, Vec3d pos) {
        return this.offsetZ((2.0 * this.random.nextDouble() - 1.0) * widthScale, pos);
    }

    public static boolean isEnd(World world) {
        return world.getDimensionEntry().matchesKey(DimensionTypes.THE_END);
    }

    private static boolean canCharge(BlockState state) {
        return state.get(CHARGES) < 4;
    }

    private static boolean hasStillWater(BlockPos pos, World world) {
        FluidState fluidState = world.getFluidState(pos);
        if (!fluidState.isIn(FluidTags.WATER)) {
            return false;
        }
        if (fluidState.isStill()) {
            return true;
        }
        float f = fluidState.getLevel();
        if (f < 2.0f) {
            return false;
        }
        FluidState fluidState2 = world.getFluidState(pos.down());
        return !fluidState2.isIn(FluidTags.WATER);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private boolean isCorrectItem(ItemStack stack) {
        return stack.isIn(ModItemTags.END_RELAY_CHARGEABLE);
    }


    public static int getChargeLevel(BlockState state) {
        return state.get(CHARGES);
    }

    public static int getLightLevel(BlockState state) {
        return MathHelper.floor((float) (state.get(CHARGES)) / 4.0f * 15);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.END_RELAY_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(EndRelayBlock::new);
    }

    public EndRelayBlockEntity getBlockEntity(World world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof EndRelayBlockEntity blockEntity) {
            return blockEntity;
        }

        return null;
    }
}
