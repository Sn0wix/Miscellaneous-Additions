package net.sn0wix_.villagePillageArise.common.block.custom;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.common.networking.ModPackets;

public class CopperTrapdoorBlock extends TrapdoorBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;

    public CopperTrapdoorBlock(Oxidizable.OxidationLevel oxidationLevel, Settings settings, BlockSetType blockSetType) {
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
        if (world.isClient) {
            return;
        }

        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != state.get(POWERED)) {
            spawnParticles(world, pos);
            playToggleSound(null, world, pos, state.get(POWERED));
            world.setBlockState(pos, state.with(POWERED, bl), Block.NOTIFY_LISTENERS);
            if (state.get(WATERLOGGED)) {
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
        }
    }

    private void spawnParticles(World world, BlockPos pos) {
        world.getPlayers().forEach(player -> {
            if (world.isPlayerInRange(pos.getX(), pos.getY(), pos.getZ(), 128)) {
                PacketByteBuf buffer = PacketByteBufs.create();
                buffer.writeBlockPos(pos);
                ServerPlayNetworking.send((ServerPlayerEntity) player, ModPackets.REDSTONE_PARTICLE_SPAWN, buffer);
            }
        });
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
