package net.sn0wix_.villagePillageArise.mixin.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.*;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ParticleUtil.class)
public abstract class ParticleUtilMixin {
    @Inject(method = "spawnParticle(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/particle/ParticleEffect;Lnet/minecraft/util/math/intprovider/IntProvider;)V", at = @At("HEAD"), cancellable = true)
    private static void injectSpawnParticles(World world, BlockPos originalPos, ParticleEffect effect, IntProvider count, CallbackInfo ci) {
        if (world.isClient() && (effect.getType().equals(ParticleTypes.WAX_ON)) && (world.getBlockState(originalPos).isIn(BlockTags.DOORS) || world.getBlockState(originalPos).isIn(BlockTags.TRAPDOORS))) {
            execute(world, originalPos, ParticleTypes.WAX_ON);
            ci.cancel();
        } else if (world.isClient() && (effect.getType().equals(ParticleTypes.WAX_OFF)) && (world.getBlockState(originalPos).isIn(BlockTags.DOORS) || world.getBlockState(originalPos).isIn(BlockTags.TRAPDOORS))) {
            execute(world, originalPos, ParticleTypes.WAX_OFF);
            ci.cancel();
        }
    }

    @Unique
    private static void execute(World world, BlockPos originalPos, DefaultParticleType particleType) {
        Random random = new Random();
        BlockState originalState = world.getBlockState(originalPos);
        if (originalState.getProperties().contains(Properties.DOUBLE_BLOCK_HALF)) {
            if (originalState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.LOWER)) {
                BlockPos pos = originalPos;

                while (originalPos.equals(pos) || pos.equals(originalPos.up())) {
                    spawnParticles(world, pos, random, particleType);
                    pos = pos.up();
                }
            } else if (originalState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)) {
                BlockPos pos = originalPos;

                while (originalPos.equals(pos) || pos.equals(originalPos.down())) {
                    spawnParticles(world, pos, random, particleType);
                    pos = pos.down();
                }
            }
        } else {
            spawnParticles(world, originalPos, random, particleType);
        }
    }

    @Unique
    private static void spawnParticles(World world, BlockPos pos, Random random, DefaultParticleType particleType) {
        BlockState state = world.getBlockState(pos);
        float f = 0.05f;
        if (state != null) {
            VoxelShape box = state.getCollisionShape(world.getChunkAsView(world.getChunk(pos).getPos().x, world.getChunk(pos).getPos().z), pos);
            for (Direction direction : Direction.values()) {

                if (direction.getAxis().equals(Direction.Axis.X)) {
                    world.addParticle(particleType, pos.getX() + generateRandomDoubleBetween(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), random) + f * direction.getOffsetZ(),
                             pos.getY() + generateRandomDoubleBetween(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), random),
                             pos.getZ() + chooseDouble(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), direction) + f * direction.getOffsetX(),
                            Math.abs(getRandomVelocity()) * direction.getOffsetX(), Math.abs(getRandomVelocity()) * direction.getOffsetY(), Math.abs(getRandomVelocity()) * direction.getOffsetZ());
                } else if (direction.getAxis().equals(Direction.Axis.Z)) {
                    world.addParticle(particleType, pos.getX() + chooseDouble(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), direction) + f * direction.getOffsetZ(),
                            pos.getY() + generateRandomDoubleBetween(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), random),
                            pos.getZ() + generateRandomDoubleBetween(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), random) + f * direction.getOffsetX(),
                            Math.abs(getRandomVelocity()) * direction.getOffsetX(), Math.abs(getRandomVelocity()) * direction.getOffsetY(), Math.abs(getRandomVelocity()) * direction.getOffsetZ());
                }else {
                    world.addParticle(particleType, pos.getX() + generateRandomDoubleBetween(box.getMin(Direction.Axis.X), box.getMax(Direction.Axis.X), random) + f * direction.getOffsetZ(),
                            pos.getY() + chooseDouble(box.getMin(Direction.Axis.Y), box.getMax(Direction.Axis.Y), direction),
                            pos.getZ() + generateRandomDoubleBetween(box.getMin(Direction.Axis.Z), box.getMax(Direction.Axis.Z), random) + f * direction.getOffsetX(),
                            Math.abs(getRandomVelocity()) * direction.getOffsetX(), Math.abs(getRandomVelocity()) * direction.getOffsetY(), Math.abs(getRandomVelocity()) * direction.getOffsetZ());
                }
            }
        }
    }

    @Unique
    private static double generateRandomDoubleBetween(double min, double max, Random random) {
        return (min + (max - min) * random.nextDouble());
    }

    @Unique
    private static double chooseDouble(double d, double b, Direction direction) {
        if (direction.getDirection().equals(Direction.AxisDirection.POSITIVE)) {
            return b;
        }
        return d;
    }

    @Unique
    private static double getRandomVelocity() {
        return generateRandomDoubleBetween(-0.5, 0.5, new Random());
    }
}
