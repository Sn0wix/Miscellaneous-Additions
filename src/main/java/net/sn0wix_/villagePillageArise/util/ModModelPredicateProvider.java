package net.sn0wix_.villagePillageArise.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModModelPredicateProvider {

    public static void registerModules() {
        registerRedstoneTools(ModItems.REDSTONE_SWORD);
        registerRedstoneTools(ModItems.REDSTONE_BATTLE_AXE);
        registerRedstoneTools(ModItems.REDSTONE_PICKAXE);
        registerRedstoneTools(ModItems.REDSTONE_SHOVEL);
        registerRedstoneTools(ModItems.REDSTONE_HOE);
        registerRedstoneTools(ModItems.REDSTONE_AXE);
        registerRedstoneTools(ModItems.REDSTONE_HELMET);
        registerRedstoneTools(ModItems.REDSTONE_CHESTPLATE);
        registerRedstoneTools(ModItems.REDSTONE_LEGGINGS);
        registerRedstoneTools(ModItems.REDSTONE_BOOTS);
    }

    public static void registerRedstoneTools(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("charged"), (stack, world, entity, seed) -> {
            if (stack.getOrCreateNbt().getInt("Charged") == 0) {
                return 0;
            } else {
                return 1;
            }
        });
    }
}
