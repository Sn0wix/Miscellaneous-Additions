package net.sn0wix_.misc_additions.common.item.custom.redstone;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.sn0wix_.misc_additions.common.util.tags.ModBlockTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedstoneHoeItem extends HoeItem {
    public RedstoneHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack.getOrCreateNbt().getInt("Charged") >= 1){
            int charged = stack.getOrCreateNbt().getInt("Charged") / 2;
            double chanceB = Math.random() * 100;
            int chance = (int) chanceB;

            target.heal(-2);

            if (charged < chance){
                stack.getOrCreateNbt().putInt("Charged", stack.getOrCreateNbt().getInt("Charged") + 1);
            }else {
                stack.getOrCreateNbt().putInt("Charged", 0);
            }
        }

        stack.damage(1, attacker, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (stack.getOrCreateNbt().getInt("Charged") >= 1){
            int charged = stack.getOrCreateNbt().getInt("Charged");
            double chanceB = Math.random() * 100;
            int chance = (int) chanceB;

            spawnParticles(miner.getWorld(), pos);

            if (charged < chance){
                stack.getOrCreateNbt().putInt("Charged", stack.getOrCreateNbt().getInt("Charged") + 1);
            }else {
                stack.getOrCreateNbt().putInt("Charged", 0);
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (isValidBlock(context.getWorld().getBlockState(context.getBlockPos()))) {
            context.getStack().getOrCreateNbt().putInt("Charged", 1);
            spawnParticles(context.getWorld(), context.getBlockPos());
            spawnParticles(context.getWorld(), context.getBlockPos());
            spawnParticles(context.getWorld(), context.getBlockPos());
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


    private boolean isValidBlock(BlockState state) {
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
        if (stack.getOrCreateNbt().getInt("Charged") == 0){
            tooltip.add(Text.translatable("item.misc_additions.redstone_equipment.tooltip.discharged"));
        }
        else {
            tooltip.add(Text.translatable("item.misc_additions.redstone_equipment.tooltip.charged"));
        }
    }
}
