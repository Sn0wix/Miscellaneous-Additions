package net.sn0wix_.villagePillageArise.util;


import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;

public class ModTags {
    public static final TagKey<Block> REDSTONE_EQUIPMENT_RECHARGEABLE = createBlockTag("redstone_equipment_rechargeable");
    public static final TagKey<Block> AZALEA_LOGS = createBlockTag("azalea_logs");

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(VillagePillageAriseMain.MOD_ID, name));
    }
}
