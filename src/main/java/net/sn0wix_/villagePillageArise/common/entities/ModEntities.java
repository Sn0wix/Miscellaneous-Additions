package net.sn0wix_.villagePillageArise.common.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.common.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.common.entities.boat.ModBoatEntity;
import net.sn0wix_.villagePillageArise.common.entities.boat.ModChestBoatEntity;

public class ModEntities {
    public static final EntityType<ModBoatEntity> AZALEA_BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(VillagePillageAriseMain.MOD_ID, "azalea_boat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ModBoatEntity::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeBlocks(10).build());
    public static final EntityType<ModChestBoatEntity> AZALEA_CHEST_BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(VillagePillageAriseMain.MOD_ID, "azalea_chest_boat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ModChestBoatEntity::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeBlocks(10).build());

    public static void registerModEntities() {
        VillagePillageAriseMain.LOGGER.info("Registering entities for " + VillagePillageAriseMain.MOD_ID);
    }
}
