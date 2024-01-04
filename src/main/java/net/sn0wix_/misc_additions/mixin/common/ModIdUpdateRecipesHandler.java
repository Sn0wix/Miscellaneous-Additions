package net.sn0wix_.misc_additions.mixin.common;

import net.minecraft.server.network.ServerRecipeBook;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerRecipeBook.class)
public abstract class ModIdUpdateRecipesHandler {
    @ModifyVariable(method = "handleList", at = @At("STORE"), ordinal = 0)
    private Identifier injectHandle(Identifier value) {
        if (value.getNamespace().equals("villagepillagearise")) {
            return new Identifier(MiscAdditions.MOD_ID, value.getPath());
        }

        return value;
    }
}
