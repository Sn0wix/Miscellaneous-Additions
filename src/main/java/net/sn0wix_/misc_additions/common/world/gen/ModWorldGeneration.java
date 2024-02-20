package net.sn0wix_.misc_additions.common.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.sn0wix_.misc_additions.common.world.ModPlacedFeatures;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        generateGeodes();
    }

    private static void generateGeodes() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.LOCAL_MODIFICATIONS, ModPlacedFeatures.CITRINE_GEODE_KEY);
    }
}
