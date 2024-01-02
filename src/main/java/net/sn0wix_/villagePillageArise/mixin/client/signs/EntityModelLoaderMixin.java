package net.sn0wix_.villagePillageArise.mixin.client.signs;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.client.renderers.block_entities.sign.ModHangingSignBlockEntityRenderer;
import net.sn0wix_.villagePillageArise.client.renderers.block_entities.sign.ModSignBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(EntityModelLoader.class)
public abstract class EntityModelLoaderMixin {

    @Shadow private Map<EntityModelLayer, TexturedModelData> modelParts;

    @Inject(method = "getModelPart", at = @At(value = "INVOKE", target = "Ljava/lang/IllegalArgumentException;<init>(Ljava/lang/String;)V", shift = At.Shift.BEFORE), cancellable = true)
    private void inject(EntityModelLayer layer, CallbackInfoReturnable<ModelPart> cir) {
      if (layer.equals(create("sign/azalea"))) {
            TexturedModelData texturedModelData = this.modelParts.get(ModSignBlockEntityRenderer.LAYER_LOCATION);
            if (texturedModelData == null) {
                throw new IllegalArgumentException("No model for layer " + layer);
            }

            cir.setReturnValue(texturedModelData.createModel());
        } else if (layer.equals(create("hanging_sign/azalea"))) {
            TexturedModelData texturedModelData = this.modelParts.get(ModHangingSignBlockEntityRenderer.LAYER_LOCATION);
            if (texturedModelData == null) {
                throw new IllegalArgumentException("No model for layer " + layer);
            }
            cir.setReturnValue(texturedModelData.createModel());
        }
    }

    @Unique
    private static EntityModelLayer create(String id) {
        return new EntityModelLayer(new Identifier("minecraft", id), "main");
    }
}
