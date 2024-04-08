package net.sn0wix_.misc_additions.mixin.common;

import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Identifier.class)
public abstract class ModidChangeFixer {
    @Mutable
    @Shadow @Final private String namespace;

    @Mutable
    @Shadow @Final private String path;

    @Inject(method = "<init>(Ljava/lang/String;Ljava/lang/String;)V", at = @At("RETURN"))
    private void injectConstructor(String namespace, String path, CallbackInfo ci) {
        if (namespace.equals("villagepillagearise")) {
            this.namespace = MiscAdditions.MOD_ID;
        }

        if (namespace.equals(MiscAdditions.MOD_ID) && path.equals("crushed_diamond")) {
            this.path = "diamond_sherd";
        }
    }
}
