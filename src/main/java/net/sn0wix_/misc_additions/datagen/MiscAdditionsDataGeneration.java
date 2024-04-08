package net.sn0wix_.misc_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.sn0wix_.misc_additions.common.world.ModConfiguredFeatures;
import net.sn0wix_.misc_additions.common.world.ModPlacedFeatures;

public class MiscAdditionsDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModTagsGenerator.ModBlockTagsGenerator::new);
        pack.addProvider(ModTagsGenerator.ModItemTagsGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
