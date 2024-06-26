package net.sn0wix_.misc_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.block.ModBlocks;
import net.sn0wix_.misc_additions.common.item.ModItems;
import net.sn0wix_.misc_additions.common.util.tags.ModItemTags;

import java.util.Collections;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateSmithingRecipes(exporter);
        generateCraftingRecipes(exporter);
        generateSmeltingRecipes(exporter);
    }

    private void generateCraftingRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_MASHUP)
                .input(ModItems.MUSIC_DISC_SOULESS)
                .input(ModItems.MUSIC_DISC_SHRIEKER)
                .input(ModItems.MUSIC_DISC_LIGHTNING)
                .input(ModItems.MUSIC_DISC_THE_WITHER)
                .input(ModItems.MUSIC_DISC_THE_ENDER_DRAGON)
                .input(Items.DIAMOND, 4)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SOULESS), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SOULESS))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SHRIEKER), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SHRIEKER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_LIGHTNING), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_LIGHTNING))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_WITHER), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_WITHER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.MUSIC_DISC_MASHUP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.END_RELAY)
                .pattern("oco")
                .pattern("cec")
                .pattern("oco")
                .input('o', Blocks.OBSIDIAN)
                .input('c', Items.POPPED_CHORUS_FRUIT)
                .input('e', Items.ENDER_EYE)
                .criterion(FabricRecipeProvider.hasItem(Blocks.OBSIDIAN), FabricRecipeProvider.conditionsFromItem(Blocks.OBSIDIAN))
                .criterion(FabricRecipeProvider.hasItem(Items.POPPED_CHORUS_FRUIT), FabricRecipeProvider.conditionsFromItem(Items.POPPED_CHORUS_FRUIT))
                .criterion(FabricRecipeProvider.hasItem(Items.ENDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.ENDER_EYE))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.END_RELAY), FabricRecipeProvider.conditionsFromItem(ModBlocks.END_RELAY))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.END_RELAY)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GUNPOWDER_BARREL)
                .input(Items.BARREL)
                .input(Items.GUNPOWDER, 8)
                .criterion(FabricRecipeProvider.hasItem(Items.BARREL), FabricRecipeProvider.conditionsFromItem(Items.BARREL))
                .criterion(FabricRecipeProvider.hasItem(Items.GUNPOWDER), FabricRecipeProvider.conditionsFromItem(Items.GUNPOWDER))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GUNPOWDER_BARREL), FabricRecipeProvider.conditionsFromItem(ModBlocks.GUNPOWDER_BARREL))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GUNPOWDER_BARREL)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND)
                .input(ModItems.DIAMOND_SHERD, 4)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIAMOND_SHERD), FabricRecipeProvider.conditionsFromItem(ModItems.DIAMOND_SHERD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Items.DIAMOND)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_SHERD, 4)
                .input(Items.DIAMOND)
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND), FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.DIAMOND_SHERD)));


        //lanterns
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GOLDEN_LANTERN_BLOCK)
                .pattern("iii")
                .pattern("iti")
                .pattern("iii")
                .input('i', Items.GOLD_NUGGET)
                .input('t', Items.TORCH)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_NUGGET), FabricRecipeProvider.conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(FabricRecipeProvider.hasItem(Items.TORCH), FabricRecipeProvider.conditionsFromItem(Items.TORCH))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GOLDEN_LANTERN_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.GOLDEN_LANTERN_BLOCK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GOLDEN_LANTERN_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK)
                .pattern("iii")
                .pattern("iti")
                .pattern("iii")
                .input('i', Items.GOLD_NUGGET)
                .input('t', Items.SOUL_TORCH)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_NUGGET), FabricRecipeProvider.conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(FabricRecipeProvider.hasItem(Items.SOUL_TORCH), FabricRecipeProvider.conditionsFromItem(Items.SOUL_TORCH))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK)));


        //azalea wood
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_WOOD, 3)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.AZALEA_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_WOOD), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_WOOD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.AZALEA_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_AZALEA_WOOD, 3)
                .pattern("ll")
                .pattern("ll")
                .input('l', ModBlocks.STRIPPED_AZALEA_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_AZALEA_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_AZALEA_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_AZALEA_WOOD), FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_AZALEA_WOOD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.STRIPPED_AZALEA_WOOD)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AZALEA_BUTTON)
                .input(ModBlocks.AZALEA_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.AZALEA_BUTTON)));

        createDoorRecipe(ModBlocks.AZALEA_DOOR, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_DOOR), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_DOOR)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.AZALEA_TRAPDOOR, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_TRAPDOOR), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_TRAPDOOR)).offerTo(exporter);
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.AZALEA_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PRESSURE_PLATE), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PRESSURE_PLATE)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createFenceRecipe(ModBlocks.AZALEA_FENCE, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS, Items.STICK)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_FENCE), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_FENCE)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.AZALEA_FENCE_GATE, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS, Items.STICK)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_FENCE_GATE), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_FENCE_GATE)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_SLAB, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_SLAB), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_SLAB)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createStairsRecipe(ModBlocks.AZALEA_STAIRS, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_STAIRS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_STAIRS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        createSignRecipe(ModItems.AZALEA_SIGN, Ingredient.ofItems(ModBlocks.AZALEA_PLANKS, Items.STICK)).criterion(FabricRecipeProvider.hasItem(ModItems.AZALEA_SIGN), FabricRecipeProvider.conditionsFromItem(ModItems.AZALEA_SIGN)).criterion(FabricRecipeProvider.hasItem(ModBlocks.AZALEA_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.AZALEA_PLANKS)).offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_PLANKS);
        offerPlanksRecipe(exporter, ModBlocks.AZALEA_PLANKS, ModItemTags.AZALEA_LOGS, 4);
        offerBoatRecipe(exporter, ModItems.AZALEA_BOAT, ModBlocks.AZALEA_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.AZALEA_CHEST_BOAT, ModBlocks.AZALEA_PLANKS);


        //copper
        createDoorRecipe(ModBlocks.COPPER_DOOR, Ingredient.ofItems(Items.COPPER_INGOT)).criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT)).criterion(FabricRecipeProvider.hasItem(ModBlocks.COPPER_DOOR), FabricRecipeProvider.conditionsFromItem(ModBlocks.COPPER_DOOR)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.COPPER_TRAPDOOR, Ingredient.ofItems(Items.COPPER_INGOT)).criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT)).criterion(FabricRecipeProvider.hasItem(ModBlocks.COPPER_TRAPDOOR), FabricRecipeProvider.conditionsFromItem(ModBlocks.COPPER_TRAPDOOR)).offerTo(exporter);
    }

    private void generateSmeltingRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, Collections.singletonList(ModItems.CORN_SEEDS), RecipeCategory.FOOD, ModItems.POPCORN, 0.1f, 10, ModItems.POPCORN.getName().toString());
    }

    private void generateSmithingRecipes(RecipeExporter exporter) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(ModItems.MUSIC_DISC_SHRIEKER), Ingredient.ofItems(ModItems.MUSIC_DISC_BRUTE), RecipeCategory.MISC, ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SHRIEKER), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SHRIEKER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_BRUTE), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_BRUTE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.DIAMOND_BATTLE_AXE), Ingredient.ofItems(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ModItems.NETHERITE_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIAMOND_BATTLE_AXE), FabricRecipeProvider.conditionsFromItem(ModItems.DIAMOND_BATTLE_AXE))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.NETHERITE_BATTLE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.LAVA_BUCKET), Ingredient.ofItems(ModItems.MUSIC_DISC_THE_ENDER_DRAGON), Ingredient.ofItems(ModItems.MUSIC_DISC_THE_WITHER), RecipeCategory.MISC, ModItems.MUSIC_DISC_FINAL_STAGE)
                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_WITHER), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_WITHER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_FINAL_STAGE), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_FINAL_STAGE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.MUSIC_DISC_FINAL_STAGE));


        //armor
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_HELMET)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HELMET), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HELMET))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_HELMET));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_CHESTPLATE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_CHESTPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_CHESTPLATE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_LEGGINGS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_LEGGINGS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_LEGGINGS));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_BOOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_BOOTS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_BOOTS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_BOOTS));


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_HELMET)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HELMET), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HELMET))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_HELMET));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_CHESTPLATE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_CHESTPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_CHESTPLATE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_LEGGINGS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_LEGGINGS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_LEGGINGS));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_BOOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_BOOTS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_BOOTS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_BOOTS));


        //tools
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SWORD), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_SWORD));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(ModItems.NETHERITE_BATTLE_AXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(ModItems.NETHERITE_BATTLE_AXE), FabricRecipeProvider.conditionsFromItem(ModItems.NETHERITE_BATTLE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_BATTLE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_AXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_PICKAXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_PICKAXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_PICKAXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_PICKAXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_SHOVEL), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_SHOVEL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SHOVEL), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SHOVEL))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_SHOVEL));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_HOE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_HOE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HOE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HOE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_HOE));


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SWORD), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_SWORD));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(ModItems.NETHERITE_BATTLE_AXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(ModItems.NETHERITE_BATTLE_AXE), FabricRecipeProvider.conditionsFromItem(ModItems.NETHERITE_BATTLE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_BATTLE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_AXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_PICKAXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_PICKAXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_PICKAXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_PICKAXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_SHOVEL), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_SHOVEL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SHOVEL), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SHOVEL))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_SHOVEL));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_HOE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_HOE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HOE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HOE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_HOE));
    }
}
