package net.sn0wix_.villagePillageArise.common.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.sn0wix_.villagePillageArise.common.block.ModBlocks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GunpowderBarrelBlock extends Block {
    public static final BooleanProperty WAS_BROKEN = BooleanProperty.of("was_broken");

    public GunpowderBarrelBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WAS_BROKEN, false));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (pos.up().equals(sourcePos) && world.getBlockState(sourcePos).isIn(BlockTags.FIRE) && !state.get(WAS_BROKEN) && !world.isClient) {
            createExplosion(pos, world);
        }

        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient) {
            world.setBlockState(pos, state.withIfExists(WAS_BROKEN, true));
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!moved && (newState.isIn(BlockTags.FIRE)) && !state.get(WAS_BROKEN)) {
            createExplosion(pos, world);
        }

        if (checkFire(pos, world) && !world.isClient && !moved && !state.get(WAS_BROKEN) && !newState.isOf(ModBlocks.GUNPOWDER_BARREL)) {
            createExplosion(pos, world);
        }


        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (!world.isClient) {
            createExplosion(pos, world);
        }

        super.onDestroyedByExplosion(world, pos, explosion);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            if (projectile.isOnFire() && hit.getSide().equals(Direction.UP)) {
                createExplosion(projectile.getSteppingPos(), world);
                projectile.kill();
            }
        }

        super.onProjectileHit(world, state, hit, projectile);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity.isOnFire() && !world.isClient) {
            createExplosion(pos, world);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    public void createExplosion(BlockPos pos, World world) {
        if (!world.isClient) {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.8f, false, World.ExplosionSourceType.TNT);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (checkFire(pos, world)) {
            createExplosion(pos, world);
        }

        super.randomTick(state, world, pos, random);
    }

    public boolean checkFire(BlockPos pos, World world) {
        AtomicBoolean bl = new AtomicBoolean(false);
        BlockState state;

        if (world.getBlockState(pos.down()).isIn(BlockTags.FIRE)) {
            state = world.getBlockState(pos.down());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.UP) && state.get(ConnectingBlock.UP)) {
                    bl.set(true);
                }
            });

        } else if (world.getBlockState(pos.north()).isIn(BlockTags.FIRE)) {
            state = world.getBlockState(pos.north());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.SOUTH) && state.get(ConnectingBlock.SOUTH)) {
                    bl.set(true);
                }
            });

        } else if (world.getBlockState(pos.east()).isIn(BlockTags.FIRE)) {
            state = world.getBlockState(pos.east());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.WEST) && state.get(ConnectingBlock.WEST)) {
                    bl.set(true);
                }
            });

        } else if (world.getBlockState(pos.south()).isIn(BlockTags.FIRE)) {
            state = world.getBlockState(pos.south());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.NORTH) && state.get(ConnectingBlock.NORTH)) {
                    bl.set(true);
                }
            });

        } else if (world.getBlockState(pos.west()).isIn(BlockTags.FIRE)) {
            state = world.getBlockState(pos.west());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.EAST) && state.get(ConnectingBlock.EAST)) {
                    bl.set(true);
                }
            });

        } else if (world.getBlockState(pos.up()).isIn(BlockTags.FIRE)) {
            AtomicInteger shouldPass = new AtomicInteger(0);
            state = world.getBlockState(pos.west());
            state.getProperties().forEach(property -> {
                if (property.equals(ConnectingBlock.UP) || property.equals(ConnectingBlock.NORTH) || property.equals(ConnectingBlock.SOUTH) || property.equals(ConnectingBlock.EAST) || property.equals(ConnectingBlock.WEST)) {
                    shouldPass.set(shouldPass.get() + 1);
                }
            });

            if (shouldPass.get() == 5) {
                bl.set(true);
            }
        }

        return bl.get();
    }

    public VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0, 0.0625, 1, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0, 0.9375, 1, 0.0625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.9375, 0.9375, 1, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.9375, 0.9375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.9375, 0, 0, 1, 1, 1));
        return shape;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WAS_BROKEN);
    }
}
