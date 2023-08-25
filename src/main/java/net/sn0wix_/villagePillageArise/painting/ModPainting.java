package net.sn0wix_.villagePillageArise.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;

public class ModPainting {
    public static final PaintingVariant CAMP_FIRE = registerPainting("camp_fire", new PaintingVariant(16,32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingMotive){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(VillagePillageAriseMain.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings(){
        VillagePillageAriseMain.LOGGER.info("Registering Paintings for " + VillagePillageAriseMain.MOD_ID);
    }
}
