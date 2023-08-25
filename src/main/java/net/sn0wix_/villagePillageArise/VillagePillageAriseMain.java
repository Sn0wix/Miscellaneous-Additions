package net.sn0wix_.villagePillageArise;

import net.fabricmc.api.ModInitializer;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.item.ModItems;
import net.sn0wix_.villagePillageArise.painting.ModPainting;
import net.sn0wix_.villagePillageArise.util.ModLootTableModifiers;
import net.sn0wix_.villagePillageArise.util.ModRegisteries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class VillagePillageAriseMain implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(VillagePillageAriseMain.MOD_ID);
    public static final String MOD_ID = "villagepillagearise";


    //redstone equipment - trim texture inventory

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModRegisteries.registerModStuffs();
        ModBlocks.registerModBlocks();
        ModLootTableModifiers.modifyLootTables();
        ModPainting.registerPaintings();
    }
}
