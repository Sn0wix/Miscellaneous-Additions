package net.sn0wix_.misc_additions.common.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import net.sn0wix_.misc_additions.common.networking.custom.s2c.PortalParticleSpawnS2CPacket;
import net.sn0wix_.misc_additions.common.networking.custom.s2c.RedstoneParticleSpawnS2CPacket;

public class ModPackets {
    public static final Identifier REDSTONE_PARTICLE_SPAWN = new Identifier(MiscAdditions.MOD_ID, "particle.redstone.spawn");
    public static final Identifier PORTAL_PARTICLE_SPAWN = new Identifier(MiscAdditions.MOD_ID, "particle.portal.spawn");

    public static void registerC2SPackets(){

    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(REDSTONE_PARTICLE_SPAWN, RedstoneParticleSpawnS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(PORTAL_PARTICLE_SPAWN, PortalParticleSpawnS2CPacket::receive);
    }
}
