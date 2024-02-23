package net.sn0wix_.misc_additions.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.sn0wix_.misc_additions.common.block.ModBlocks;
import net.sn0wix_.misc_additions.common.block.entities.ModBlockEntities;
import net.sn0wix_.misc_additions.client.renderers.block_entities.sign.ModHangingSignBlockEntityRenderer;
import net.sn0wix_.misc_additions.client.renderers.block_entities.sign.ModSignBlockEntityRenderer;
import net.sn0wix_.misc_additions.common.entities.ModEntities;
import net.sn0wix_.misc_additions.client.renderers.entities.boat.ModBoatEntityRenderer;
import net.sn0wix_.misc_additions.client.renderers.entities.boat.ModChestBoatEntityRenderer;
import net.sn0wix_.misc_additions.common.networking.ModPackets;
import net.sn0wix_.misc_additions.common.util.ModWoodTypes;

public class MiscAdditionsClient implements ClientModInitializer {
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

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_LANTERN_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_SOUL_LANTERN_BLOCK, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModSignBlockEntityRenderer.LAYER_LOCATION, ModSignBlockEntityRenderer::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModHangingSignBlockEntityRenderer.LAYER_LOCATION, ModHangingSignBlockEntityRenderer::getTexturedModelData);

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, ModSignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, ModHangingSignBlockEntityRenderer::new);


        EntityModelLayerRegistry.registerModelLayer(ModBoatEntityRenderer.LAYER_LOCATION, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModChestBoatEntityRenderer.LAYER_LOCATION, ChestBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AZALEA_BOAT, ModBoatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.AZALEA_CHEST_BOAT, ModChestBoatEntityRenderer::new);


        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.AZALEA, TexturedRenderLayers.getSignTextureId(ModWoodTypes.AZALEA));

        ModPackets.registerS2CPackets();
    }
}
