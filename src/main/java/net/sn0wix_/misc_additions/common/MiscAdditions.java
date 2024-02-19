package net.sn0wix_.misc_additions.common;

import net.fabricmc.api.ModInitializer;
import net.sn0wix_.misc_additions.common.block.ModBlocks;
import net.sn0wix_.misc_additions.common.block.entities.ModBlockEntities;
import net.sn0wix_.misc_additions.common.config.Config;
import net.sn0wix_.misc_additions.common.config.ConfigFile;
import net.sn0wix_.misc_additions.common.entities.ModEntities;
import net.sn0wix_.misc_additions.common.item.ModItemGroupSorter;
import net.sn0wix_.misc_additions.common.item.ModItems;
import net.sn0wix_.misc_additions.common.networking.ModPackets;
import net.sn0wix_.misc_additions.common.painting.ModPainting;
import net.sn0wix_.misc_additions.common.util.ModLootTableModifiers;
import net.sn0wix_.misc_additions.common.util.ModRegisteries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiscAdditions implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(MiscAdditions.MOD_ID);
    public static final String MOD_ID = "misc_additions";
    public static Config CONFIG;

    //TODO redstone equipment - trim texture inventory
    //TODO sus sand not working
    //TODO rename crushed_diamond to diamond_sherd
    //TODO add golden chainmail armor as loot table to bastions and piglins

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
