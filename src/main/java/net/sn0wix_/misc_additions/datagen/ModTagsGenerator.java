package net.sn0wix_.misc_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.sn0wix_.misc_additions.common.block.ModBlocks;
import net.sn0wix_.misc_additions.common.item.ModItems;
import net.sn0wix_.misc_additions.common.util.tags.ModBlockTags;
import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;

import java.util.concurrent.CompletableFuture;

public class ModTagsGenerator {

    public static class ModBlockTagsGenerator extends FabricTagProvider.BlockTagProvider {
        public ModBlockTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            addPickaxeMineable();
            addNeedsStoneTool();
            addNeedsDiamondTool();
            addRedstoneRechargeable();
            addAzaleaWoodSet();
            addDoor();
        }

        private void addPickaxeMineable() {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(ModBlocks.GOLDEN_CHAIN_BLOCK)
                    .add(ModBlocks.CITRINE_BLOCK)
                    .add(ModBlocks.BUDDING_CITRINE)
                    .add(ModBlocks.CITRINE_CLUSTER)
                    .add(ModBlocks.LARGE_CITRINE_BUD)
                    .add(ModBlocks.MEDIUM_CITRINE_BUD)
                    .add(ModBlocks.SMALL_CITRINE_BUD)
                    .add(ModBlocks.COPPER_DOOR)
                    .add(ModBlocks.EXPOSED_COPPER_DOOR)
                    .add(ModBlocks.WEATHERED_COPPER_DOOR)
                    .add(ModBlocks.OXIDIZED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR)
                    .add(ModBlocks.COPPER_TRAPDOOR)
                    .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR)
                    .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR)
                    .add(ModBlocks.END_RELAY)
                    .add(ModBlocks.GOLDEN_LANTERN_BLOCK)
                    .add(ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK);
        }

        private void addDoor() {
            getOrCreateTagBuilder(BlockTags.DOORS)
                    .add(ModBlocks.COPPER_DOOR)
                    .add(ModBlocks.EXPOSED_COPPER_DOOR)
                    .add(ModBlocks.WEATHERED_COPPER_DOOR)
                    .add(ModBlocks.OXIDIZED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR)
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR);

            getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                    .add(ModBlocks.COPPER_TRAPDOOR)
                    .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR)
                    .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
        }
        private void addNeedsStoneTool() {
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                    .add(ModBlocks.CITRINE_BLOCK)
                    .add(ModBlocks.BUDDING_CITRINE)
                    .add(ModBlocks.CITRINE_CLUSTER)
                    .add(ModBlocks.LARGE_CITRINE_BUD)
                    .add(ModBlocks.MEDIUM_CITRINE_BUD)
                    .add(ModBlocks.SMALL_CITRINE_BUD);
        }

        private void addNeedsDiamondTool() {
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                    .add(ModBlocks.END_RELAY);
        }

        private void addAzaleaWoodSet() {
            getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.AZALEA_PLANKS);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.AZALEA_STAIRS);
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.AZALEA_PRESSURE_PLATE);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.AZALEA_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.AZALEA_FENCE);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.AZALEA_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.AZALEA_DOOR);
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.AZALEA_BUTTON);

            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.AZALEA_FENCE_GATE);

            getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.AZALEA_SIGN);
            getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.AZALEA_WALL_SIGN);
            getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.AZALEA_HANGING_SIGN);
            getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.AZALEA_WALL_HANGING_SIGN);

            getOrCreateTagBuilder(ModBlockTags.AZALEA_LOGS).add(ModBlocks.AZALEA_LOG)
                    .add(ModBlocks.STRIPPED_AZALEA_LOG)
                    .add(ModBlocks.AZALEA_WOOD)
                    .add(ModBlocks.STRIPPED_AZALEA_WOOD);

            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).forceAddTag(ModBlockTags.AZALEA_LOGS);
        }

        private void addRedstoneRechargeable() {
            getOrCreateTagBuilder(ModBlockTags.REDSTONE_EQUIPMENT_RECHARGEABLE)
                    .add(Blocks.REDSTONE_BLOCK)
                    .add(Blocks.REDSTONE_ORE)
                    .add(Blocks.DEEPSLATE_REDSTONE_ORE);
        }
    }


    public static class ModItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
        public ModItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            addTrimmableArmor();
            addMusicDiscs();
            addAzaleaWoodSet();
            addRedstoneEquipment();
            addDoor();
            addBattleAxes();
            addEndAnchorRechargeable();
        }

        private void addDoor() {
            getOrCreateTagBuilder(ItemTags.DOORS)
                    .add(ModBlocks.COPPER_DOOR.asItem())
                    .add(ModBlocks.EXPOSED_COPPER_DOOR.asItem())
                    .add(ModBlocks.WEATHERED_COPPER_DOOR.asItem())
                    .add(ModBlocks.OXIDIZED_COPPER_DOOR.asItem())
                    .add(ModBlocks.WAXED_COPPER_DOOR.asItem())
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.asItem())
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.asItem())
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.asItem());

            getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                    .add(ModBlocks.COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.WAXED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.asItem())
                    .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.asItem());
        }

        private void addMusicDiscs() {
            getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                    .add(ModItems.MUSIC_DISC_REVENGE)
                    .add(ModItems.MUSIC_DISC_GILDED)
                    .add(ModItems.MUSIC_DISC_GUARDIAN)
                    .add(ModItems.MUSIC_DISC_HUSK)
                    .add(ModItems.MUSIC_DISC_RAIDERS)
                    .add(ModItems.MUSIC_DISC_SHULKER)
                    .add(ModItems.MUSIC_DISC_THE_ENDER_DRAGON)
                    .add(ModItems.MUSIC_DISC_THE_WITHER)
                    .add(ModItems.MUSIC_DISC_BRUTE)
                    .add(ModItems.MUSIC_DISC_SHRIEKER)
                    .add(ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE)
                    .add(ModItems.MUSIC_DISC_WARDEN_RUN)
                    .add(ModItems.MUSIC_DISC_BELOW)
                    .add(ModItems.MUSIC_DISC_LIGHTNING)
                    .add(ModItems.MUSIC_DISC_MASHUP)
                    .add(ModItems.MUSIC_DISC_NO_ESCAPE)
                    .add(ModItems.MUSIC_DISC_SOULESS)
                    .add(ModItems.MUSIC_DISC_PUMPKIN)
                    .add(ModItems.MUSIC_DISC_FADING_MEMORIES)
                    .add(ModItems.MUSIC_DISC_HORIZONS)
                    .add(ModItems.MUSIC_DISC_IRON_OATH)
                    .add(ModItems.MUSIC_DISC_LAST_HALLWAY)
                    .add(ModItems.MUSIC_DISC_SAKURA_VALLEY)
                    .add(ModItems.MUSIC_DISC_MINESHAFT)
                    .add(ModItems.MUSIC_DISC_WHISPERING_WOODS)
                    .add(ModItems.MUSIC_DISC_ADVENTURE_AWAITS)
                    .add(ModItems.MUSIC_DISC_FINAL_STAGE)
                    .add(ModItems.MUSIC_DISC_HAUNTED_MANSION)
                    .add(ModItems.MUSIC_DISC_GOLD_RUSH);
        }

        private void addAzaleaWoodSet() {
            getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.AZALEA_PLANKS.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.AZALEA_STAIRS.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.AZALEA_PRESSURE_PLATE.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.AZALEA_SLAB.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.AZALEA_FENCE.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.AZALEA_TRAPDOOR.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.AZALEA_DOOR.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.AZALEA_BUTTON.asItem());
            getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.AZALEA_FENCE_GATE.asItem());
            getOrCreateTagBuilder(ItemTags.BOATS).add(ModItems.AZALEA_BOAT);
            getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModItems.AZALEA_CHEST_BOAT);


            getOrCreateTagBuilder(ModItemTags.AZALEA_LOGS).add(ModBlocks.AZALEA_LOG.asItem())
                    .add(ModBlocks.STRIPPED_AZALEA_LOG.asItem())
                    .add(ModBlocks.AZALEA_WOOD.asItem())
                    .add(ModBlocks.STRIPPED_AZALEA_WOOD.asItem());

            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).forceAddTag(ModItemTags.AZALEA_LOGS);
        }

        private void addTrimmableArmor() {
            getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                    .add(ModItems.GOLDEN_CHAINMAIL_HELMET)
                    .add(ModItems.GOLDEN_CHAINMAIL_CHESTPLATE)
                    .add(ModItems.GOLDEN_CHAINMAIL_LEGGINGS)
                    .add(ModItems.GOLDEN_CHAINMAIL_BOOTS)
                    .add(ModItems.LAPIS_LAZULI_HELMET)
                    .add(ModItems.LAPIS_LAZULI_CHESTPLATE)
                    .add(ModItems.LAPIS_LAZULI_LEGGINGS)
                    .add(ModItems.LAPIS_LAZULI_BOOTS)
                    .add(ModItems.REDSTONE_HELMET)
                    .add(ModItems.REDSTONE_CHESTPLATE)
                    .add(ModItems.REDSTONE_LEGGINGS)
                    .add(ModItems.REDSTONE_BOOTS);
        }

        private void addRedstoneEquipment() {
            getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.REDSTONE_PICKAXE).add(ModItems.LAPIS_LAZULI_PICKAXE);
            getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.REDSTONE_SWORD).add(ModItems.LAPIS_LAZULI_SWORD);
            getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.REDSTONE_AXE).add(ModItems.LAPIS_LAZULI_AXE);
            getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.REDSTONE_SHOVEL).add(ModItems.LAPIS_LAZULI_SHOVEL);
            getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.REDSTONE_HOE).add(ModItems.LAPIS_LAZULI_HOE);
        }

        private void addBattleAxes() {
            getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.WOODEN_BATTLE_AXE)
                    .add(ModItems.STONE_BATTLE_AXE)
                    .add(ModItems.IRON_BATTLE_AXE)
                    .add(ModItems.GOLDEN_BATTLE_AXE)
                    .add(ModItems.DIAMOND_BATTLE_AXE)
                    .add(ModItems.NETHERITE_BATTLE_AXE)
                    .add(ModItems.LAPIS_LAZULI_BATTLE_AXE)
                    .add(ModItems.REDSTONE_BATTLE_AXE);

            getOrCreateTagBuilder(ModItemTags.BATTLE_AXES).add(ModItems.WOODEN_BATTLE_AXE)
                    .add(ModItems.STONE_BATTLE_AXE)
                    .add(ModItems.IRON_BATTLE_AXE)
                    .add(ModItems.GOLDEN_BATTLE_AXE)
                    .add(ModItems.DIAMOND_BATTLE_AXE)
                    .add(ModItems.NETHERITE_BATTLE_AXE)
                    .add(ModItems.LAPIS_LAZULI_BATTLE_AXE)
                    .add(ModItems.REDSTONE_BATTLE_AXE);
        }

        private void addEndAnchorRechargeable() {
            getOrCreateTagBuilder(ModItemTags.END_RELAY_CHARGEABLE)
                    .add(Items.END_CRYSTAL);
        }
    }
}
