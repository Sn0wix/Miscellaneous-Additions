package net.sn0wix_.misc_additions.common.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import net.sn0wix_.misc_additions.common.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CITRINE_GEODE_KEY = registerKey("citrine_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registerable) {
        register(registerable, CITRINE_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.LAVA), BlockStateProvider.of(ModBlocks.CITRINE_BLOCK), BlockStateProvider.of(ModBlocks.BUDDING_CITRINE), BlockStateProvider.of(Blocks.CALCITE), BlockStateProvider.of(Blocks.SMOOTH_BASALT), List.of(ModBlocks.SMALL_CITRINE_BUD.getDefaultState(), ModBlocks.MEDIUM_CITRINE_BUD.getDefaultState(), ModBlocks.LARGE_CITRINE_BUD.getDefaultState(), ModBlocks.CITRINE_CLUSTER.getDefaultState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerThicknessConfig(1.7, 2.2, 3.2, 4.2), new GeodeCrackConfig(0.95, 2.0, 2), 0.35, 0.083, true, UniformIntProvider.create(4, 6), UniformIntProvider.create(3, 4), UniformIntProvider.create(1, 2), -16, 16, 0.05, 1));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MiscAdditions.MOD_ID, id));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        registerable.register(key, new ConfiguredFeature<>(feature, config));
    }
}
