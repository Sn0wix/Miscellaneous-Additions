package net.sn0wix_.villagePillageArise.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.sn0wix_.villagePillageArise.common.block.ModBlocks;
import net.sn0wix_.villagePillageArise.common.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AZALEA_SIGN, ModItems.AZALEA_SIGN);
        addDrop(ModBlocks.AZALEA_HANGING_SIGN, ModItems.AZALEA_HANGING_SIGN);
        addDrop(ModBlocks.AZALEA_STAIRS);
        addDrop(ModBlocks.AZALEA_TRAPDOOR);
        addDrop(ModBlocks.AZALEA_PRESSURE_PLATE);
        addDrop(ModBlocks.AZALEA_PLANKS);
        addDrop(ModBlocks.AZALEA_FENCE_GATE);
        addDrop(ModBlocks.STRIPPED_AZALEA_WOOD);
        addDrop(ModBlocks.AZALEA_WOOD);
        addDrop(ModBlocks.AZALEA_LOG);
        addDrop(ModBlocks.STRIPPED_AZALEA_LOG);
        addDrop(ModBlocks.AZALEA_BUTTON);
        addDrop(ModBlocks.AZALEA_FENCE);
    }
}
