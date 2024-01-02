package net.sn0wix_.villagePillageArise.mixin.server;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import net.sn0wix_.villagePillageArise.common.util.tags.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedstoneOreBlock.class)
public abstract class RedstoneOreMixin {

    @Inject(method = "onUse", at = @At("HEAD"))
    private void injectOnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir){
        if (!world.isClient && player.getStackInHand(Hand.MAIN_HAND) != null && isValidItem(player.getStackInHand(Hand.MAIN_HAND).getItem()) && state.isIn(ModBlockTags.REDSTONE_EQUIPMENT_RECHARGEABLE)){
            player.getStackInHand(Hand.MAIN_HAND).getOrCreateNbt().putInt("Charged", 1);
            spawnParticles(world, pos);
            spawnParticles(world, pos);
            spawnParticles(world, pos);
        }
    }

    private boolean isValidItem(Item item){
        return item == ModItems.REDSTONE_AXE || item == ModItems.REDSTONE_HOE || item == ModItems.REDSTONE_SHOVEL || item == ModItems.REDSTONE_PICKAXE ||
                item == ModItems.REDSTONE_BATTLE_AXE || item == ModItems.REDSTONE_SWORD || item == ModItems.REDSTONE_HELMET || item == ModItems.REDSTONE_CHESTPLATE ||
                item == ModItems.REDSTONE_LEGGINGS || item == ModItems.REDSTONE_BOOTS;
    }

    private static void spawnParticles(World world, BlockPos pos) {
        final double d = 0.5625;
        Random random = world.random;
        Direction[] var5 = Direction.values();

        for (Direction direction : var5) {
            BlockPos blockPos = pos.offset(direction);
            if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                Direction.Axis axis = direction.getAxis();
                double e = axis == Direction.Axis.X ? 0.5 + d * (double) direction.getOffsetX() : (double) random.nextFloat();
                double f = axis == Direction.Axis.Y ? 0.5 + d * (double) direction.getOffsetY() : (double) random.nextFloat();
                double g = axis == Direction.Axis.Z ? 0.5 + d * (double) direction.getOffsetZ() : (double) random.nextFloat();
                world.addParticle(DustParticleEffect.DEFAULT, (double) pos.getX() + e, (double) pos.getY() + f, (double) pos.getZ() + g, 0.0, 0.0, 0.0);
            }
        }
    }
}
