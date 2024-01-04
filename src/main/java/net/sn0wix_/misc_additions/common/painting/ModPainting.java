package net.sn0wix_.misc_additions.common.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public class ModPainting {
    public static final PaintingVariant CAMP_FIRE = registerPainting("camp_fire", new PaintingVariant(16,32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingMotive){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(MiscAdditions.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings(){
        MiscAdditions.LOGGER.info("Registering Paintings for " + MiscAdditions.MOD_ID);
    }
}
