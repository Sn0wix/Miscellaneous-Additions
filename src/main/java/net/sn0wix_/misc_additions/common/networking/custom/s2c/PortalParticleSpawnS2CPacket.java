package net.sn0wix_.misc_additions.common.networking.custom.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class PortalParticleSpawnS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender) {
        if (client.world != null) {
            Vec3d centerPos = packetByteBuf.readVec3d();
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                Vec3d particlePos = getParticlePos(centerPos, random);
                Vec3d particleVelocity = calculateVelocity(centerPos, particlePos, random);
                client.world.addParticle(ParticleTypes.PORTAL, particlePos.x, particlePos.y, particlePos.z, particleVelocity.x, particleVelocity.y, particleVelocity.z);
            }
        }
    }

    public static Vec3d calculateVelocity(Vec3d centerPos, Vec3d particlePos, Random random) {
        double x = Math.sqrt(centerPos.x * centerPos.x + particlePos.x * particlePos.x);
        double y = Math.sqrt(centerPos.y * centerPos.y + particlePos.y * particlePos.y);
        double z = Math.sqrt(centerPos.z * centerPos.z + particlePos.z * particlePos.z);

        return new Vec3d(x, y, z);
    }

    public static Vec3d getParticlePos(Vec3d centerPos, Random random) {
        return centerPos.add(getOffsetX(centerPos, random), getOffsetY(centerPos, random), getOffsetZ(centerPos, random));
    }

    public static double getOffsetX(Vec3d vec3d, Random random) {
        return random.nextBoolean() ? vec3d.x + 0.6 + (random.nextDouble() / 2) : vec3d.x - 0.6 - (random.nextDouble() / 2);
    }

    public static double getOffsetY(Vec3d vec3d, Random random) {
        return vec3d.y + 0.6 + (random.nextDouble() / 2);
    }

    public static double getOffsetZ(Vec3d vec3d, Random random) {
        return random.nextBoolean() ? vec3d.z + 0.6 + (random.nextDouble() / 2) : vec3d.z - 0.6 - (random.nextDouble() / 2);
    }
}
