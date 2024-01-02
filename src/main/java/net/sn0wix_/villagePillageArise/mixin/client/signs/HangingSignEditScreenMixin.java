package net.sn0wix_.villagePillageArise.mixin.client.signs;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HangingSignEditScreen;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.common.VillagePillageAriseMain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HangingSignEditScreen.class)
public abstract class HangingSignEditScreenMixin {
    @Inject(method = "renderSignBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V", shift = At.Shift.BEFORE), cancellable = true)
    private void injectRenderSignBackground(DrawContext context, BlockState state, CallbackInfo ci) {
        context.drawTexture(new Identifier(VillagePillageAriseMain.MOD_ID, "textures/gui/hanging_signs/azalea.png"), -8, -8, 0.0f, 0.0f, 16, 16, 16, 16);
        ci.cancel();
    }
}
