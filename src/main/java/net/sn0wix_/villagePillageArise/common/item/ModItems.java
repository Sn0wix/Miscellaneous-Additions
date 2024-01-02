package net.sn0wix_.villagePillageArise.common.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.sn0wix_.villagePillageArise.common.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.common.block.ModBlocks;
import net.sn0wix_.villagePillageArise.common.item.custom.*;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.common.item.custom.redstone.*;
import net.sn0wix_.villagePillageArise.common.sounds.ModSoundEvents;

public class ModItems {
    public static final Item CITRINE_SHARD = registerItem("citrine_shard",
            new Item(new FabricItemSettings()));

    public static final Item LAPIS_SHARD = registerItem("lapis_shard",
            new Item(new FabricItemSettings()));

    public static final Item REDSTONE_SHARD = registerItem("redstone_shard",
            new Item(new FabricItemSettings()));

    public static final Item SWEET_BERRIES_COOKIE = registerItem("sweet_berries_cookie",
            new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_BERRIES_COOKIE)));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));

    public static final Item POPCORN = registerItem("popcorn",
            new Item(new FabricItemSettings().food(ModFoodComponents.POPCORN)));

    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_BLOCK, new FabricItemSettings().food(ModFoodComponents.CORN_SEEDS)));

    public static final Item CORN_CHOWDER = registerItem("corn_chowder",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.CORN_CHOWDER).maxCount(1)));

    public static final Item CRUSHED_DIAMOND = registerItem("crushed_diamond",
            new Item(new FabricItemSettings()));



    public static final Item WOODEN_BATTLE_AXE = registerItem("wooden_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_WOOD, 11F, -3.5F, new FabricItemSettings()));

    public static final Item STONE_BATTLE_AXE = registerItem("stone_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_STONE, 11.5F, -3.5F, new FabricItemSettings()));

    public static final Item GOLDEN_BATTLE_AXE = registerItem("golden_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_GOLD, 11F, -3.3F, new FabricItemSettings()));

    public static final Item IRON_BATTLE_AXE = registerItem("iron_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_IRON, 13F, -3.4F, new FabricItemSettings()));

    public static final Item DIAMOND_BATTLE_AXE = registerItem("diamond_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_DIAMOND, 13.5F, -3.3F, new FabricItemSettings()));

    public static final Item NETHERITE_BATTLE_AXE = registerItem("netherite_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.BATTLE_AXE_NETHERITE, 14F, -3.3F, new FabricItemSettings().fireproof()));


    public static final ArmorItem GOLDEN_CHAINMAIL_HELMET = (ArmorItem) registerItem("golden_chainmail_helmet",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final ArmorItem GOLDEN_CHAINMAIL_CHESTPLATE = (ArmorItem) registerItem("golden_chainmail_chestplate",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final ArmorItem GOLDEN_CHAINMAIL_LEGGINGS = (ArmorItem) registerItem("golden_chainmail_leggings",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final ArmorItem GOLDEN_CHAINMAIL_BOOTS = (ArmorItem) registerItem("golden_chainmail_boots",
            new ArmorItem(ModArmorMaterials.GOLDEN_CHAINMAIL, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static final ArmorItem LAPIS_LAZULI_HELMET = (ArmorItem) registerItem("lapis_lazuli_helmet",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));

    public static final ArmorItem LAPIS_LAZULI_CHESTPLATE = (ArmorItem) registerItem("lapis_lazuli_chestplate",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));

    public static final ArmorItem LAPIS_LAZULI_LEGGINGS = (ArmorItem) registerItem("lapis_lazuli_leggings",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));

    public static final ArmorItem LAPIS_LAZULI_BOOTS = (ArmorItem) registerItem("lapis_lazuli_boots",
            new ArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_SWORD = registerItem("lapis_lazuli_sword",
            new SwordItem(ModToolMaterials.LAPIS_LAZULI, 3, -2.4f, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_BATTLE_AXE = registerItem("lapis_lazuli_battle_axe",
            new ModBattleAxeItem(ModToolMaterials.LAPIS_LAZULI_BATTLE_AXE, 14f, -3.3f, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_AXE = registerItem("lapis_lazuli_axe",
            new AxeItem(ModToolMaterials.LAPIS_LAZULI, 5.0f, -3.0f, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_PICKAXE = registerItem("lapis_lazuli_pickaxe",
            new PickaxeItem(ModToolMaterials.LAPIS_LAZULI, 1, -2.8f, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_SHOVEL = registerItem("lapis_lazuli_shovel",
            new ShovelItem(ModToolMaterials.LAPIS_LAZULI, 1.5f, -3f, new FabricItemSettings().fireproof()));

    public static final Item LAPIS_LAZULI_HOE = registerItem("lapis_lazuli_hoe",
            new HoeItem(ModToolMaterials.LAPIS_LAZULI, -4, 0.0f, new FabricItemSettings().fireproof()));


    public static final RedstoneArmorItem REDSTONE_HELMET = (RedstoneArmorItem) registerItem("redstone_helmet",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final RedstoneArmorItem REDSTONE_CHESTPLATE = (RedstoneArmorItem) registerItem("redstone_chestplate",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final RedstoneArmorItem REDSTONE_LEGGINGS = (RedstoneArmorItem) registerItem("redstone_leggings",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final RedstoneArmorItem REDSTONE_BOOTS = (RedstoneArmorItem) registerItem("redstone_boots",
            new RedstoneArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item REDSTONE_SWORD = registerItem("redstone_sword",
            new RedstoneSwordItem(ModToolMaterials.REDSTONE, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item REDSTONE_BATTLE_AXE = registerItem("redstone_battle_axe",
            new RedstoneBattleAxeItem(ModToolMaterials.REDSTONE_BATTLE_AXE, 14f, -3.3f, new FabricItemSettings().fireproof()));

    public static final Item REDSTONE_AXE = registerItem("redstone_axe",
            new RedstoneAxeItem(ModToolMaterials.REDSTONE, 5.0f, -3.0f, new FabricItemSettings().fireproof()));

    public static final Item REDSTONE_PICKAXE = registerItem("redstone_pickaxe",
            new RedstonePickaxeItem(ModToolMaterials.REDSTONE, 1, -2.8f, new FabricItemSettings().fireproof()));

    public static final Item REDSTONE_SHOVEL = registerItem("redstone_shovel",
            new RedstoneShovelItem(ModToolMaterials.REDSTONE, 1.5f, -3f, new FabricItemSettings().fireproof()));

    public static final Item REDSTONE_HOE = registerItem("redstone_hoe",
            new RedstoneHoeItem(ModToolMaterials.REDSTONE, -4, 0.0f, new FabricItemSettings().fireproof()));



    public static final Item MUSIC_DISC_REVENGE = registerMusicDisc("music_disc_revenge",
            new MusicDiscItem(15, ModSoundEvents.REVENGE, new FabricItemSettings().maxCount(1), 218));

    public static final Item MUSIC_DISC_GILDED = registerMusicDisc("music_disc_gilded",
            new MusicDiscItem(13, ModSoundEvents.GILDED, new FabricItemSettings().maxCount(1), 130));

    public static final Item MUSIC_DISC_GUARDIAN = registerMusicDisc("music_disc_guardian",
            new MusicDiscItem(12, ModSoundEvents.GUARDIAN, new FabricItemSettings().maxCount(1), 140));

    public static final Item MUSIC_DISC_HUSK = registerMusicDisc("music_disc_husk",
            new MusicDiscItem(11, ModSoundEvents.HUSK, new FabricItemSettings().maxCount(1), 127));

    public static final Item MUSIC_DISC_RAIDERS = registerMusicDisc("music_disc_raiders",
            new MusicDiscItem(10, ModSoundEvents.RAIDERS, new FabricItemSettings().maxCount(1), 181));

    public static final Item MUSIC_DISC_SHULKER = registerMusicDisc("music_disc_shulker",
            new MusicDiscItem(9, ModSoundEvents.SHULKER, new FabricItemSettings().maxCount(1), 185));

    public static final Item MUSIC_DISC_THE_ENDER_DRAGON = registerMusicDisc("music_disc_the_ender_dragon",
            new MusicDiscItem(8, ModSoundEvents.THE_ENDER_DRAGON, new FabricItemSettings().maxCount(1), 170));

    public static final Item MUSIC_DISC_THE_WITHER = registerMusicDisc("music_disc_the_wither",
            new MusicDiscItem(7, ModSoundEvents.THE_WITHER, new FabricItemSettings().maxCount(1), 143));

    public static final Item MUSIC_DISC_BRUTE = registerMusicDisc("music_disc_brute",
            new MusicDiscItem(6, ModSoundEvents.BRUTE, new FabricItemSettings().maxCount(1), 92));

    public static final Item MUSIC_DISC_SHRIEKER = registerMusicDisc("music_disc_shrieker",
            new MusicDiscItem(5, ModSoundEvents.SHRIEKER, new FabricItemSettings().maxCount(1), 122));

    public static final Item MUSIC_DISC_SHRIEKER_X_BRUTE = registerMusicDisc("music_disc_shrieker_x_brute",
            new MusicDiscItem(4, ModSoundEvents.SHRIEKER_X_BRUTE, new FabricItemSettings().maxCount(1), 123));

    public static final Item MUSIC_DISC_WARDEN_RUN = registerMusicDisc("music_disc_warden_run",
            new MusicDiscItem(3, ModSoundEvents.WARDEN_RUN, new FabricItemSettings().maxCount(1), 181));

    public static final Item MUSIC_DISC_BELOW = registerMusicDisc("music_disc_below",
            new MusicDiscItem(2, ModSoundEvents.BELOW, new FabricItemSettings().maxCount(1), 114));

    public static final Item MUSIC_DISC_LIGHTNING = registerMusicDisc("music_disc_lightning",
            new MusicDiscItem(1, ModSoundEvents.LIGHTNING, new FabricItemSettings().maxCount(1).fireproof(), 138));

    public static final Item MUSIC_DISC_MASHUP = registerMusicDisc("music_disc_mashup",
            new MusicDiscItem(15, ModSoundEvents.MASHUP, new FabricItemSettings().maxCount(1), 228));

    public static final Item MUSIC_DISC_NO_ESCAPE = registerMusicDisc("music_disc_no_escape",
            new MusicDiscItem(14, ModSoundEvents.NO_ESCAPE, new FabricItemSettings().maxCount(1), 148));

    public static final Item MUSIC_DISC_SOULESS = registerMusicDisc("music_disc_souless",
            new MusicDiscItem(13, ModSoundEvents.SOULESS, new FabricItemSettings().maxCount(1), 140));
    public static final Item MUSIC_DISC_MINESHAFT = registerMusicDisc("music_disc_mineshaft",
            new MusicDiscItem(7, ModSoundEvents.MINESHAFT, new FabricItemSettings().maxCount(1), 123));
    public static final Item MUSIC_DISC_PUMPKIN = registerMusicDisc("music_disc_pumpkin",
            new MusicDiscItem(3, ModSoundEvents.PUMPKIN, new FabricItemSettings().maxCount(1), 93));


    public static final Item MUSIC_DISC_FADING_MEMORIES = registerMusicDisc("music_disc_fading_memories",
            new MusicDiscItem(12, ModSoundEvents.FADING_MEMORIES, new FabricItemSettings().maxCount(1), 155));
    public static final Item MUSIC_DISC_HORIZONS = registerMusicDisc("music_disc_horizons",
            new MusicDiscItem(11, ModSoundEvents.HORIZONS, new FabricItemSettings().maxCount(1), 121));

    public static final Item MUSIC_DISC_IRON_OATH = registerMusicDisc("music_disc_iron_oath",
            new MusicDiscItem(10, ModSoundEvents.IRON_OATH, new FabricItemSettings().maxCount(1), 121));

    public static final Item MUSIC_DISC_LAST_HALLWAY = registerMusicDisc("music_disc_last_hallway",
            new MusicDiscItem(9, ModSoundEvents.LAST_HALLWAY, new FabricItemSettings().maxCount(1), 154));

    public static final Item MUSIC_DISC_SAKURA_VALLEY = registerMusicDisc("music_disc_sakura_valley",
            new MusicDiscItem(8, ModSoundEvents.SAKURA_VALLEY, new FabricItemSettings().maxCount(1), 119));

    public static final Item MUSIC_DISC_WHISPERING_WOODS = registerMusicDisc("music_disc_whispering_woods",
            new MusicDiscItem(6, ModSoundEvents.WHISPERING_WOODS, new FabricItemSettings().maxCount(1), 139));

    public static final Item MUSIC_DISC_ADVENTURE_AWAITS = registerMusicDisc("music_disc_adventure_awaits",
            new MusicDiscItem(5, ModSoundEvents.ADVENTURE_AWAITS, new FabricItemSettings().maxCount(1), 95));

    public static final Item MUSIC_DISC_FINAL_STAGE = registerMusicDisc("music_disc_final_stage",
            new MusicDiscItem(4, ModSoundEvents.FINAL_STAGE, new FabricItemSettings().maxCount(1), 120));
    public static final Item MUSIC_DISC_HAUNTED_MANSION = registerMusicDisc("music_disc_hunted_mansion",
            new MusicDiscItem(2, ModSoundEvents.HAUNTED_MANSION, new FabricItemSettings().maxCount(1), 148));

    public static final Item MUSIC_DISC_GOLD_RUSH = registerMusicDisc("music_disc_gold_rush",
            new MusicDiscItem(1, ModSoundEvents.GOLD_RUSH, new FabricItemSettings().maxCount(1), 166));



    public static final SignItem AZALEA_SIGN = (SignItem) registerItem("azalea_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_WALL_SIGN));

    public static final HangingSignItem AZALEA_HANGING_SIGN = (HangingSignItem) registerItem("azalea_hanging_sign",
            new HangingSignItem(ModBlocks.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    public static final ModBoatItem AZALEA_BOAT = (ModBoatItem) registerItem("azalea_boat", new ModBoatItem(new FabricItemSettings().maxCount(1), false));
    public static final ModBoatItem AZALEA_CHEST_BOAT = (ModBoatItem) registerItem("azalea_chest_boat", new ModBoatItem(new FabricItemSettings().maxCount(1), true));



    private static Item registerItem(String name, Item item) {
         return Registry.register(Registries.ITEM, new Identifier(VillagePillageAriseMain.MOD_ID, name), item);
    }

    private static Item registerMusicDisc(String name, Item item) {
        Item item1 = Registry.register(Registries.ITEM, new Identifier(VillagePillageAriseMain.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> content.addAfter(Items.MUSIC_DISC_PIGSTEP, item1));
        return item1;
    }
    public static void registerModItems() {
        VillagePillageAriseMain.LOGGER.info("Registering Mod items for " + VillagePillageAriseMain.MOD_ID);
    }
}
