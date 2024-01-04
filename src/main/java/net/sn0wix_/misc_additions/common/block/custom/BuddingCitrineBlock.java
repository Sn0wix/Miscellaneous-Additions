package net.sn0wix_.misc_additions.common.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.sn0wix_.misc_additions.common.block.ModBlocks;

public class BuddingCitrineBlock extends CitrineBlock {

    public static final int GROW_CHANCE = 8;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingCitrineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (random.nextInt(GROW_CHANCE) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_CITRINE_BUD;
            } else if (blockState.isOf(ModBlocks.SMALL_CITRINE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_CITRINE_BUD;
            } else if (blockState.isOf(ModBlocks.MEDIUM_CITRINE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_CITRINE_BUD;
            } else if (blockState.isOf(ModBlocks.LARGE_CITRINE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.CITRINE_CLUSTER;
            }

            if (block != null) {
                BlockState blockState2 = (block.getDefaultState().with(AmethystClusterBlock.FACING, direction)).with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }

        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
