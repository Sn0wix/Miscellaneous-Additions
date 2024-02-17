package net.sn0wix_.misc_additions.mixin.common.wandering_trader;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LlamaEntity.class)
public abstract class LlamaStrengthMixin {
    @Shadow protected abstract void setStrength(int strength);

    @Inject(method = "initializeStrength", at = @At("HEAD"), cancellable = true)
    private void injectInitializeStrength(Random random, CallbackInfo ci) {
        if (EntityType.getId(((AbstractHorseEntity) (Object) this).getType()).equals(EntityType.getId(EntityType.TRADER_LLAMA))) {
            this.setStrength(random.nextInt(random.nextFloat() < 0.5f ? 3 : 2) + 3);
            ci.cancel();
        }
    }
}
