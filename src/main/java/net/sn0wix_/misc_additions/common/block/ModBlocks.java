package net.sn0wix_.misc_additions.common.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sn0wix_.misc_additions.common.MiscAdditions;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.block.custom.*;
import net.sn0wix_.misc_additions.common.sounds.ModSoundEvents;
import net.sn0wix_.misc_additions.common.util.ModBlockSetTypes;
import net.sn0wix_.misc_additions.common.util.ModWoodTypes;

public class ModBlocks {
    //citrine block natural, building
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new CitrineBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.7F).requiresTool()));


    public static final Block BUDDING_CITRINE = registerBlock("budding_citrine",
            new BuddingCitrineBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).solid()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.7F).requiresTool().ticksRandomly()));


    public static final Block CITRINE_CLUSTER = registerBlock("citrine_cluster", new CitrineClusterBlock(7, 3,
            FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER).requiresTool().nonOpaque().ticksRandomly()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.7F).luminance((state) -> 5)));


    public static final Block LARGE_CITRINE_BUD = registerBlock("large_citrine_bud",
            new CitrineClusterBlock(5, 3, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).requiresTool().luminance((state) -> 4)));


    public static final Block MEDIUM_CITRINE_BUD = registerBlock("medium_citrine_bud",
            new CitrineClusterBlock(4, 3, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).requiresTool().luminance((blockStatex) -> 2)));


    public static final Block SMALL_CITRINE_BUD = registerBlock("small_citrine_bud",
            new CitrineClusterBlock(3, 4, AbstractBlock.Settings.copy(CITRINE_CLUSTER)
                    .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).requiresTool().luminance((blockStatex) -> 1)));


    public static final Block GOLDEN_CHAIN_BLOCK = registerBlock("golden_chain",
            new ChainBlock(FabricBlockSettings.copyOf(Blocks.CHAIN).requiresTool().nonOpaque()
                    .strength(4.8F, 5.8F).sounds(ModSoundEvents.GOLDEN_CHAIN_SOUNDS_GROUP)));

    public static final CornBlock CORN_BLOCK = (CornBlock) registerBlockWithoutBlockItem("corn_block",
            new CornBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision().breakInstantly()));

    //Functional

    public static final Block GUNPOWDER_BARREL = registerBlock("gunpowder_barrel",
            new GunpowderBarrelBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).strength(2.5f).sounds(BlockSoundGroup.WOOD).burnable().ticksRandomly().nonOpaque()));

    public static final Block END_RELAY = registerBlock("end_relay",
            new EndAnchorBlock(FabricBlockSettings.create().mapColor(MapColor.BLACK).instrument(Instrument.BASEDRUM).requiresTool().strength(60.0f, 1200).luminance(EndAnchorBlock::getLightLevel)));


    //Azalea wood set
    public static final Block AZALEA_LOG = registerBlock("azalea_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));

    public static final Block STRIPPED_AZALEA_LOG = registerBlock("stripped_azalea_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block AZALEA_WOOD = registerBlock("azalea_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_AZALEA_WOOD = registerBlock("stripped_azalea_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block AZALEA_PLANKS = registerBlock("azalea_planks",
            new Block(FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS))));

    public static final Block AZALEA_STAIRS = registerBlock("azalea_stairs",
            new StairsBlock(AZALEA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS))));

    public static final Block AZALEA_SLAB = registerBlock("azalea_slab",
            new SlabBlock(FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_SLAB))));

    public static final Block AZALEA_FENCE = registerBlock("azalea_fence",
            new FenceBlock(FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_FENCE))));

    public static final Block AZALEA_FENCE_GATE = registerBlock("azalea_fence_gate",
            new FenceGateBlock(ModWoodTypes.AZALEA, FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE))));

    public static final Block AZALEA_BUTTON = registerBlock("azalea_button",
            new ButtonBlock(ModBlockSetTypes.AZALEA, 30, FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON))));

    public static final Block AZALEA_PRESSURE_PLATE = registerBlock("azalea_pressure_plate",
            new PressurePlateBlock(ModBlockSetTypes.AZALEA, FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_FENCE))));

    public static final Block AZALEA_DOOR = registerBlock("azalea_door",
            new DoorBlock(ModBlockSetTypes.AZALEA, FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_DOOR))));

    public static final Block AZALEA_TRAPDOOR = registerBlock("azalea_trapdoor",
            new TrapdoorBlock(ModBlockSetTypes.AZALEA, FabricBlockSettings.copyOf(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR))));

    public static final Block AZALEA_SIGN = registerBlockWithoutBlockItem("azalea_sign",
            new ModSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.AZALEA));

    public static final Block AZALEA_WALL_SIGN = registerBlockWithoutBlockItem("azalea_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(ModBlocks.AZALEA_SIGN), ModWoodTypes.AZALEA));

    public static final Block AZALEA_HANGING_SIGN = registerBlockWithoutBlockItem("azalea_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN), ModWoodTypes.AZALEA));

    public static final Block AZALEA_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("azalea_wall_hanging_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(ModBlocks.AZALEA_HANGING_SIGN), ModWoodTypes.AZALEA));


    //Copper
    public static final Block COPPER_DOOR = registerBlock("copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                    .instrument(Instrument.BASS).strength(4.0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).strength(3.0f).requiresTool(), ModBlockSetTypes.COPPER));

    public static final Block EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(ModBlocks.COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(ModBlocks.COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(ModBlocks.COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_COPPER_DOOR = registerBlock("waxed_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_EXPOSED_COPPER_DOOR = registerBlock("waxed_exposed_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_WEATHERED_COPPER_DOOR = registerBlock("waxed_weathered_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_OXIDIZED_COPPER_DOOR = registerBlock("waxed_oxidized_copper_door",
            new CopperDoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER));


    public static final Block COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(Blocks.COPPER_BLOCK.getDefaultMapColor())
                    .instrument(Instrument.BASS).strength(4.0f).nonOpaque().allowsSpawning(ModBlocks::neverAllowsSpawning), ModBlockSetTypes.COPPER));
    public static final Block EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_COPPER_TRAPDOOR = registerBlock("waxed_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlock("waxed_exposed_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlock("waxed_weathered_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    public static final Block WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlock("waxed_oxidized_copper_trapdoor",
            new CopperTrapdoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MiscAdditions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MiscAdditions.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MiscAdditions.MOD_ID, name), block);
    }


    public static void registerModBlocks() {
        MiscAdditions.LOGGER.info("Registering Mod blocks for " + MiscAdditions.MOD_ID);
    }

    private static Boolean neverAllowsSpawning(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }
}
