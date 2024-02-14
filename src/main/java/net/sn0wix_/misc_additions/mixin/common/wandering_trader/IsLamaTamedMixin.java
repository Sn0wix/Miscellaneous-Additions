package net.sn0wix_.misc_additions.mixin.common.wandering_trader;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public abstract class IsLamaTamedMixin {
    @Inject(method = "isTame", at = @At("HEAD"), cancellable = true)
    private void injectIsTame(CallbackInfoReturnable<Boolean> cir) {
        if (EntityType.getId(((AbstractHorseEntity) (Object) this).getType()).equals(EntityType.getId(EntityType.TRADER_LLAMA))) {
            cir.setReturnValue(true);
        }
    }
}
