package net.sn0wix_.misc_additions.client.util;

public enum ParticlePacketTypes {
    COPPER_DOOR_REDSTONE_PARTICLE(0),
    END_RELAY_TELEPORT(1);

    private final int type;

    ParticlePacketTypes(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
