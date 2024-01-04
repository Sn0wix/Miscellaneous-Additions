package net.sn0wix_.misc_additions.common.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    BATTLE_AXE_WOOD(0, 59, 2.0F, 0.0F, 15, () -> Ingredient.fromTag(ItemTags.PLANKS)),

    BATTLE_AXE_STONE(0, 131, 2.0F, 0.0F, 5, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),

    BATTLE_AXE_IRON(1, 250, 3.0F, 0.0F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    BATTLE_AXE_DIAMOND(1, 1561, 3.0F, 0.0F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),

    BATTLE_AXE_GOLD(0, 32, 4.0F, 0.0F, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),

    BATTLE_AXE_NETHERITE(1, 2031, 3.0F, 0.0F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    LAPIS_LAZULI(4, 2031, 9.0F, 4.0F, 50, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    LAPIS_LAZULI_BATTLE_AXE(1, 2031, 3.0F, 0.0F, 50, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    REDSTONE(4, 2031, 9.0F, 4.0F, 1, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    REDSTONE_BATTLE_AXE(1, 2031, 3.0F, 0.0F, 1, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
