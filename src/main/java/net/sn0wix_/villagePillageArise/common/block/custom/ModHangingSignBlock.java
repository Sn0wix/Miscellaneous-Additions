package net.sn0wix_.villagePillageArise.common.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.sn0wix_.villagePillageArise.common.block.entities.ModHangingSignBlockEntity;

public class ModHangingSignBlock extends HangingSignBlock {
    public ModHangingSignBlock(Settings settings, WoodType woodType) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModHangingSignBlockEntity(pos, state);
    }
}