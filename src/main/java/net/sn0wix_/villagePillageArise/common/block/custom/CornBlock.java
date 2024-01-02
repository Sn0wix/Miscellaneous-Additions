package net.sn0wix_.villagePillageArise.common.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.sn0wix_.villagePillageArise.common.item.ModItems;

public class CornBlock extends CropBlock {
    public CornBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CORN_SEEDS;
    }
}
