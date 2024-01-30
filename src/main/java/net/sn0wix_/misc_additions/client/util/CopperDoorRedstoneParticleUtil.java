package net.sn0wix_.misc_additions.client.util;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class CopperDoorRedstoneParticleUtil {
    public static void spawnParticles(BlockPos originalPos, MinecraftClient client) {
        World world = client.world;

        if (world != null) {
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

    private static float generateRandomFloat(double min, double max, Random random) {
        return (float) (min + (max - min) * random.nextFloat());
    }
}
