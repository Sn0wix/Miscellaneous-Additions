package net.sn0wix_.villagePillageArise.mixin;

import net.minecraft.block.WoodType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.util.ModWoodTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    @Inject(method = "getSignTextureId", at = @At("RETURN"), cancellable = true)
    private static void inject(WoodType signType, CallbackInfoReturnable<SpriteIdentifier> cir) {
        if (signType.equals(ModWoodTypes.AZALEA)) {
            cir.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, new Identifier(VillagePillageAriseMain.MOD_ID, "entity/signs/azalea")));
        }
    }

    @Inject(method = "getHangingSignTextureId", at = @At("RETURN"), cancellable = true)
    private static void injectHanging(WoodType signType, CallbackInfoReturnable<SpriteIdentifier> cir) {
        if (signType.equals(ModWoodTypes.AZALEA)) {
            cir.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, new Identifier(VillagePillageAriseMain.MOD_ID, "gui/hanging_signs/azalea")));
        }
    }
}
