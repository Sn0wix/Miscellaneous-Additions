package net.sn0wix_.villagePillageArise.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.entities.ModEntities;
import net.sn0wix_.villagePillageArise.entities.boat.ModBoatEntity;
import net.sn0wix_.villagePillageArise.entities.boat.ModChestBoatEntity;
import net.sn0wix_.villagePillageArise.item.ModItems;
import net.sn0wix_.villagePillageArise.item.custom.ModBoatItem;

public class ModRegisteries {
    public static void registerModStuffs() {
        registerFuels();
        registerStrippables();
        registerCompostable();
        registerFlammables();
        registerDispencerBehaviors();
    }

    private static void registerFuels() {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(ModItems.WOODEN_BATTLE_AXE, 200);
        fuelRegistry.add(ModBlocks.AZALEA_LOG, 300);
        fuelRegistry.add(ModBlocks.STRIPPED_AZALEA_LOG, 300);
        fuelRegistry.add(ModBlocks.AZALEA_PLANKS, 300);
        fuelRegistry.add(ModBlocks.AZALEA_SLAB, 150);
        fuelRegistry.add(ModBlocks.AZALEA_PRESSURE_PLATE, 300);
        fuelRegistry.add(ModBlocks.AZALEA_BUTTON, 100);
        fuelRegistry.add(ModBlocks.AZALEA_TRAPDOOR, 300);
        fuelRegistry.add(ModBlocks.AZALEA_FENCE, 300);
        fuelRegistry.add(ModBlocks.AZALEA_FENCE_GATE, 300);
        fuelRegistry.add(ModBlocks.AZALEA_DOOR, 200);
        fuelRegistry.add(ModItems.AZALEA_SIGN, 200);
        fuelRegistry.add(ModItems.AZALEA_HANGING_SIGN, 200);
        fuelRegistry.add(ModBlocks.AZALEA_WOOD, 300);
        fuelRegistry.add(ModBlocks.STRIPPED_AZALEA_WOOD, 300);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_AZALEA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_AZALEA_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AZALEA_STAIRS, 5, 20);
    }

    private static void registerCompostable() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.CORN, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CORN_SEEDS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.POPCORN, 0.5f);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_LOG);
        StrippableBlockRegistry.register(ModBlocks.AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_WOOD);
    }

    private static void registerDispencerBehaviors() {
        DispenserBlock.registerBehavior(ModItems.AZALEA_BOAT, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                double h;
                Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                ServerWorld world = pointer.getWorld();
                double d = 0.5625 + (double) EntityType.BOAT.getWidth() / 2.0;
                double e = pointer.getX() + (double) direction.getOffsetX() * d;
                double f = pointer.getY() + (double) ((float) direction.getOffsetY() * 1.125f);
                double g = pointer.getZ() + (double) direction.getOffsetZ() * d;
                BlockPos blockPos = pointer.getPos().offset(direction);
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    h = 1.0;
                } else if (world.getBlockState(blockPos).isAir() && world.getFluidState(blockPos.down()).isIn(FluidTags.WATER)) {
                    h = 0.0;
                } else {
                    Position position = DispenserBlock.getOutputLocation(pointer);
                    ItemStack itemStack = stack.split(1);
                    ItemDispenserBehavior.spawnItem(pointer.getWorld(), itemStack, 6, direction, position);
                    this.playSound(pointer);
                    this.spawnParticles(pointer, pointer.getBlockState().get(DispenserBlock.FACING));
                    return stack;
                }
                BoatEntity boatEntity = new ModChestBoatEntity(ModEntities.AZALEA_BOAT, world);
                boatEntity.setPosition(e, f + h, g);

                boatEntity.setYaw(direction.asRotation());
                world.spawnEntity(boatEntity);
                stack.decrement(1);
                return stack;
            }


        });

        DispenserBlock.registerBehavior(ModItems.AZALEA_CHEST_BOAT, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                double h;
                Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                ServerWorld world = pointer.getWorld();
                double d = 0.5625 + (double) EntityType.BOAT.getWidth() / 2.0;
                double e = pointer.getX() + (double) direction.getOffsetX() * d;
                double f = pointer.getY() + (double) ((float) direction.getOffsetY() * 1.125f);
                double g = pointer.getZ() + (double) direction.getOffsetZ() * d;
                BlockPos blockPos = pointer.getPos().offset(direction);
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    h = 1.0;
                } else if (world.getBlockState(blockPos).isAir() && world.getFluidState(blockPos.down()).isIn(FluidTags.WATER)) {
                    h = 0.0;
                } else {
                    return stack;
                }
                BoatEntity boatEntity = new ModChestBoatEntity(ModEntities.AZALEA_CHEST_BOAT, world);
                boatEntity.setPosition(e, f + h, g);

                boatEntity.setYaw(direction.asRotation());
                world.spawnEntity(boatEntity);
                stack.decrement(1);
                return stack;
            }
        });
    }
}
