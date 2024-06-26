package net.sn0wix_.misc_additions.common.sounds;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.sn0wix_.misc_additions.common.MiscAdditions;

import java.util.stream.IntStream;

public class CopperHornSoundEvents {
    public static final ImmutableList<SoundEvent> COPPER_HORN_BASS_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.BASS);
    public static final ImmutableList<SoundEvent> COPPER_HORN_HARMONY_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.HARMONY);
    public static final ImmutableList<SoundEvent> COPPER_HORN_MELODY_SOUNDS = CopperHornSoundEvents.registerCopperHornSounds(CopperHornSoundType.MELODY);

    private static ImmutableList<SoundEvent> registerCopperHornSounds(CopperHornSoundType type) {
        return IntStream.range(0, 10).mapToObj(variant ->
                CopperHornSoundEvents.register("item.copper_horn.sound." + type.value + "." + variant)
        ).collect(ImmutableList.toImmutableList());
    }

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, new Identifier(MiscAdditions.MOD_ID, id), SoundEvent.of(new Identifier(MiscAdditions.MOD_ID, id)));
    }

    private enum CopperHornSoundType {
        BASS("bass"),
        HARMONY("harmony"),
        MELODY("melody");

        public final String value;

        CopperHornSoundType(String value) {
            this.value = value;
        }
    }
}
