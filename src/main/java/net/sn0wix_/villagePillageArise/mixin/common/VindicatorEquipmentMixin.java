package net.sn0wix_.villagePillageArise.mixin.common;


import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(VindicatorEntity.class)
public abstract class VindicatorEquipmentMixin {
    @ModifyArg(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/VindicatorEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"), index = 1)
    private ItemStack injectInitEquipment(ItemStack par2) {
        Random random = new Random();
        return random.nextInt(9) <= 2 ?  new ItemStack(Items.IRON_SWORD) : new ItemStack(ModItems.IRON_BATTLE_AXE);
    }

    @ModifyVariable(method = "addBonusForWave", at = @At("STORE"), ordinal = 0)
    private ItemStack injectAddBonusForWave(ItemStack value) {
        Random random = new Random();
        return random.nextInt(9) <= 2 ?  new ItemStack(Items.IRON_SWORD) : new ItemStack(ModItems.IRON_BATTLE_AXE);
    }
}
