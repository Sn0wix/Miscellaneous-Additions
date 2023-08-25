package net.sn0wix_.villagePillageArise.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.item.custom.*;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.item.custom.redstone.*;
import net.sn0wix_.villagePillageArise.sounds.ModSoundEvents;

public class ModItems {

    public static final Item CITRINE_SHARD = registerItem("citrine_shard",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);

    public static final Item LAPIS_SHARD = registerItem("lapis_shard",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);

    public static final Item REDSTONE_SHARD = registerItem("redstone_shard",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);

    public static final Item SWEET_BERRIES_COOKIE = registerItem("sweet_berries_cookie",
            new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_BERRIES_COOKIE)), ItemGroups.FOOD_AND_DRINK);

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN)), ItemGroups.FOOD_AND_DRINK);

    public static final Item POPCORN = registerItem("popcorn",
            new Item(new FabricItemSettings().food(ModFoodComponents.POPCORN)), ItemGroups.FOOD_AND_DRINK);

    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_BLOCK, new FabricItemSettings().food(ModFoodComponents.CORN_SEEDS)), ItemGroups.NATURAL, ItemGroups.FOOD_AND_DRINK);

    public static final Item CORN_CHOWDER = registerItem("corn_chowder",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN_CHOWDER).maxCount(1)), ItemGroups.FOOD_AND_DRINK);


    public static final Item WOODEN_BATTLE_AXE = registerItem("wooden_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_WOOD, 11F, -3.5F, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item STONE_BATTLE_AXE = registerItem("stone_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_STONE, 11.5F, -3.5F, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item GOLD_BATTLE_AXE = registerItem("golden_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_GOLD, 11F, -3.3F, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item IRON_BATTLE_AXE = registerItem("iron_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_IRON, 13F, -3.4F, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item DIAMOND_BATTLE_AXE = registerItem("diamond_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_DIAMOND, 13.5F, -3.3F, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item NETHERITE_BATTLE_AXE = registerItem("netherite_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_NETHERITE, 14F, -3.3F, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);


    public static final ArmorItem GOLDEN_CHAINMAIL_HELMET = (ArmorItem) registerItem("golden_chainmail_helmet",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.HELMET, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final ArmorItem GOLDEN_CHAINMAIL_CHESTPLATE = (ArmorItem) registerItem("golden_chainmail_chestplate",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final ArmorItem GOLDEN_CHAINMAIL_LEGGINGS = (ArmorItem) registerItem("golden_chainmail_leggings",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final ArmorItem GOLDEN_CHAINMAIL_BOOTS = (ArmorItem) registerItem("golden_chainmail_boots",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.BOOTS, new FabricItemSettings()), ItemGroups.COMBAT);


    public static final ArmorItem LAPIS_LAZULI_HELMET = (ArmorItem) registerItem("lapis_lazuli_helmet",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final ArmorItem LAPIS_LAZULI_CHESTPLATE = (ArmorItem) registerItem("lapis_lazuli_chestplate",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final ArmorItem LAPIS_LAZULI_LEGGINGS = (ArmorItem) registerItem("lapis_lazuli_leggings",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final ArmorItem LAPIS_LAZULI_BOOTS = (ArmorItem) registerItem("lapis_lazuli_boots",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final Item LAPIS_LAZULI_SWORD = registerItem("lapis_lazuli_sword",
            new SwordItem(ModToolMaterials.LAPIS_LAZULI, 3, -2.4f, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final Item LAPIS_LAZULI_BATTLE_AXE = registerItem("lapis_lazuli_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.LAPIS_LAZULI_BATTLE_AXE, 14f, -3.3f, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final Item LAPIS_LAZULI_AXE = registerItem("lapis_lazuli_axe",
            new AxeItem(ModToolMaterials.LAPIS_LAZULI, 5.0f, -3.0f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS, ItemGroups.COMBAT);

    public static final Item LAPIS_LAZULI_PICKAXE = registerItem("lapis_lazuli_pickaxe",
            new PickaxeItem(ModToolMaterials.LAPIS_LAZULI, 1, -2.8f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);

    public static final Item LAPIS_LAZULI_SHOVEL = registerItem("lapis_lazuli_shovel",
            new ShovelItem(ModToolMaterials.LAPIS_LAZULI, 1.5f, -3f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);

    public static final Item LAPIS_LAZULI_HOE = registerItem("lapis_lazuli_hoe",
            new HoeItem(ModToolMaterials.LAPIS_LAZULI, -4, 0.0f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);


    public static final RedstoneArmorItem REDSTONE_HELMET = (RedstoneArmorItem) registerItem("redstone_helmet",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.HELMET, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final RedstoneArmorItem REDSTONE_CHESTPLATE = (RedstoneArmorItem) registerItem("redstone_chestplate",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final RedstoneArmorItem REDSTONE_LEGGINGS = (RedstoneArmorItem) registerItem("redstone_leggings",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final RedstoneArmorItem REDSTONE_BOOTS = (RedstoneArmorItem) registerItem("redstone_boots",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.BOOTS, new FabricItemSettings()), ItemGroups.COMBAT);

    public static final Item REDSTONE_SWORD = registerItem("redstone_sword",
            new RedstoneSwordItem(ModToolMaterials.REDSTONE, 3, -2.4f, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);
    public static final Item REDSTONE_BATTLE_AXE = registerItem("redstone_battle_axe",
            new RedstoneBattleAxeItem(ModToolMaterials.REDSTONE_BATTLE_AXE, 14f, -3.3f, new FabricItemSettings().fireproof()), ItemGroups.COMBAT);

    public static final Item REDSTONE_AXE = registerItem("redstone_axe",
            new RedstoneAxeItem(ModToolMaterials.REDSTONE, 5.0f, -3.0f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS, ItemGroups.COMBAT);

    public static final Item REDSTONE_PICKAXE = registerItem("redstone_pickaxe",
            new RedstonePickaxeItem(ModToolMaterials.REDSTONE, 1, -2.8f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);

    public static final Item REDSTONE_SHOVEL = registerItem("redstone_shovel",
            new RedstoneShovelItem(ModToolMaterials.REDSTONE, 1.5f, -3f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);

    public static final Item REDSTONE_HOE = registerItem("redstone_hoe",
            new RedstoneHoeItem(ModToolMaterials.REDSTONE, -4, 0.0f, new FabricItemSettings().fireproof()), ItemGroups.TOOLS);


    public static final Item MUSIC_DISC_REVENGE = registerItem("music_disc_revenge",
            new MusicDiscItem(15, ModSoundEvents.REVENGE, new FabricItemSettings().maxCount(1), 218), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_GILDED = registerItem("music_disc_gilded",
            new MusicDiscItem(13, ModSoundEvents.GILDED, new FabricItemSettings().maxCount(1), 130), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_GUARDIAN = registerItem("music_disc_guardian",
            new MusicDiscItem(12, ModSoundEvents.GUARDIAN, new FabricItemSettings().maxCount(1), 140), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_HUSK = registerItem("music_disc_husk",
            new MusicDiscItem(11, ModSoundEvents.HUSK, new FabricItemSettings().maxCount(1), 127), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_RAIDERS = registerItem("music_disc_raiders",
            new MusicDiscItem(10, ModSoundEvents.RAIDERS, new FabricItemSettings().maxCount(1), 181), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_SHULKER = registerItem("music_disc_shulker",
            new MusicDiscItem(9, ModSoundEvents.SHULKER, new FabricItemSettings().maxCount(1), 185), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_THE_ENDER_DRAGON = registerItem("music_disc_the_ender_dragon",
            new MusicDiscItem(8, ModSoundEvents.THE_ENDER_DRAGON, new FabricItemSettings().maxCount(1), 170), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_THE_WITHER = registerItem("music_disc_the_wither",
            new MusicDiscItem(7, ModSoundEvents.THE_WITHER, new FabricItemSettings().maxCount(1), 143), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_BRUTE = registerItem("music_disc_brute",
            new MusicDiscItem(6, ModSoundEvents.BRUTE, new FabricItemSettings().maxCount(1), 92), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_SHRIEKER = registerItem("music_disc_shrieker",
            new MusicDiscItem(5, ModSoundEvents.SHRIEKER, new FabricItemSettings().maxCount(1), 122), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_SHRIEKER_X_BRUTE = registerItem("music_disc_shrieker_x_brute",
            new MusicDiscItem(4, ModSoundEvents.SHRIEKER_X_BRUTE, new FabricItemSettings().maxCount(1), 123), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_WARDEN_RUN = registerItem("music_disc_warden_run",
            new MusicDiscItem(3, ModSoundEvents.WARDEN_RUN, new FabricItemSettings().maxCount(1), 181), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_BELOW = registerItem("music_disc_below",
            new MusicDiscItem(2, ModSoundEvents.BELOW, new FabricItemSettings().maxCount(1), 114), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_LIGHTNING = registerItem("music_disc_lightning",
            new MusicDiscItem(1, ModSoundEvents.LIGHTNING, new FabricItemSettings().maxCount(1).fireproof(), 138), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_MASHUP = registerItem("music_disc_mashup",
            new MusicDiscItem(15, ModSoundEvents.MASHUP, new FabricItemSettings().maxCount(1), 228), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_NO_ESCAPE = registerItem("music_disc_no_escape",
            new MusicDiscItem(14, ModSoundEvents.NO_ESCAPE, new FabricItemSettings().maxCount(1), 148), ItemGroups.TOOLS);

    public static final Item MUSIC_DISC_SOULESS = registerItem("music_disc_souless",
            new MusicDiscItem(13, ModSoundEvents.SOULESS, new FabricItemSettings().maxCount(1), 140), ItemGroups.TOOLS);


    //idk safe varargs
    @SafeVarargs
    private static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... groups) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(VillagePillageAriseMain.MOD_ID, name), item);

        for (RegistryKey<ItemGroup> group : groups) {
            addItemToGroup(item1, group);
        }

        return item1;
    }

    private static void addItemToGroup(Item item, RegistryKey<ItemGroup> group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.add(item);
        });
    }

    public static void registerModItems() {
        VillagePillageAriseMain.LOGGER.info("Registering Mod items for " + VillagePillageAriseMain.MOD_ID);
    }
}
