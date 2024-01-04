package net.sn0wix_.misc_additions.common.networking.custom;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class RedstoneParticleSpawn {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender) {
        ClientWorld world = client.world;

        if (world != null) {
            BlockPos originalPos = packetByteBuf.readBlockPos();
            BlockPos pos = originalPos;

            while (originalPos.equals(pos) || pos.equals(originalPos.up())) {
                Random random = new Random();
                BlockState state = world.getBlockState(pos);

                if (state != null) {
                    Box box = state.getCollisionShape(world.getChunkAsView(world.getChunk(pos).getPos().x, world.getChunk(pos).getPos().z), pos).getBoundingBox();

                    for (Direction direction : Direction.values()) {
                        world.addParticle(DustParticleEffect.DEFAULT, (double) pos.getX() + generateRandomFloat(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), random), (double) pos.getY() + generateRandomFloat(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), random), (double) pos.getZ() + generateRandomFloat(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), random), 0.0, 0.0, 0.0);
                    }

                    if (state.getProperties() == null || (state.getProperties() != null && !state.getProperties().contains(Properties.DOUBLE_BLOCK_HALF))) {
                        pos = pos.up();
                    }
                }

                pos = pos.up();
            }
        }
    }

    public static float generateRandomFloat(double min, double max, Random random) {
        return (float) (min + (max - min) * random.nextFloat());
    }
}
