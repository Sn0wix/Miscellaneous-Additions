package net.sn0wix_.villagePillageArise.mixin;

import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SignEditScreen.class)
public abstract class SignEditScreenMixin {
    @ModifyVariable(method = "renderSignBackground", at = @At("STORE"), ordinal = 0)
    public SpriteIdentifier inject(SpriteIdentifier value) {
        if (value.getTextureId().getPath().contains("azalea")) {
            if (value.getTextureId().getPath().contains("hanging")) {
                return new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, new Identifier(VillagePillageAriseMain.MOD_ID, "entity/signs/hanging/azalea"));

            }else {
                return new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, new Identifier(VillagePillageAriseMain.MOD_ID, "entity/signs/azalea"));
            }
        }
        return value;
    }
}
