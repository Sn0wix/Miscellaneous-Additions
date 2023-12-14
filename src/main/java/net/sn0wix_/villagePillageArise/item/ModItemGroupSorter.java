package net.sn0wix_.villagePillageArise.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.sn0wix_.villagePillageArise.block.ModBlocks;

public class ModItemGroupSorter {
    public static void sortItemsToGroups() {
        /*TOOLS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.NETHERITE_HOE, ModItems.LAPIS_LAZULI_SHOVEL, ModItems.LAPIS_LAZULI_PICKAXE, ModItems.LAPIS_LAZULI_AXE, ModItems.LAPIS_LAZULI_HOE,
                    ModItems.REDSTONE_SHOVEL, ModItems.REDSTONE_PICKAXE, ModItems.REDSTONE_AXE, ModItems.REDSTONE_HOE);

            content.addAfter(Items.CHERRY_CHEST_BOAT, ModItems.AZALEA_BOAT, ModItems.AZALEA_CHEST_BOAT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_SWORD, ModItems.LAPIS_LAZULI_SWORD, ModItems.REDSTONE_SWORD);

            content.addAfter(Items.NETHERITE_AXE, ModItems.LAPIS_LAZULI_AXE, ModItems.REDSTONE_AXE, ModItems.WOODEN_BATTLE_AXE, ModItems.STONE_BATTLE_AXE,
                    ModItems.IRON_BATTLE_AXE, ModItems.GOLDEN_BATTLE_AXE, ModItems.DIAMOND_BATTLE_AXE, ModItems.NETHERITE_BATTLE_AXE, ModItems.LAPIS_LAZULI_BATTLE_AXE, ModItems.REDSTONE_BATTLE_AXE);

            content.addAfter(Items.CHAINMAIL_BOOTS, ModItems.GOLDEN_CHAINMAIL_HELMET, ModItems.GOLDEN_CHAINMAIL_CHESTPLATE, ModItems.GOLDEN_CHAINMAIL_LEGGINGS, ModItems.GOLDEN_CHAINMAIL_BOOTS);

            content.addAfter(Items.NETHERITE_BOOTS, ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE, ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS,
                    ModItems.REDSTONE_HELMET, ModItems.REDSTONE_CHESTPLATE, ModItems.REDSTONE_LEGGINGS, ModItems.REDSTONE_BOOTS);


        });


        /*FOOD AND DRINKS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKIE, ModItems.SWEET_BERRIES_COOKIE);

            content.addAfter(Items.BEETROOT, ModItems.CORN, ModItems.POPCORN, ModItems.CORN_SEEDS);

            content.addAfter(Items.RABBIT_STEW, ModItems.CORN_CHOWDER);
        });



        /*INGREDIENTS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addBefore(Items.DIAMOND, ModItems.CRUSHED_DIAMOND);

            content.addAfter(Items.AMETHYST_SHARD, ModItems.CITRINE_SHARD);
        });



        /*REDSTONE**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Items.IRON_DOOR, ModBlocks.COPPER_DOOR);

            content.addAfter(Items.IRON_TRAPDOOR, ModBlocks.COPPER_TRAPDOOR);
        });



        /*FUNCTIONAL BLOCKS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.CHERRY_HANGING_SIGN, ModItems.AZALEA_SIGN, ModItems.AZALEA_HANGING_SIGN);

            content.addAfter(Items.LODESTONE, ModBlocks.GUNPOWDER_BARREL);

            content.addAfter(Items.CHAIN, ModBlocks.GOLDEN_CHAIN_BLOCK);
        });



        /*NATURAL BLOCKS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.AMETHYST_CLUSTER, ModBlocks.CITRINE_BLOCK, ModBlocks.BUDDING_CITRINE, ModBlocks.SMALL_CITRINE_BUD, ModBlocks.MEDIUM_CITRINE_BUD,
                    ModBlocks.LARGE_CITRINE_BUD, ModBlocks.CITRINE_CLUSTER);

            content.addAfter(Items.CHERRY_LOG, ModBlocks.AZALEA_LOG);

            content.addAfter(Items.BEETROOT_SEEDS, ModItems.CORN_SEEDS);
        });



        /*BUILDING BLOCKS**/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.CHERRY_BUTTON, ModBlocks.AZALEA_LOG, ModBlocks.AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_WOOD,
                    ModBlocks.AZALEA_PLANKS, ModBlocks.AZALEA_STAIRS, ModBlocks.AZALEA_SLAB, ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_FENCE_GATE,
                    ModBlocks.AZALEA_DOOR, ModBlocks.AZALEA_TRAPDOOR, ModBlocks.AZALEA_PRESSURE_PLATE, ModBlocks.AZALEA_BUTTON);

            content.addAfter(Items.IRON_TRAPDOOR, ModBlocks.COPPER_DOOR, ModBlocks.EXPOSED_COPPER_DOOR, ModBlocks.WEATHERED_COPPER_DOOR, ModBlocks.OXIDIZED_COPPER_DOOR,
                    ModBlocks.WAXED_COPPER_DOOR, ModBlocks.WAXED_EXPOSED_COPPER_DOOR, ModBlocks.WAXED_WEATHERED_COPPER_DOOR, ModBlocks.WAXED_OXIDIZED_COPPER_DOOR,
                    ModBlocks.COPPER_TRAPDOOR, ModBlocks.EXPOSED_COPPER_TRAPDOOR, ModBlocks.WEATHERED_COPPER_TRAPDOOR,
                    ModBlocks.OXIDIZED_COPPER_TRAPDOOR, ModBlocks.WAXED_COPPER_TRAPDOOR, ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                    ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR, ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

            content.addAfter(Items.CHAIN, ModBlocks.GOLDEN_CHAIN_BLOCK);

            content.addAfter(Items.AMETHYST_BLOCK, ModBlocks.CITRINE_BLOCK);
        });
    }
}
