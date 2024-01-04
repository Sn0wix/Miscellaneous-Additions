package net.sn0wix_.misc_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public class MiscAdditionsDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        System.out.println("datagen;lsdfhpl;wakjehf kasjdh olksjnv laskhj oakjnweaf uibb ");
        MiscAdditions.LOGGER.info("datagen;lsdfhpl;wakjehf kasjdh olksjnv laskhj oakjnweaf uibb ");

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModTagsGenerator.ModBlockTagsGenerator::new);
        pack.addProvider(ModTagsGenerator.ModItemTagsGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
    }
}
