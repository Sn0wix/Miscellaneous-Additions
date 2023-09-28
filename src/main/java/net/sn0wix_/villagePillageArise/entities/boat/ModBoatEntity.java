package net.sn0wix_.villagePillageArise.entities.boat;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModBoatEntity extends BoatEntity {

    public ModBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Item asItem() {
        return ModItems.AZALEA_BOAT;
    }
}
