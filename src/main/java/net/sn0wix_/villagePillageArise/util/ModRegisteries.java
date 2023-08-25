package net.sn0wix_.villagePillageArise.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModRegisteries {
    public static void registerModStuffs(){registerFuels();}

    private static void registerFuels(){
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(ModItems.WOODEN_BATTLE_AXE,200);
    }
}
