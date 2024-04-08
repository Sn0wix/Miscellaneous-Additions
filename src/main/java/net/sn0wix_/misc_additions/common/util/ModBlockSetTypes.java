package net.sn0wix_.misc_additions.common.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public record ModBlockSetTypes() {
    public static final BlockSetType AZALEA = new BlockSetTypeBuilder().register(new Identifier(MiscAdditions.MOD_ID, "azalea"));

    public static final BlockSetType COPPER = new BlockSetTypeBuilder()
        .soundGroup(BlockSoundGroup.COPPER)
        .doorCloseSound(SoundEvents.BLOCK_IRON_DOOR_CLOSE)
        .trapdoorCloseSound(SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE)
        .doorOpenSound(SoundEvents.BLOCK_IRON_DOOR_OPEN)
        .trapdoorOpenSound(SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN)
        .pressurePlateClickOffSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF)
        .pressurePlateClickOnSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON)
        .buttonClickOffSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF)
        .buttonClickOnSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON)
        .register(new Identifier(MiscAdditions.MOD_ID, "copper"));
}
