package net.sn0wix_.villagePillageArise.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class ModHangingSignBlockEntity extends ModSignBlockEntity {
    private static final int MAX_TEXT_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public ModHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public int getTextLineHeight() {
        return 9;
    }

    @Override
    public int getMaxTextWidth() {
        return 60;
    }

    @Override
    public SoundEvent getInteractionFailSound() {
        return SoundEvents.BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL;
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY;
    }
}
