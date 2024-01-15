package net.sn0wix_.misc_additions.common.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import net.sn0wix_.misc_additions.common.block.entities.ModBlockEntities;
import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EndRelayBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty CHARGES = Properties.CHARGES;
    public final java.util.Random random = new java.util.Random();

    public EndRelayBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(CHARGES, 0));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (canCharge(state) && isCorrectItem(player.getStackInHand(hand))) {
            if (!world.isClient) {
                charge(player, world, pos, state);
                if (!player.getAbilities().creativeMode) {
                    player.getStackInHand(hand).decrement(1);
                }
            }
            return ActionResult.SUCCESS;
        }

        if (!world.isClient && !isEnd(world) && state.get(CHARGES) > 0) {
            explode(state, world, pos);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

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

    public static void charge(@Nullable Entity charger, World world, BlockPos pos, BlockState state) {
        BlockState blockState = state.with(CHARGES, state.get(CHARGES) + 1);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(charger, blockState));
        world.playSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1, 1.2f);

        if (getChargeLevel(state) == 4) {
            world.playSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 1, 1);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Vec3d particlePos = pos.toCenterPos().add(0, -0.2, 0);

        for (int i = 0; i < getChargeLevel(state) + 2; i++) {
            world.addParticle(ParticleTypes.PORTAL, this.getParticleX(0.5, particlePos), this.getRandomBodyY(particlePos) - 0.25, this.getParticleZ(0.5, particlePos), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
        }

        super.randomDisplayTick(state, world, pos, random);
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
        return stack.isIn(ModItemTags.END_ANCHOR_CHARGEABLE);
    }


    public static int getChargeLevel(BlockState state) {
        return state.get(CHARGES);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public static int getLightLevel(BlockState state) {
        return MathHelper.floor((float) (state.get(CHARGES)) / 4.0f * 15);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getLightLevel(state);
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

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(CHARGES);
    }
}
