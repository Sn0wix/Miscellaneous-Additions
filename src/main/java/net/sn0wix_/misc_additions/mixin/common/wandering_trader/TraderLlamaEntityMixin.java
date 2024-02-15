package net.sn0wix_.misc_additions.mixin.common.wandering_trader;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TraderLlamaEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Mixin(TraderLlamaEntity.class)
public abstract class TraderLlamaEntityMixin {
    @Unique
    private static final Identifier LOOT_TABLE_LOCATION = new Identifier(MiscAdditions.MOD_ID, "gameplay/trader_llama_chest");

    @Inject(method = "initialize", at = @At("RETURN"))
    private void injectInitialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        //Adding chest
        ((TraderLlamaEntity) (Object) this).getStackReference(499).set(new ItemStack(Items.CHEST));


        //Inserting loot
        ArrayList<ItemStack> lootFromTrades = new ArrayList<>(64);
        ArrayList<ItemStack> lootFromTable = new ArrayList<>(4);

        getLootTables(lootFromTrades, lootFromTable);
        ;

        ArrayList<ItemStack> finalLoot = generateFinalLoot(lootFromTrades, lootFromTable);

        MiscAdditions.LOGGER.info("loot from trades: " + lootFromTrades);
        MiscAdditions.LOGGER.info("loot from loot table: " + lootFromTable);


        //((TraderLlamaEntity) (Object) this).getStackReference();
    }

    @Unique
    private ArrayList<ItemStack> generateFinalLoot(ArrayList<ItemStack> lootFromTrades, ArrayList<ItemStack> lootFromTable) {
        Random random = new Random(((TraderLlamaEntity) (Object) this).getLootTableSeed());
        int inventorySize = ((TraderLlamaEntity) (Object) this).getInventoryColumns() * 3;

        int itemCount = random.nextInt(inventorySize);
        int currentItemIndex = random.nextInt(lootFromTrades.size());

        for (int addedItems = 0; addedItems < itemCount; addedItems++) {
            lootFromTable.add(lootFromTrades.get(currentItemIndex));
            lootFromTable.get(currentItemIndex).setCount(random.nextFloat() > 0.7 ? random.nextFloat() > 0.8 ? random.nextInt(8) : random.nextInt(4) : 1);
            lootFromTrades.remove(currentItemIndex);


            currentItemIndex = random.nextInt(lootFromTrades.size());

            if (random.nextInt(itemCount) < addedItems) {
                break;
            }
        }

        return lootFromTable;
    }

    @Unique
    private void getLootTables(ArrayList<ItemStack> lootFromTrades, ArrayList<ItemStack> lootFromTable) {
        Arrays.stream(TradeOffers.WANDERING_TRADER_TRADES.get(1)).forEach(factory -> lootFromTrades.add(factory.create(null, null).copySellItem()));
        Arrays.stream(TradeOffers.WANDERING_TRADER_TRADES.get(2)).forEach(factory -> lootFromTrades.add(factory.create(null, null).copySellItem()));

        LootTable lootTable = ((TraderLlamaEntity) (Object) this).getWorld().getServer().getLootManager().getLootTable(LOOT_TABLE_LOCATION);
        LootContextParameterSet.Builder builder = new LootContextParameterSet.Builder((ServerWorld) ((TraderLlamaEntity) (Object) this).getWorld()).add(LootContextParameters.THIS_ENTITY, ((TraderLlamaEntity) (Object) this)).add(LootContextParameters.ORIGIN, ((TraderLlamaEntity) (Object) this).getPos());

        LootContextParameterSet lootContextParameterSet = builder.build(LootContextTypes.CHEST);
        lootTable.generateLoot(lootContextParameterSet, ((TraderLlamaEntity) (Object) this).getLootTableSeed(), lootFromTable::add);
    }

    /*TODO add back to the loot table
       {
          "type": "minecraft:item",
          "name": "minecraft:potion",
          "functions": [
            {
              "function": "minecraft:set_nbt",
              "tag": "Potion:\"minecraft:long_invisibility\""
            }
          ],
          "conditions": [
            {
              "condition": "minecraft:random_chance",
              "chance": 0.15
            }
          ]
        },*/
}
