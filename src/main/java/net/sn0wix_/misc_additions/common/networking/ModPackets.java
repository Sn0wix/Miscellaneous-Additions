package net.sn0wix_.misc_additions.common.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import net.sn0wix_.misc_additions.common.networking.custom.s2c.ParticleSpawnS2CPacket;

public class ModPackets {
    public static final Identifier PARTICLE_SPAWN_PACKET = new Identifier(MiscAdditions.MOD_ID, "particle.spawn");


    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(PARTICLE_SPAWN_PACKET, ParticleSpawnS2CPacket::receive);
    }

    public static void sendParticlePacket(ServerPlayerEntity player, PacketByteBuf buf) {
        ServerPlayNetworking.send(player, ModPackets.PARTICLE_SPAWN_PACKET, buf);
    }

    public static void sendParticlePacket(ServerPlayerEntity player, int type) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(type);
        ServerPlayNetworking.send(player, ModPackets.PARTICLE_SPAWN_PACKET, buf);
    }
}
