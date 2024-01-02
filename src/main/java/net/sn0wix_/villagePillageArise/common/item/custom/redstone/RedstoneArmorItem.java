package net.sn0wix_.villagePillageArise.common.item.custom.redstone;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import net.sn0wix_.villagePillageArise.common.util.tags.ModBlockTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class RedstoneArmorItem extends ArmorItem {
    public RedstoneArmorItem(ArmorMaterial material, Type slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (isValidBlock(context.getWorld().getBlockState(context.getBlockPos()))) {
            Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand()).getOrCreateNbt().putInt("Charged", 1);
            spawnParticles(context.getWorld(), context.getBlockPos());
            spawnParticles(context.getWorld(), context.getBlockPos());
            spawnParticles(context.getWorld(), context.getBlockPos());
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) return;
        if (stack.getOrCreateNbt().getInt("Charged") == 1)return;
        if (!(entity instanceof LivingEntity livingEntity)) return;


        BlockPos blockPos = new BlockPos( entity.getBlockPos().getX(), entity.getBlockPos().getY() - 1, entity.getBlockPos().getZ());
        if (isValidBlock(world.getBlockState(blockPos))) {
            if (isCorrectArmor(livingEntity, stack)) {
                stack.getOrCreateNbt().putInt("Charged", 1);
                spawnParticles(world, blockPos);
                spawnParticles(world, blockPos);
                spawnParticles(world, blockPos);
            }
        }
    }


    public boolean isCorrectArmor(LivingEntity entity, ItemStack itemStack) {
        boolean passed = false;

        if (!isValidArmorItem(itemStack.getItem())) {
            return false;
        }

        if (entity.getEquippedStack(EquipmentSlot.HEAD).equals(itemStack)) {
            passed = true;
        }
        if (entity.getEquippedStack(EquipmentSlot.CHEST).equals(itemStack)) {
            passed = true;
        }
        if (entity.getEquippedStack(EquipmentSlot.LEGS).equals(itemStack)) {
            passed = true;
        }
        if (entity.getEquippedStack(EquipmentSlot.FEET).equals(itemStack)) {
            passed = true;
        }

        return passed;
    }

    private boolean isValidArmorItem(Item item) {
        return item == ModItems.REDSTONE_HELMET || item == ModItems.REDSTONE_CHESTPLATE || item == ModItems.REDSTONE_LEGGINGS || item == ModItems.REDSTONE_BOOTS;
    }

    public static boolean isValidBlock(BlockState state) {
        return state.isIn(ModBlockTags.REDSTONE_EQUIPMENT_RECHARGEABLE);
    }

    private static void spawnParticles(World world, BlockPos pos) {
        Random random = world.random;
        Direction[] var5 = Direction.values();

        for (Direction direction : var5) {
            BlockPos blockPos = pos.offset(direction);
            if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                Direction.Axis axis = direction.getAxis();
                double e = axis == Direction.Axis.X ? 0.5 + 0.5625 * (double) direction.getOffsetX() : (double) random.nextFloat();
                double f = axis == Direction.Axis.Y ? 0.5 + 0.5625 * (double) direction.getOffsetY() : (double) random.nextFloat();
                double g = axis == Direction.Axis.Z ? 0.5 + 0.5625 * (double) direction.getOffsetZ() : (double) random.nextFloat();
                world.addParticle(DustParticleEffect.DEFAULT, (double) pos.getX() + e, (double) pos.getY() + f, (double) pos.getZ() + g, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getOrCreateNbt().getInt("Charged") == 0) {
            tooltip.add(Text.translatable("item.villagepillagearise.redstone_equipment.tooltip.discharged"));
        } else {
            tooltip.add(Text.translatable("item.villagepillagearise.redstone_equipment.tooltip.charged"));
        }
    }
}
