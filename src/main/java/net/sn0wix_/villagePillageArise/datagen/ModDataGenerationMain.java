package net.sn0wix_.villagePillageArise.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.sn0wix_.villagePillageArise.datagen.ModLootTableGenerator;
import net.sn0wix_.villagePillageArise.datagen.ModModelGenerator;
import net.sn0wix_.villagePillageArise.datagen.ModRecipeGenerator;
import net.sn0wix_.villagePillageArise.datagen.ModTagsGenerator;

public class ModDataGenerationMain implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModTagsGenerator.ModBlockTagsGenerator::new);
        pack.addProvider(ModTagsGenerator.ModItemTagsGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
    }
}
