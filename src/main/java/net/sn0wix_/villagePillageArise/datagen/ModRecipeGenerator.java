package net.sn0wix_.villagePillageArise.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.item.ModItems;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateSmithingRecipes(exporter);
        generateCraftingRecipes(exporter);
        generateSmeltingRecipes(exporter);
    }

    private void generateCraftingRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_MASHUP)
                .input(ModItems.MUSIC_DISC_SOULESS)
                .input(ModItems.MUSIC_DISC_SHRIEKER)
                .input(ModItems.MUSIC_DISC_LIGHTNING)
                .input(ModItems.MUSIC_DISC_THE_WITHER)
                .input(ModItems.MUSIC_DISC_THE_ENDER_DRAGON)
                .input(Items.DIAMOND, 4)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SOULESS),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SOULESS))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SHRIEKER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SHRIEKER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_LIGHTNING),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_LIGHTNING))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_WITHER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_WITHER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_THE_ENDER_DRAGON))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.MUSIC_DISC_MASHUP)));
    }

    private void generateSmeltingRecipes(Consumer<RecipeJsonProvider> exporter){
        offerSmelting(exporter, Collections.singletonList(ModItems.CORN_SEEDS),RecipeCategory.FOOD, ModItems.POPCORN, 0.1f, 10, ModItems.POPCORN.getName().toString());
    }

    private void generateSmithingRecipes(Consumer<RecipeJsonProvider> exporter){
        SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(ModItems.MUSIC_DISC_SHRIEKER), Ingredient.ofItems(ModItems.MUSIC_DISC_BRUTE), RecipeCategory.MISC, ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SHRIEKER), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_SHRIEKER)).criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_BRUTE), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_BRUTE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.MUSIC_DISC_SHRIEKER_X_BRUTE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.DIAMOND_BATTLE_AXE), Ingredient.ofItems(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ModItems.NETHERITE_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MUSIC_DISC_SHRIEKER), FabricRecipeProvider.conditionsFromItem(ModItems.DIAMOND_BATTLE_AXE)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT), FabricRecipeProvider.conditionsFromItem(ModItems.MUSIC_DISC_BRUTE)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.NETHERITE_BATTLE_AXE));


//armor
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_HELMET)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HELMET), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HELMET))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_HELMET));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_CHESTPLATE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_CHESTPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_CHESTPLATE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_LEGGINGS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_LEGGINGS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_LEGGINGS));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_BOOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_BOOTS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_BOOTS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_BOOTS));


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_HELMET)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HELMET), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HELMET))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_HELMET));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_CHESTPLATE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_CHESTPLATE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_CHESTPLATE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_LEGGINGS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_LEGGINGS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_LEGGINGS));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_BOOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_BOOTS), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_BOOTS))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_BOOTS));


//tools
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SWORD), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_SWORD));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(ModItems.NETHERITE_BATTLE_AXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(ModItems.NETHERITE_BATTLE_AXE), FabricRecipeProvider.conditionsFromItem(ModItems.NETHERITE_BATTLE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_BATTLE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.COMBAT, ModItems.LAPIS_LAZULI_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_AXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_PICKAXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_PICKAXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_PICKAXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_PICKAXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_SHOVEL), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_SHOVEL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SHOVEL), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SHOVEL))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_SHOVEL));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LAPIS_SHARD), Ingredient.ofItems(Items.NETHERITE_HOE), Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.LAPIS_LAZULI_HOE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LAPIS_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.LAPIS_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HOE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HOE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.LAPIS_LAZULI_HOE));



        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_SWORD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SWORD), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_SWORD));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(ModItems.NETHERITE_BATTLE_AXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_BATTLE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(ModItems.NETHERITE_BATTLE_AXE), FabricRecipeProvider.conditionsFromItem(ModItems.NETHERITE_BATTLE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_BATTLE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.COMBAT, ModItems.REDSTONE_AXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_AXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_AXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_AXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_PICKAXE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_PICKAXE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_PICKAXE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_PICKAXE));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_SHOVEL), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_SHOVEL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SHOVEL), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SHOVEL))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_SHOVEL));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.REDSTONE_SHARD), Ingredient.ofItems(Items.NETHERITE_HOE), Ingredient.ofItems(Items.REDSTONE), RecipeCategory.TOOLS, ModItems.REDSTONE_HOE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.REDSTONE_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.REDSTONE_SHARD)).criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_HOE), FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_HOE))
                .offerTo(exporter, FabricRecipeProvider.getRecipeName(ModItems.REDSTONE_HOE));
    }
}
