package net.sn0wix_.misc_additions.common.util.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public class ModItemTags {
    public static final TagKey<Item> AZALEA_LOGS = createItemTag("azalea_logs");
    public static final TagKey<Item> BATTLE_AXES = createItemTag("c", "battle_axes");
    public static final TagKey<Item> END_RELAY_CHARGEABLE = createItemTag("end_relay_chargeable");

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(MiscAdditions.MOD_ID, name));
    }

    private static TagKey<Item> createItemTag(String namespace, String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(namespace, name));
    }
}
