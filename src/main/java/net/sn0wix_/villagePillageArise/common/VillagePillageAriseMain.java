package net.sn0wix_.villagePillageArise.common;

import net.fabricmc.api.ModInitializer;
import net.sn0wix_.villagePillageArise.common.block.ModBlocks;
import net.sn0wix_.villagePillageArise.common.block.entities.ModBlockEntities;
import net.sn0wix_.villagePillageArise.common.config.Config;
import net.sn0wix_.villagePillageArise.common.config.ConfigFile;
import net.sn0wix_.villagePillageArise.common.entities.ModEntities;
import net.sn0wix_.villagePillageArise.common.item.ModItemGroupSorter;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import net.sn0wix_.villagePillageArise.common.networking.ModPackets;
import net.sn0wix_.villagePillageArise.common.painting.ModPainting;
import net.sn0wix_.villagePillageArise.common.util.ModLootTableModifiers;
import net.sn0wix_.villagePillageArise.common.util.ModRegisteries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VillagePillageAriseMain implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(VillagePillageAriseMain.MOD_ID);
    public static final String MOD_ID = "villagepillagearise";
    public static Config CONFIG;


    //TODO redstone equipment - trim texture inventory
    //TODO sus sand not working
    //TODO rename crushed_diamond to diamond_shard

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
