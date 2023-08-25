package net.sn0wix_.villagePillageArise.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.block.custom.*;
import net.sn0wix_.villagePillageArise.sounds.ModSoundEvents;

public class ModBlocks {
    //citrine block natural, building
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new CitrineBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.7F).requiresTool()), ItemGroups.BUILDING_BLOCKS, ItemGroups.NATURAL);


    public static final Block BUDDING_CITRINE = registerBlock("budding_citrine",
            new BuddingCitrineBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).solid()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.7F).requiresTool().ticksRandomly()), ItemGroups.BUILDING_BLOCKS);


    public static final Block CITRINE_CLUSTER = registerBlock("citrine_cluster", new CitrineClusterBlock(7, 3,
            FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER).requiresTool().nonOpaque().ticksRandomly()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.7F).luminance((state) -> 5)), ItemGroups.NATURAL);


    public static final Block LARGE_CITRINE_BUD = registerBlock("large_citrine_bud",
            new CitrineClusterBlock(5, 3, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).requiresTool().luminance((state) -> 4)), ItemGroups.NATURAL);


    public static final Block MEDIUM_CITRINE_BUD = registerBlock("medium_citrine_bud",
            new CitrineClusterBlock(4, 3, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).requiresTool().luminance((blockStatex) -> 2)), ItemGroups.NATURAL);


    public static final Block SMALL_CITRINE_BUD = registerBlock("small_citrine_bud",
            new CitrineClusterBlock(3, 4, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).requiresTool().luminance((blockStatex) -> 1)), ItemGroups.NATURAL);


    public static final Block GOLDEN_CHAIN_BLOCK = registerBlock("golden_chain",
            new GoldenChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).requiresTool().nonOpaque()
                    .strength(4.8F, 5.8F).sounds(ModSoundEvents.GOLDEN_CHAIN_SOUNDS_GROUP)), ItemGroups.BUILDING_BLOCKS);

    public static final CornBlock CORN_BLOCK = (CornBlock) registerBlockWithoutBlockItem("corn_block",
            new CornBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision().breakInstantly()));


    //idk safe varargs
    @SafeVarargs
    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> ... groups){
        Item item = registerBlockItem(name,block);
        for (RegistryKey<ItemGroup> group : groups) {
            addBlockItemToGroup(item, group);
        }
        return Registry.register(Registries.BLOCK, new Identifier(VillagePillageAriseMain.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VillagePillageAriseMain.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(VillagePillageAriseMain.MOD_ID, name), block);
    }

    private static void addBlockItemToGroup(Item item, RegistryKey<ItemGroup> group){
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.add(item);
        });
    }

    public static void registerModBlocks(){
        VillagePillageAriseMain.LOGGER.info("Registering Mod blocks for " + VillagePillageAriseMain.MOD_ID);
    }
}
