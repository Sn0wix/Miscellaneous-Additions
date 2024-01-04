package net.sn0wix_.misc_additions.common.entities.minecart;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.world.World;

public abstract class GunpowderMinecartEntity extends AbstractMinecartEntity {
    public GunpowderMinecartEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }
}
