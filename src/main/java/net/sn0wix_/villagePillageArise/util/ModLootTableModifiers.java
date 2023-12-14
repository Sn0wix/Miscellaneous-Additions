package net.sn0wix_.villagePillageArise.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.*;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");
    private static final Identifier SKELETON_ID = new Identifier("minecraft", "entities/skeleton");
    private static final Identifier PIGLIN_BRUTE_ID = new Identifier("minecraft", "entities/piglin_brute");
    private static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier HUSK_ID = new Identifier("minecraft", "entities/husk");
    private static final Identifier WITHER_ID = new Identifier("minecraft", "entities/wither");
    private static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    private static final Identifier IRON_GOLEM_ID = new Identifier("minecraft", "entities/iron_golem");
    private static final Identifier WITCH_ID = new Identifier("minecraft", "entities/witch");

    private static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier BASTION_TREASURE_ID = new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier BASTION_OTHER_ID = new Identifier("minecraft", "chests/bastion_other");
    private static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    private static final Identifier END_CITY_TREASURE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier VILLAGE_SAVANNA_HOUSE_ID = new Identifier("minecraft", "chests/village/village_savanna_house");
    private static final Identifier VILLAGE_PLAINS_HOUSE_ID = new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier SHIPWRECK_SUPPLY_ID = new Identifier("minecraft", "chests/shipwreck_supply");
    private static final Identifier SHIPWRECK_TREASURE_ID = new Identifier("minecraft", "chests/shipwreck_treasure");
    private static final Identifier UNDERWATER_RUINS_BIG = new Identifier("minecraft", "chests/underwater_ruin_big");
    private static final Identifier ABANDONED_MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier NETHER_BRIDGE_ID = new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier SPAWN_BONUS_CHEST_ID = new Identifier("minecraft", "chests/spawn_bonus_chest");
    private static final Identifier BURIED_TREASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier STRONGHOLD_CROSSING_ID = new Identifier("minecraft", "chests/stronghold_crossing");
    private static final Identifier STRONGHOLD_CORRIDOR_ID = new Identifier("minecraft", "chests/stronghold_corridor");
    private static final Identifier VILLAGE_CARTOGRAPHER_ID = new Identifier("minecraft", "chests/village/village_cartographer");


    private static final Identifier LAPIS_ORE_ID = new Identifier("minecraft", "blocks/lapis_ore");
    private static final Identifier DEEPSLATE_LAPIS_ORE_ID = new Identifier("minecraft", "blocks/deepslate_lapis_ore");
    private static final Identifier REDSTONE_ORE_ID = new Identifier("minecraft", "blocks/redstone_ore");
    private static final Identifier DEEPSLATE_REDSTONE_ORE_ID = new Identifier("minecraft", "blocks/deepslate_redstone_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/deepslate_diamond_ore");


    private static final Identifier TRAILS_RUINS_ID = new Identifier("minecraft", "archaeology/trail_ruins_rare");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, new EntityPredicate.Builder().type(EntityType.CREEPER)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_REVENGE));
                tableBuilder.pool(poolBuilder.build());
            }

            if (SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, new EntityPredicate.Builder().type(EntityType.SKELETON)))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.SOUL_SAND_VALLEY)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_SOULESS));
                tableBuilder.pool(poolBuilder.build());
            }

            if (PIGLIN_BRUTE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.1f, ModItems.MUSIC_DISC_BRUTE).build());
            }

            if (ELDER_GUARDIAN_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.15f, ModItems.MUSIC_DISC_GUARDIAN).build());
            }

            if (HUSK_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.05f, ModItems.MUSIC_DISC_HUSK).build());
            }

            if (WITCH_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.09f, ModItems.MUSIC_DISC_PUMPKIN).build());
            }

            if (WITHER_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(1f, ModItems.MUSIC_DISC_THE_WITHER).build());
            }

            if (WARDEN_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.5f, ModItems.MUSIC_DISC_WARDEN_RUN).build());
            }

            if (IRON_GOLEM_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.11f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_IRON_OATH));
                tableBuilder.pool(poolBuilder).build();
            }


            if (ANCIENT_CITY_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.15f, ModItems.MUSIC_DISC_SHRIEKER).build());
            }

            if (BASTION_TREASURE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.35f, ModItems.MUSIC_DISC_GILDED).build());
                tableBuilder.pool(createLootPoolBuilder(0.2f, ModItems.MUSIC_DISC_GOLD_RUSH).build());
            }

            if (BASTION_OTHER_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.06f, ModItems.MUSIC_DISC_GILDED).build());
            }

            if (PILLAGER_OUTPOST_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.5f, ModItems.MUSIC_DISC_RAIDERS).build());
            }

            if (END_CITY_TREASURE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.07f, ModItems.MUSIC_DISC_SHULKER).build());
                tableBuilder.pool(createLootPoolBuilder(0.01f, ModItems.MUSIC_DISC_THE_ENDER_DRAGON).build());
            }

            if (VILLAGE_PLAINS_HOUSE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilderWithCount(0.3f, ModItems.CORN, 1, 5).build());
                tableBuilder.pool(createLootPoolBuilderWithCount(0.1f, ModItems.CORN_SEEDS, 1, 7).build());

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.CHERRY_GROVE)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_SAKURA_VALLEY));
                tableBuilder.pool(poolBuilder).build();

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.FOREST)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_WHISPERING_WOODS));
                tableBuilder.pool(poolBuilder1).build();

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.BIRCH_FOREST)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_WHISPERING_WOODS));
                tableBuilder.pool(poolBuilder2).build();

                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.DARK_FOREST)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_WHISPERING_WOODS));
                tableBuilder.pool(poolBuilder3).build();

                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.FLOWER_FOREST)))
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_WHISPERING_WOODS));
                tableBuilder.pool(poolBuilder4).build();
            }

            if (VILLAGE_SAVANNA_HOUSE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilderWithCount(0.1f, ModItems.CORN, 1, 4).build());
                tableBuilder.pool(createLootPoolBuilderWithCount(0.08f, ModItems.CORN_SEEDS, 1, 6).build());
            }

            if (VILLAGE_CARTOGRAPHER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(LocationCheckLootCondition.builder(new LocationPredicate.Builder().biome(BiomeKeys.CHERRY_GROVE)))
                        .conditionally(RandomChanceLootCondition.builder(0.64f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(ModItems.MUSIC_DISC_SAKURA_VALLEY));
                tableBuilder.pool(poolBuilder).build();

                tableBuilder.pool(createLootPoolBuilder(0.2f, ModItems.MUSIC_DISC_ADVENTURE_AWAITS));
            }

            if (SHIPWRECK_SUPPLY_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilderWithCount(0.4f, ModItems.CORN, 1, 8).build());
            }

            if (WOODLAND_MANSION_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilderWithCount(0.15f, ModItems.CORN, 1, 5).build());
                tableBuilder.pool(createLootPoolBuilderWithCount(0.1f, ModItems.CORN_SEEDS, 1, 7).build());
                tableBuilder.pool(createLootPoolBuilder(0.08f, ModItems.MUSIC_DISC_RAIDERS).build());
                tableBuilder.pool(createLootPoolBuilder(0.08f, ModItems.MUSIC_DISC_HAUNTED_MANSION).build());
            }

            if (ABANDONED_MINESHAFT_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilderWithCount(0.17f, ModItems.CORN, 1, 5).build());
                tableBuilder.pool(createLootPoolBuilderWithCount(0.20f, ModItems.CORN_SEEDS, 1, 8).build());
                tableBuilder.pool(createLootPoolBuilder(0.06f, ModItems.MUSIC_DISC_MINESHAFT).build());
            }

            if (SHIPWRECK_TREASURE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.1f, ModItems.MUSIC_DISC_BELOW).build());
                tableBuilder.pool(createLootPoolBuilder(0.05f, ModItems.MUSIC_DISC_HORIZONS).build());
            }

            if (UNDERWATER_RUINS_BIG.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.12f, ModItems.MUSIC_DISC_BELOW).build());
            }

            if (NETHER_BRIDGE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.16f, ModItems.MUSIC_DISC_NO_ESCAPE).build());
            }

            if (BURIED_TREASURE_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.18f, ModItems.MUSIC_DISC_HORIZONS).build());
            }

            if (STRONGHOLD_CORRIDOR_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.14f, ModItems.MUSIC_DISC_LAST_HALLWAY).build());
            }

            if (STRONGHOLD_CROSSING_ID.equals(id)) {
                tableBuilder.pool(createLootPoolBuilder(0.06f, ModItems.MUSIC_DISC_LAST_HALLWAY).build());
            }



            if (LAPIS_ORE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.NETHERITE_PICKAXE)))
                        .with(ItemEntry.builder(ModItems.LAPIS_SHARD));
                tableBuilder.pool(poolBuilder).build();
            }

            if (DEEPSLATE_LAPIS_ORE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.NETHERITE_PICKAXE)))
                        .with(ItemEntry.builder(ModItems.LAPIS_SHARD));
                tableBuilder.pool(poolBuilder).build();
            }

            if (REDSTONE_ORE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.NETHERITE_PICKAXE)))
                        .with(ItemEntry.builder(ModItems.REDSTONE_SHARD));
                tableBuilder.pool(poolBuilder).build();
            }

            if (DEEPSLATE_REDSTONE_ORE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.NETHERITE_PICKAXE)))
                        .with(ItemEntry.builder(ModItems.REDSTONE_SHARD));
                tableBuilder.pool(poolBuilder).build();
            }

            if (SPAWN_BONUS_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                        .conditionally(RandomChanceLootCondition.builder(0.262f))
                        .with(ItemEntry.builder(ModBlocks.AZALEA_LOG));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            /*if (TRAILS_RUINS_ID.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.MUSIC_DISC_FADING_MEMORIES).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }*/

            if (DEEPSLATE_DIAMOND_ORE_ID.equals(id) && VillagePillageAriseMain.CONFIG.dropCrushedDiamonds) {
                LootTable.Builder poolBuilder = BlockLootTableGenerator.dropsWithSilkTouch(Blocks.DEEPSLATE_DIAMOND_ORE, applyExplosionDecay(Blocks.DEEPSLATE_DIAMOND_ORE, ItemEntry.builder(ModItems.CRUSHED_DIAMOND).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))).pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CRUSHED_DIAMOND)));
                return poolBuilder.build();
            }

            return null;
        });
    }

    public static <T extends LootFunctionConsumingBuilder<T>> T applyExplosionDecay(ItemConvertible drop, LootFunctionConsumingBuilder<T> builder) {
        return builder.apply(ExplosionDecayLootFunction.builder());
    }

    private static LootPool.Builder createLootPoolBuilder(float chance, Item item) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(item));
    }

    private static LootPool.Builder createLootPoolBuilderWithCount(float chance, Item item, float min, float max) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                .with(ItemEntry.builder(item));
    }
}
