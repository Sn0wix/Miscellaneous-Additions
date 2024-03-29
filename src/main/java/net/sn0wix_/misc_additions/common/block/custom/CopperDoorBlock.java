package net.sn0wix_.misc_additions.common.block.custom;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneycombItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.sn0wix_.misc_additions.client.util.particles.ParticlePacketTypes;
import net.sn0wix_.misc_additions.common.networking.ModPackets;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static net.minecraft.item.HoneycombItem.WAXED_TO_UNWAXED_BLOCKS;

public class CopperDoorBlock extends DoorBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;

    public CopperDoorBlock(Oxidizable.OxidationLevel oxidationLevel, Settings settings, BlockSetType blockSetType) {
        super(blockSetType, settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!state.get(POWERED)) {
            return super.onUse(state, world, pos, player, hand, hit);
        }

        return ActionResult.PASS;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN)) || (bl = false);
            if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
                playOpenCloseSound(null, world, pos, state.get(POWERED));

                if (state.get(HALF).equals(DoubleBlockHalf.LOWER)) {
                    spawnParticles(world, pos);
                } else {
                    spawnParticles(world, pos.down());
                }
            }

            world.setBlockState(pos, (state.with(POWERED, bl)).with(OPEN, state.get(OPEN)), Block.NOTIFY_LISTENERS);
        }
    }


    private void spawnParticles(World world, BlockPos pos) {
        world.getPlayers().forEach(player -> {
            if (world.isPlayerInRange(pos.getX(), pos.getY(), pos.getZ(), 128)) {
                PacketByteBuf buffer = PacketByteBufs.create();
                buffer.writeInt(ParticlePacketTypes.COPPER_DOOR_REDSTONE_PARTICLE.getType());
                buffer.writeBlockPos(pos);
                ModPackets.sendParticlePacket((ServerPlayerEntity) player, buffer);
            }
        });
    }

    public void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.getBlockSetType().doorOpen() : this.getBlockSetType().doorClose(), SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!world.isClient() && (pos.up().equals(neighborPos) || pos.down().equals(neighborPos))) {
            if (Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent() && Oxidizable.getIncreasedOxidationBlock(state.getBlock()).get().equals(neighborState.getBlock())) {
                return neighborState.withIfExists(HALF, state.get(HALF).equals(DoubleBlockHalf.UPPER) ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
            }

            if (Oxidizable.getDecreasedOxidationBlock(state.getBlock()).isPresent() && Oxidizable.getDecreasedOxidationBlock(state.getBlock()).get().equals(neighborState.getBlock())) {
                return neighborState.withIfExists(HALF, state.get(HALF).equals(DoubleBlockHalf.UPPER) ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
            }

            if (HoneycombItem.getWaxedState(state).isPresent() && HoneycombItem.getWaxedState(state).get().getBlock().equals(neighborState.getBlock())) {
                return neighborState.withIfExists(HALF, state.get(HALF).equals(DoubleBlockHalf.UPPER) ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
            }

            if (getUnwaxedState(state).isPresent() && getUnwaxedState(state).get().getBlock().equals(neighborState.getBlock())) {
                return neighborState.withIfExists(HALF, state.get(HALF).equals(DoubleBlockHalf.UPPER) ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
            }
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public static Optional<BlockState> getUnwaxedState(BlockState state) {
        return Optional.ofNullable(WAXED_TO_UNWAXED_BLOCKS.get().get(state.getBlock())).map(block -> block.getStateWithProperties(state));
    }


    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
