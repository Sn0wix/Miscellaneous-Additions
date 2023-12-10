package net.sn0wix_.villagePillageArise.block.entities;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;
import net.sn0wix_.villagePillageArise.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(VillagePillageAriseMain.MOD_ID, "sign"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new, ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_WALL_SIGN).build());;
    public static BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(VillagePillageAriseMain.MOD_ID, "hanging_sign"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new, ModBlocks.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_WALL_HANGING_SIGN).build());
    public static void registerALlBlockEntities() {
        VillagePillageAriseMain.LOGGER.info("Registering Block Entities for " + VillagePillageAriseMain.MOD_ID);
    }
}
