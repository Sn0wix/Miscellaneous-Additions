package net.sn0wix_.villagePillageArise.item.custom.redstone;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class RedstoneBattleAxeItem extends MiningToolItem implements Vanishable {
    public RedstoneBattleAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.AXE_MINEABLE, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int random = new Random().nextInt(15);

        if (random == 1){

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,2,1,true,false,false));
            stack.damage(2, attacker, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });

        }else {

            stack.damage(1, attacker, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

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
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(2, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

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
        return true;
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
        return state.isIn(ModTags.REDSTONE_EQUIPMENT_RECHARGEABLE);
    }

    private static void spawnParticles(World world, BlockPos pos) {
        net.minecraft.util.math.random.Random random = world.random;
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
            tooltip.add(Text.translatable("item.villagepillagearise.redstone_equipment.tooltip.discharged"));
        }
        else {
            tooltip.add(Text.translatable("item.villagepillagearise.redstone_equipment.tooltip.charged"));
        }
    }
}
