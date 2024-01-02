package net.sn0wix_.villagePillageArise.common.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.common.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.common.networking.custom.RedstoneParticleSpawn;

public class ModPackets {
    public static final Identifier REDSTONE_PARTICLE_SPAWN = new Identifier(VillagePillageAriseMain.MOD_ID, "particle.redstone.spawn");

    public static void registerC2SPackets(){

    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(REDSTONE_PARTICLE_SPAWN, RedstoneParticleSpawn::receive);
    }
}
