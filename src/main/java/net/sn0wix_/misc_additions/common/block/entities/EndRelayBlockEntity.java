package net.sn0wix_.misc_additions.common.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class EndRelayBlockEntity extends BlockEntity {
    public EndRelayBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.END_RELAY_BLOCK_ENTITY, pos, state);
    }
}
