package net.sn0wix_.villagePillageArise.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ParticleUtil.class)
public abstract class ParticleUtilMixin {
    @Inject(method = "spawnParticle(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/particle/ParticleEffect;Lnet/minecraft/util/math/intprovider/IntProvider;)V", at = @At("HEAD"))
    private static void injectSpawnParticles(World world, BlockPos originalPos, ParticleEffect effect, IntProvider count, CallbackInfo ci) {
        if (world.isClient() && (effect.getType().equals(ParticleTypes.WAX_ON) || effect.getType().equals(ParticleTypes.WAX_OFF))) {
            ClientWorld clientWorld = (ClientWorld) world;
            Random random = new Random();
            BlockState originalState = clientWorld.getBlockState(originalPos);
            if (originalState.getProperties().contains(Properties.DOUBLE_BLOCK_HALF)) {

                if (originalState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.LOWER)) {
                    BlockPos pos = originalPos;

                    while (originalPos.equals(pos) || pos.equals(originalPos.up())) {
                        BlockState state = world.getBlockState(pos);
                        if (state != null) {
                            Box box = state.getCollisionShape(world.getChunkAsView(world.getChunk(pos).getPos().x, world.getChunk(pos).getPos().z), pos).getBoundingBox();

                            for (Direction direction : Direction.values()) {
                                world.addParticle(ParticleTypes.WAX_ON, (double) pos.getX() + generateRandomFloat(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), random), (double) pos.getY() + generateRandomFloat(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), random), (double) pos.getZ() + generateRandomFloat(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), random), 0.0, 0.0, 0.0);
                            }
                        }
                        pos = pos.up();
                    }
                } else if (originalState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)) {
                    BlockPos pos = originalPos;

                    while (originalPos.equals(pos) || pos.equals(originalPos.down())) {
                        BlockState state = world.getBlockState(pos);
                        if (state != null) {
                            Box box = state.getCollisionShape(world.getChunkAsView(world.getChunk(pos).getPos().x, world.getChunk(pos).getPos().z), pos).getBoundingBox();

                            for (Direction direction : Direction.values()) {
                                world.addParticle(ParticleTypes.WAX_ON, (double) pos.getX() + generateRandomFloat(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), random), (double) pos.getY() + generateRandomFloat(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), random), (double) pos.getZ() + generateRandomFloat(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), random), 0.0, 0.0, 0.0);
                            }
                        }

                        pos = pos.down();
                    }
                }
            }
        }
    }

    @Unique
    private static float generateRandomFloat(double min, double max, Random random) {
        return (float) (min + (max - min) * random.nextFloat());
    }
}
