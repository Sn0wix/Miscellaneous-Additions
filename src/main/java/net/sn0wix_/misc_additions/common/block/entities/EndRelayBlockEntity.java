package net.sn0wix_.misc_additions.common.block.entities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.CollisionView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.event.GameEvent;
import net.sn0wix_.misc_additions.client.util.particles.EndRelayTpParticleUtil;
import net.sn0wix_.misc_additions.common.block.ModBlocks;
import net.sn0wix_.misc_additions.common.block.custom.EndRelayBlock;

import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class EndRelayBlockEntity extends BlockEntity implements SingleStackInventory, Clearable {
    public static final String LODESTONE_POS_KEY = "LodestonePos";
    public static final String LODESTONE_DIMENSION_KEY = "LodestoneDimension";
    public UUID playerId;

    public int compassDelay = 0;
    public final int maxCompassDelay = 80;

    public int teleportDelay = 0;
    public final int maxTeleportDelay = 60;
    public final int teleportAt = 45;

    public ItemStack compass_stack = ItemStack.EMPTY;

    public EndRelayBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.END_RELAY_BLOCK_ENTITY, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (compassDelay > 0) {
            compassDelay--;
        }

        if (teleportDelay > 0) {
            teleportDelay--;
            if (teleportDelay == teleportAt) {
                teleport(world.getPlayerByUuid(playerId), world);
            }
        }
    }

    public boolean canTeleport(PlayerEntity player, CollisionView view) {
        if (getCompassPos() != null && world != null && isEnd(world)) {
            Optional<Vec3d> optional = findTPPosition(player.getType(), view, getCompassPos().up());

            if (optional.isPresent() && world.getBlockState(getCompassPos()).isOf(Blocks.LODESTONE)) {
                world.getPlayers().forEach(playerEntity -> {
                    if (playerEntity.getPos().isInRange(player.getPos(), 256) && !playerEntity.getUuid().equals(player.getUuid())) {
                        EndRelayTpParticleUtil.send((ServerPlayerEntity) playerEntity, player.getBlockPos());
                    }

                    if (playerEntity.getPos().isInRange(getCompassPos().toCenterPos(), 256) && !playerEntity.getUuid().equals(player.getUuid())) {
                        EndRelayTpParticleUtil.send((ServerPlayerEntity) playerEntity, getCompassPos());
                    }
                });

                EndRelayTpParticleUtil.send((ServerPlayerEntity) player, getCompassPos());
                EndRelayTpParticleUtil.send((ServerPlayerEntity) player, player.getBlockPos());

                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1, 1);
                world.playSound(null, this.getCompassPos().up(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1, 1);
                teleportDelay = maxTeleportDelay;

                playerId = player.getUuid();
                return true;
            }

        }
        return false;
    }

    public boolean teleport(PlayerEntity player, CollisionView view) {
        if (getCompassPos() != null && world != null && isEnd(world) && isEnd(player.getWorld())) {
            Optional<Vec3d> optional = findTPPosition(player.getType(), view, getCompassPos().up());

            if (optional.isPresent() && world.getBlockState(getCompassPos()).isOf(Blocks.LODESTONE)) {

                player.requestTeleport(optional.get().x, optional.get().y, optional.get().z);
                world.emitGameEvent(GameEvent.TELEPORT, optional.get(), GameEvent.Emitter.of(player));
                return true;
            }

        }
        return false;
    }

    public int getCompassDelay() {
        return compassDelay;
    }

    public int getTeleportDelay() {
        return teleportDelay;
    }

    public BlockPos getCompassPos() {
        if (getStack().getNbt() != null && !getStack().getNbt().isEmpty()) {
            NbtCompound nbt = getStack().getNbt();
            String dimension = nbt.getString(LODESTONE_DIMENSION_KEY);

            if (dimension.equals(DimensionTypes.THE_END_ID.toString())) {
                return NbtHelper.toBlockPos(nbt.getCompound(LODESTONE_POS_KEY));
            }
        }
        return null;
    }


    //Item transfering between hopper and end relay
    @Override
    public boolean canTransferTo(Inventory hopperInventory, int slot, ItemStack stack) {
        if (compass_stack.isEmpty() && stack.isOf(Items.COMPASS)) {
            return true;
        } else if (getWorld().getBlockState(getPos()) != null && stack.isOf(Items.END_CRYSTAL) && getWorld().getBlockState(getPos()).isOf(ModBlocks.END_RELAY)) {
            stack.decrement(getWorld().getBlockState(getPos()).get(EndRelayBlock.CHARGED) ? 1 : 0);
            getWorld().setBlockState(getPos(), getWorld().getBlockState(getPos()).with(EndRelayBlock.CHARGED, true));
        }

        return false;
    }

    //NBT data
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("CompassItem", NbtElement.COMPOUND_TYPE)) {
            this.compass_stack = ItemStack.fromNbt(nbt.getCompound("CompassItem"));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.getStack().isEmpty()) {
            nbt.put("CompassItem", this.getStack().writeNbt(new NbtCompound()));
        }
    }

    //HELPER METHODS
    public static Optional<Vec3d> findTPPosition(EntityType<?> entity, CollisionView world, BlockPos pos) {
        Optional<Vec3d> optional = EndRelayBlockEntity.findTPPosition(entity, world, pos, true);
        if (optional.isPresent()) {
            return optional;
        }
        return EndRelayBlockEntity.findTPPosition(entity, world, pos, false);
    }

    private static Optional<Vec3d> findTPPosition(EntityType<?> entity, CollisionView world, BlockPos pos, boolean ignoreInvalidPos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (Vec3i vec3i : EndRelayBlock.VALID_HORIZONTAL_SPAWN_OFFSETS) {
            mutable.set(pos).move(vec3i);
            Vec3d vec3d = Dismounting.findRespawnPos(entity, world, mutable, ignoreInvalidPos);
            if (vec3d == null) continue;
            return Optional.of(vec3d);
        }
        return Optional.empty();
    }

    private void updateState(@Nullable Entity entity, boolean hasCompass) {
        assert this.world != null;
        if (this.world.getBlockState(this.getPos()) == this.getCachedState()) {
            this.world.setBlockState(this.getPos(), this.getCachedState().with(EndRelayBlock.HAS_COMPASS, hasCompass), Block.NOTIFY_LISTENERS);
            this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(entity, this.getCachedState()));
        }
    }

    public boolean dropCompass(boolean broken) {
        if (compassDelay == 0 || broken) {
            if (this.world == null || this.world.isClient) {
                return false;
            }
            BlockPos blockPos = this.getPos();
            ItemStack itemStack = this.getStack();
            if (itemStack.isEmpty()) {
                return false;
            }
            this.removeStack();
            Vec3d vec3d = Vec3d.add(blockPos, 0.5, 1.01, 0.5).addRandom(this.world.random, 0.7f);
            ItemStack itemStack2 = itemStack.copy();
            ItemEntity itemEntity = new ItemEntity(this.world, vec3d.getX(), vec3d.getY(), vec3d.getZ(), itemStack2);
            itemEntity.setToDefaultPickupDelay();
            this.world.spawnEntity(itemEntity);
            return true;
        }
        return false;
    }

    public boolean dropCompass() {
        return dropCompass(false);
    }


    //Inventory
    @Override
    public ItemStack getStack(int slot) {
        return compass_stack;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = this.compass_stack;
        this.compass_stack = ItemStack.EMPTY;
        if (!itemStack.isEmpty()) {
            this.updateState(null, false);
        }
        return itemStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        if (stack.isOf(Items.COMPASS) && this.world != null) {
            this.compass_stack = stack;
            compassDelay = maxCompassDelay;
            this.updateState(null, true);
        } else if (stack.isEmpty()) {
            this.removeStack(1, 1);
        }
    }


    public boolean setCompass(ItemStack stack) {
        if (compassDelay == 0) {
            if (!compass_stack.isEmpty()) {
                dropCompass();
            }

            this.compass_stack = stack.copy();
            this.compass_stack.setCount(getMaxCountPerStack());
            updateState(null, !stack.isEmpty());
            assert this.world != null;
            this.world.updateNeighborsAlways(this.getPos(), this.getCachedState().getBlock());
            this.markDirty();
            compassDelay = maxCompassDelay;
            return true;
        }

        return false;
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (stack.isOf(Items.COMPASS)) {
            return true;
        }

        return stack.isIn(ModItemTags.END_RELAY_CHARGEABLE);
    }

    @Override
    public int getMaxCountPerStack() {
        return 1;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return false;
    }

    public static void tick(World world, BlockPos pos, BlockState state, EndRelayBlockEntity endRelayBlockEntity) {
        endRelayBlockEntity.tick(world, pos, state);
    }

    public static boolean isEnd(World world) {
        return world.getDimensionEntry().matchesKey(DimensionTypes.THE_END);
    }
}
