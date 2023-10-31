package net.sn0wix_.villagePillageArise.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.registry.tag.ItemTags;
import net.sn0wix_.villagePillageArise.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(LightningEntity.class)
public abstract class LightningMusicDiscMixin {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;onStruckByLightning(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LightningEntity;)V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void injectTick(CallbackInfo ci, List<Entity> list, Iterator var2, Entity entity) {
        if (entity instanceof ItemEntity itemEntity){
            if (itemEntity.getStack().isIn(ItemTags.MUSIC_DISCS)){
                itemEntity.getWorld().spawnEntity(new ItemEntity(itemEntity.getWorld(), itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), ModItems.MUSIC_DISC_LIGHTNING.getDefaultStack()));
            }
        }
    }
}
