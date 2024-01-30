package net.sn0wix_.misc_additions.common.networking.custom.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.sn0wix_.misc_additions.client.util.CopperDoorRedstoneParticleUtil;
import net.sn0wix_.misc_additions.client.util.EndRelayTpParticleUtil;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public class ParticleSpawnS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender) {
        client.execute(() -> {
            int i = packetByteBuf.unwrap().readInt();


            switch (i) {
                case 0 -> CopperDoorRedstoneParticleUtil.spawnParticles(packetByteBuf.readBlockPos(), client);
                case 1 -> EndRelayTpParticleUtil.spawnParticles(packetByteBuf, client.world);
                default -> MiscAdditions.LOGGER.error("Wrong particle packet id: " + i + " Try upgrading to newer version.");
            }
        });
    }
}
