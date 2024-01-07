package net.sn0wix_.misc_additions.common.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class EndAnchorBlockEntity extends BlockEntity {
    public EndAnchorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.END_ANCHOR_BLOCK_ENTITY, pos, state);
    }
}
