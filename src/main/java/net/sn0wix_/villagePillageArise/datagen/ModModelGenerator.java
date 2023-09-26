package net.sn0wix_.villagePillageArise.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.block.ModBlockFamilies;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.block.custom.CornBlock;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerCitrine(ModBlocks.CITRINE_CLUSTER, blockStateModelGenerator);
        registerCitrine(ModBlocks.LARGE_CITRINE_BUD, blockStateModelGenerator);
        registerCitrine(ModBlocks.MEDIUM_CITRINE_BUD, blockStateModelGenerator);
        registerCitrine(ModBlocks.SMALL_CITRINE_BUD, blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_CITRINE);

        blockStateModelGenerator.registerCrop(ModBlocks.CORN_BLOCK, CornBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        registerAzaleaWoodSet(blockStateModelGenerator);
    }

    private void registerAzaleaWoodSet(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool azaleaTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZALEA_PLANKS);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZALEA_LOG, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.STRIPPED_AZALEA_LOG, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZALEA_WOOD, new Identifier(VillagePillageAriseMain.MOD_ID, "block/azalea_wood"));
        blockStateModelGenerator.registerAxisRotated(ModBlocks.STRIPPED_AZALEA_WOOD, new Identifier(VillagePillageAriseMain.MOD_ID, "block/stripped_azalea_wood"));
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_AZALEA_LOG, ModBlocks.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_WALL_HANGING_SIGN);

        azaleaTexturePool.family(ModBlockFamilies.AZALEA_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CITRINE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_BERRIES_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_CHOWDER, Models.GENERATED);


        itemModelGenerator.register(ModItems.MUSIC_DISC_REVENGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_GILDED, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_GUARDIAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_HUSK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_RAIDERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SHULKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_THE_ENDER_DRAGON, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_THE_WITHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_BRUTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SHRIEKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_WARDEN_RUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_BELOW, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_LIGHTNING, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_MASHUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_NO_ESCAPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SOULESS, Models.GENERATED);


        itemModelGenerator.registerArmor(ModItems.GOLDEN_CHAINMAIL_HELMET);
        itemModelGenerator.registerArmor(ModItems.GOLDEN_CHAINMAIL_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.GOLDEN_CHAINMAIL_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.GOLDEN_CHAINMAIL_BOOTS);
        itemModelGenerator.registerArmor(ModItems.LAPIS_LAZULI_HELMET);
        itemModelGenerator.registerArmor(ModItems.LAPIS_LAZULI_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.LAPIS_LAZULI_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.LAPIS_LAZULI_BOOTS);
        /*itemModelGenerator.registerArmor(ModItems.REDSTONE_HELMET);
        itemModelGenerator.registerArmor(ModItems.REDSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.REDSTONE_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.REDSTONE_BOOTS);*/


        itemModelGenerator.register(ModItems.WOODEN_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_BATTLE_AXE, Models.HANDHELD);


        itemModelGenerator.register(ModItems.LAPIS_LAZULI_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_SHOVEL, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AZALEA_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZALEA_SIGN, Models.GENERATED);
    }

    private void registerCitrine(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAmethyst(block);
        blockStateModelGenerator.registerItemModel(block);
    }
}
