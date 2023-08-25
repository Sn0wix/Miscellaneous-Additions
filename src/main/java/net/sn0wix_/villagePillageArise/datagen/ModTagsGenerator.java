package net.sn0wix_.villagePillageArise.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.item.ModItems;
import net.sn0wix_.villagePillageArise.util.ModTags;

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
            addRedstoneEquipmentRechargeable();
        }

        private void addPickaxeMineable() {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(ModBlocks.GOLDEN_CHAIN_BLOCK)
                    .add(ModBlocks.CITRINE_BLOCK)
                    .add(ModBlocks.BUDDING_CITRINE)
                    .add(ModBlocks.CITRINE_CLUSTER)
                    .add(ModBlocks.LARGE_CITRINE_BUD)
                    .add(ModBlocks.MEDIUM_CITRINE_BUD)
                    .add(ModBlocks.SMALL_CITRINE_BUD);
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

        private void addRedstoneEquipmentRechargeable() {
            getOrCreateTagBuilder(ModTags.REDSTONE_EQUIPMENT_RECHARGEABLE)
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
        }

        private void addMusicDiscs(){
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
                    .add(ModItems.MUSIC_DISC_SOULESS);

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
    }
}
