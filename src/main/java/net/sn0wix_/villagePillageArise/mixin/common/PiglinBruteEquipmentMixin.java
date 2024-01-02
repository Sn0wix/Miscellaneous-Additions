package net.sn0wix_.villagePillageArise.mixin.common;

import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.item.ItemStack;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBruteEntity.class)
public abstract class PiglinBruteEquipmentMixin {
    @ModifyArg(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinBruteEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"), index = 1)
    private ItemStack injectInitEquipment(ItemStack par2) {
        return new ItemStack(ModItems.GOLDEN_BATTLE_AXE);
    }


    @Inject(method = "canGather", at = @At("HEAD"), cancellable = true)
    private void injectCanGather(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isOf(ModItems.GOLDEN_BATTLE_AXE)) {
            cir.setReturnValue(true);
        }
    }
}
