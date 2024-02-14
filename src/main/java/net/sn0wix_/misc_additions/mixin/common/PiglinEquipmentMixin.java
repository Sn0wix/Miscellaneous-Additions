package net.sn0wix_.misc_additions.mixin.common;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.sn0wix_.misc_additions.common.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PiglinEntity.class)
public abstract class PiglinEquipmentMixin {

    //((TargetClass)(Object)this).field/method();

    @Inject(method = "equipAtChance", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.BEFORE), cancellable = true)
    private void injectEquipAtChance(EquipmentSlot slot, ItemStack stack, Random random, CallbackInfo ci) {
        if (getGoldenArmor(stack) != 0) {
            int i = random.nextInt(2);
            if (i == 0) {
                return;
            } else {
                switch (getGoldenArmor(stack)) {
                    case 1 -> equip(slot, new ItemStack(ModItems.GOLDEN_CHAINMAIL_HELMET));
                    case 2 -> equip(slot, new ItemStack(ModItems.GOLDEN_CHAINMAIL_CHESTPLATE));
                    case 3 -> equip(slot, new ItemStack(ModItems.GOLDEN_CHAINMAIL_LEGGINGS));
                    case 4 -> equip(slot, new ItemStack(ModItems.GOLDEN_CHAINMAIL_BOOTS));
                    default -> {
                        return;
                    }
                }
            }

            ci.cancel();
        }
    }

    @Unique
    private int getGoldenArmor(ItemStack stack) {
        if (stack.isOf(Items.GOLDEN_HELMET)) {
            return 1;
        }
        if (stack.isOf(Items.GOLDEN_CHESTPLATE)) {
            return 2;
        }
        if (stack.isOf(Items.GOLDEN_LEGGINGS)) {
            return 3;
        }
        if (stack.isOf(Items.GOLDEN_BOOTS)) {
            return 4;
        }

        return 0;
    }

    @Unique
    private void equip(EquipmentSlot slot, ItemStack stack) {
        ((PiglinEntity) (Object) this).equipStack(slot, stack);
    }
}
