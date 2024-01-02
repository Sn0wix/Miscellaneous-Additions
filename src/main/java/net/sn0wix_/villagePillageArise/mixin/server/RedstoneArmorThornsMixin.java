package net.sn0wix_.villagePillageArise.mixin.server;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.sn0wix_.villagePillageArise.common.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.common.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class RedstoneArmorThornsMixin {

    @Inject(method = "tryAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;onAttacking(Lnet/minecraft/entity/Entity;)V", shift = At.Shift.AFTER))
    private void injectTryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if (target instanceof LivingEntity livingEntity && getArmorPieces(livingEntity) >= 1 && getChargedArmorPieces(livingEntity) >= 1) {
            int chargedStacks = 0;
            ItemStack head = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chest = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legs = livingEntity.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack feet = livingEntity.getEquippedStack(EquipmentSlot.FEET);

            if (head != null && isValidArmorItem(head.getItem()) && head.getOrCreateNbt().getInt("Charged") >= 1) {
                head.getOrCreateNbt().putInt("Charged", head.getOrCreateNbt().getInt("Charged") + 1);
                chargedStacks++;

                int charged = head.getOrCreateNbt().getInt("Charged") / 2;
                double chanceB = Math.random() * 100;
                int chance = (int) chanceB;

                if (charged < chance) {
                    head.getOrCreateNbt().putInt("Charged", head.getOrCreateNbt().getInt("Charged") + 1);
                } else {
                    head.getOrCreateNbt().putInt("Charged", 0);
                }
            }

            if (chest != null && isValidArmorItem(chest.getItem()) && chest.getOrCreateNbt().getInt("Charged") >= 1) {
                chest.getOrCreateNbt().putInt("Charged", chest.getOrCreateNbt().getInt("Charged") + 1);
                chargedStacks++;

                int charged = chest.getOrCreateNbt().getInt("Charged") / 2;
                double chanceB = Math.random() * 100;
                int chance = (int) chanceB;

                if (charged < chance) {
                    chest.getOrCreateNbt().putInt("Charged", chest.getOrCreateNbt().getInt("Charged") + 1);
                } else {
                    chest.getOrCreateNbt().putInt("Charged", 0);
                }
            }

            if (legs != null && isValidArmorItem(legs.getItem()) && legs.getOrCreateNbt().getInt("Charged") >= 1) {
                legs.getOrCreateNbt().putInt("Charged", legs.getOrCreateNbt().getInt("Charged") + 1);
                chargedStacks++;

                int charged = legs.getOrCreateNbt().getInt("Charged") / 2;
                double chanceB = Math.random() * 100;
                int chance = (int) chanceB;

                if (charged < chance) {
                    legs.getOrCreateNbt().putInt("Charged", legs.getOrCreateNbt().getInt("Charged") + 1);
                } else {
                    legs.getOrCreateNbt().putInt("Charged", 0);
                }
            }

            if (feet != null && isValidArmorItem(feet.getItem()) && feet.getOrCreateNbt().getInt("Charged") >= 1) {
                feet.getOrCreateNbt().putInt("Charged", feet.getOrCreateNbt().getInt("Charged") + 1);
                chargedStacks++;

                int charged = feet.getOrCreateNbt().getInt("Charged") / 2;
                double chanceB = Math.random() * 100;
                int chance = (int) chanceB;

                if (charged < chance) {
                    feet.getOrCreateNbt().putInt("Charged", feet.getOrCreateNbt().getInt("Charged") + 1);
                } else {
                    feet.getOrCreateNbt().putInt("Charged", 0);
                }
            }

            try {
                ((LivingEntity) target).getAttacker().damage(target.getDamageSources().thorns(target), chargedStacks);
            } catch (NullPointerException e) {
                VillagePillageAriseMain.LOGGER.error("attacker is null");
            }
        }
    }

    private boolean isValidArmorItem(Item item) {
        return item == ModItems.REDSTONE_HELMET || item == ModItems.REDSTONE_CHESTPLATE || item == ModItems.REDSTONE_LEGGINGS || item == ModItems.REDSTONE_BOOTS;
    }

    private int getArmorPieces(LivingEntity entity) {
        int returning = 0;

        if (isValidArmorItem(entity.getEquippedStack(EquipmentSlot.HEAD).getItem())) {
            returning++;
        }

        if (isValidArmorItem(entity.getEquippedStack(EquipmentSlot.CHEST).getItem())) {
            returning++;
        }

        if (isValidArmorItem(entity.getEquippedStack(EquipmentSlot.LEGS).getItem())) {
            returning++;
        }

        if (isValidArmorItem(entity.getEquippedStack(EquipmentSlot.FEET).getItem())) {
            returning++;
        }

        return returning;
    }

    private int getChargedArmorPieces(LivingEntity entity) {
        int returning = 0;

        if (entity.getEquippedStack(EquipmentSlot.HEAD).getOrCreateNbt().getInt("Charged") >= 1) {
            returning++;
        }

        if (entity.getEquippedStack(EquipmentSlot.CHEST).getOrCreateNbt().getInt("Charged") >= 1) {
            returning++;
        }

        if (entity.getEquippedStack(EquipmentSlot.LEGS).getOrCreateNbt().getInt("Charged") >= 1) {
            returning++;
        }

        if (entity.getEquippedStack(EquipmentSlot.FEET).getOrCreateNbt().getInt("Charged") >= 1) {
            returning++;
        }

        return returning;
    }
}
