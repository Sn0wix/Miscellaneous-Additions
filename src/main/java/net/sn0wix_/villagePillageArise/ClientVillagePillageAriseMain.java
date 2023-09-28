package net.sn0wix_.villagePillageArise;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.sn0wix_.villagePillageArise.block.ModBlocks;
import net.sn0wix_.villagePillageArise.block.entities.ModBlockEntities;
import net.sn0wix_.villagePillageArise.entities.ModEntities;
import net.sn0wix_.villagePillageArise.entities.boat.client.ModBoatEntityRenderer;
import net.sn0wix_.villagePillageArise.entities.boat.client.ModChestBoatEntityRenderer;
import net.sn0wix_.villagePillageArise.util.ModModelPredicateProvider;
import net.sn0wix_.villagePillageArise.util.ModWoodTypes;

public class ClientVillagePillageAriseMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModules();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_CHAIN_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AZALEA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AZALEA_TRAPDOOR, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);


        EntityModelLayerRegistry.registerModelLayer(ModBoatEntityRenderer.LAYER_LOCATION, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModChestBoatEntityRenderer.LAYER_LOCATION, ChestBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AZALEA_BOAT, ModBoatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.AZALEA_CHEST_BOAT, ModChestBoatEntityRenderer::new);


        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.AZALEA, TexturedRenderLayers.getSignTextureId(ModWoodTypes.AZALEA));
    }
}
