package net.sn0wix_.villagePillageArise.util.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;

public class ModItemTags {
    public static final TagKey<Item> AZALEA_LOGS = createItemTag("azalea_logs");
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(VillagePillageAriseMain.MOD_ID, name));
    }
}
