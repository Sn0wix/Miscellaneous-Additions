package net.sn0wix_.misc_additions.client.util.particles;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.sn0wix_.misc_additions.common.networking.ModPackets;

import java.util.Random;

public class EndRelayTpParticleUtil {
    //this.getWorld().addParticle(ParticleTypes.PORTAL, this.getParticleX(0.5), this.getRandomBodyY() - 0.25, this.getParticleZ(0.5), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
    public static void spawnDestinationParticles(PacketByteBuf buf, MinecraftClient client) {
        World world = client.world;

        if (world != null) {
            if (client.player != null) {
                try {
                    BlockPos blockPos = buf.readBlockPos();
                    Random random = new Random();
                    Vec3d pos = blockPos.toCenterPos();

                    Box box = new Box(new Vec3d(pos.getX(), pos.getY(), pos.getZ()), new Vec3d(pos.getX(), pos.getY() + 1, pos.getZ()));

                    for (int j = 0; j < 128; ++j) {
                        double d = (double) j / 127.0;
                        float f = (random.nextFloat() - 0.5f) * 0.2f;
                        float g = (random.nextFloat() - 0.5f) * 0.2f;
                        float h = (random.nextFloat() - 0.5f) * 0.2f;
                        double e = MathHelper.lerp(d, box.minX, box.maxX) + (random.nextDouble() - 0.5) * client.player.getWidth() * 2.0;
                        double k = MathHelper.lerp(d, box.minY, box.maxY) + random.nextDouble() * (double) client.player.getHeight();
                        double l = MathHelper.lerp(d, box.minZ, box.maxZ) + (random.nextDouble() - 0.5) * client.player.getWidth() * 2.0;
                        client.world.addParticle(ParticleTypes.PORTAL, e, k, l, f, g, h);
                    }
                } catch (IndexOutOfBoundsException exception) {
                    Random random = new Random();

                    for (int j = 0; j < 128; ++j) {
                        double d = (double) j / 127.0;
                        float f = (random.nextFloat() - 0.5f) * 0.2f;
                        float g = (random.nextFloat() - 0.5f) * 0.2f;
                        float h = (random.nextFloat() - 0.5f) * 0.2f;
                        double e = MathHelper.lerp(d, client.player.prevX, client.player.getX()) + (random.nextDouble() - 0.5) * client.player.getWidth() * 2.0;
                        double k = MathHelper.lerp(d, client.player.prevY, client.player.getY()) + random.nextDouble() * (double) client.player.getHeight();
                        double l = MathHelper.lerp(d, client.player.prevZ, client.player.getZ()) + (random.nextDouble() - 0.5) * client.player.getWidth() * 2.0;
                        client.world.addParticle(ParticleTypes.PORTAL, e, k, l, f, g, h);
                    }
                }
            }
        }
    }

    public static void spawnPlayerParticles() {

    }


    public static void send(ServerPlayerEntity player, BlockPos pos) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(ParticlePacketTypes.END_RELAY_TELEPORT.getType());
        buffer.writeBlockPos(pos);
        ModPackets.sendParticlePacket(player, buffer);
    }

    public static void send(ServerPlayerEntity player) {
        ModPackets.sendParticlePacket(player, ParticlePacketTypes.END_RELAY_TELEPORT.getType());
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

