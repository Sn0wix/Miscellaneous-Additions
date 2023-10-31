package net.sn0wix_.villagePillageArise.util;

import net.fabricmc.fabric.api.registry.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.item.ModItems;

public class ModRegisteries {
    public static void registerModStuffs() {
        registerFuels();
        registerStrippables();
        registerCompostable();
        registerFlammables();
        registerDispencerBehaviors();
        registerOxidizable();
    }

    private static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_DOOR, ModBlocks.EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_DOOR, ModBlocks.WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_DOOR, ModBlocks.OXIDIZED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_DOOR, ModBlocks.WAXED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_DOOR, ModBlocks.WAXED_EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_DOOR, ModBlocks.WAXED_WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_DOOR, ModBlocks.WAXED_OXIDIZED_COPPER_DOOR);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_TRAPDOOR, ModBlocks.EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_TRAPDOOR, ModBlocks.WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_TRAPDOOR, ModBlocks.OXIDIZED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_TRAPDOOR, ModBlocks.WAXED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_TRAPDOOR, ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_TRAPDOOR, ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_TRAPDOOR, ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

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
                Direction direction = pointer.state().get(DispenserBlock.FACING);
                Position position = DispenserBlock.getOutputLocation(pointer);
                double d = position.getX() + (double) ((float) direction.getOffsetX() * 0.3F);
                double e = position.getY() + (double) ((float) direction.getOffsetY() * 0.3F);
                double f = position.getZ() + (double) ((float) direction.getOffsetZ() * 0.3F);
                World world = pointer.world();
                Random random = world.random;
                double g = random.nextTriangular(direction.getOffsetX(), 0.11485000000000001);
                double h = random.nextTriangular(direction.getOffsetY(), 0.11485000000000001);
                double i = random.nextTriangular(direction.getOffsetZ(), 0.11485000000000001);
                SmallFireballEntity smallFireballEntity = new SmallFireballEntity(world, d, e, f, g, h, i);
                world.spawnEntity(Util.make(smallFireballEntity, (entity) -> {
                    entity.setItem(stack);
                }));
                stack.decrement(1);
                return stack;
            }
        });

        DispenserBlock.registerBehavior(ModItems.AZALEA_CHEST_BOAT, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                Direction direction = pointer.state().get(DispenserBlock.FACING);
                Position position = DispenserBlock.getOutputLocation(pointer);
                double d = position.getX() + (double) ((float) direction.getOffsetX() * 0.3F);
                double e = position.getY() + (double) ((float) direction.getOffsetY() * 0.3F);
                double f = position.getZ() + (double) ((float) direction.getOffsetZ() * 0.3F);
                World world = pointer.world();
                Random random = world.random;
                double g = random.nextTriangular(direction.getOffsetX(), 0.11485000000000001);
                double h = random.nextTriangular(direction.getOffsetY(), 0.11485000000000001);
                double i = random.nextTriangular(direction.getOffsetZ(), 0.11485000000000001);
                SmallFireballEntity smallFireballEntity = new SmallFireballEntity(world, d, e, f, g, h, i);
                world.spawnEntity(Util.make(smallFireballEntity, (entity) -> {
                    entity.setItem(stack);
                }));
                stack.decrement(1);
                return stack;
            }
        });
    }
}
