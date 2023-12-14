package net.sn0wix_.villagePillageArise;

import net.fabricmc.api.ModInitializer;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.block.entities.ModBlockEntities;
import net.sn0wix_.villagePillageArise.config.Config;
import net.sn0wix_.villagePillageArise.config.ConfigFile;
import net.sn0wix_.villagePillageArise.entities.ModEntities;
import net.sn0wix_.villagePillageArise.item.ModItemGroupSorter;
import net.sn0wix_.villagePillageArise.item.ModItems;
import net.sn0wix_.villagePillageArise.networking.ModPackets;
import net.sn0wix_.villagePillageArise.painting.ModPainting;
import net.sn0wix_.villagePillageArise.util.ModLootTableModifiers;
import net.sn0wix_.villagePillageArise.util.ModRegisteries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VillagePillageAriseMain implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(VillagePillageAriseMain.MOD_ID);
    public static final String MOD_ID = "villagepillagearise";
    public static Config CONFIG;


    //redstone equipment - trim texture inventory
    //sus sand not working

    @Override
    public void onInitialize() {
        if (ConfigFile.checkConfig()) {
            CONFIG = ConfigFile.readConfig();
        }else {
            CONFIG = new Config();
        }


        ModItems.registerModItems();
        ModRegisteries.registerModStuffs();
        ModBlocks.registerModBlocks();
        ModItemGroupSorter.sortItemsToGroups();
        ModLootTableModifiers.modifyLootTables();
        ModPainting.registerPaintings();
        ModBlockEntities.registerALlBlockEntities();
        ModEntities.registerModEntities();
        ModPackets.registerC2SPackets();
    }
}
