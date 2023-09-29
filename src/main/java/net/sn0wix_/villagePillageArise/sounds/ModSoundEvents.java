package net.sn0wix_.villagePillageArise.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.sn0wix_.villagePillageArise.VillagePillageAriseMain;

public class ModSoundEvents {
    public static SoundEvent REVENGE = registerSoundEvent("revenge");
    public static SoundEvent GILDED = registerSoundEvent("gilded");
    public static SoundEvent GUARDIAN = registerSoundEvent("guardian");
    public static SoundEvent HUSK = registerSoundEvent("husk");
    public static SoundEvent RAIDERS = registerSoundEvent("raiders");
    public static SoundEvent SHULKER = registerSoundEvent("shulker");
    public static SoundEvent THE_ENDER_DRAGON = registerSoundEvent("the_ender_dragon");
    public static SoundEvent THE_WITHER = registerSoundEvent("the_wither");
    public static SoundEvent BRUTE = registerSoundEvent("brute");
    public static SoundEvent SHRIEKER = registerSoundEvent("shrieker");
    public static SoundEvent SHRIEKER_X_BRUTE = registerSoundEvent("shrieker_x_brute");
    public static SoundEvent WARDEN_RUN = registerSoundEvent("warden_run");
    public static SoundEvent BELOW = registerSoundEvent("below");
    public static SoundEvent LIGHTNING = registerSoundEvent("lightning");
    public static SoundEvent MASHUP = registerSoundEvent("mashup");
    public static SoundEvent NO_ESCAPE = registerSoundEvent("no_escape");
    public static SoundEvent SOULESS = registerSoundEvent("souless");
    public static SoundEvent FADING_MEMORIES = registerSoundEvent("fading_memories");
    public static SoundEvent HORIZONS = registerSoundEvent("horizons");
    public static SoundEvent IRON_OATH = registerSoundEvent("iron_oath");
    public static SoundEvent LAST_HALLWAY = registerSoundEvent("last_hallway");
    public static SoundEvent SAKURA_VALLEY = registerSoundEvent("sakura_valley");

    public static final BlockSoundGroup GOLDEN_CHAIN_SOUNDS_GROUP = new BlockSoundGroup(1.0f, 1.4f, SoundEvents.BLOCK_CHAIN_BREAK, SoundEvents.BLOCK_CHAIN_STEP, SoundEvents.BLOCK_CHAIN_PLACE, SoundEvents.BLOCK_CHAIN_HIT, SoundEvents.BLOCK_CHAIN_FALL);


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(VillagePillageAriseMain.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
