package net.sn0wix_.villagePillageArise.block;


import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    public static final BlockFamily AZALEA_FAMILY = registerBlockFamily(ModBlocks.AZALEA_PLANKS).button(ModBlocks.AZALEA_BUTTON).door(ModBlocks.AZALEA_DOOR)
            .fence(ModBlocks.AZALEA_FENCE).fenceGate(ModBlocks.AZALEA_FENCE_GATE).pressurePlate(ModBlocks.AZALEA_PRESSURE_PLATE).slab(ModBlocks.AZALEA_SLAB).
            stairs(ModBlocks.AZALEA_STAIRS).trapdoor(ModBlocks.AZALEA_TRAPDOOR).fence(ModBlocks.AZALEA_FENCE).fenceGate(ModBlocks.AZALEA_FENCE_GATE)
            .sign(ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_WALL_SIGN).build();

    public static BlockFamily.Builder registerBlockFamily(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        }
        return builder;
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}
