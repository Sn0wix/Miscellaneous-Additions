package net.sn0wix_.misc_additions.common.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.sn0wix_.misc_additions.common.item.ModItems;

public class CustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD),
                    new ItemStack(ModItems.CORN_SEEDS), 1, 12, 1));
        });
    }
}
