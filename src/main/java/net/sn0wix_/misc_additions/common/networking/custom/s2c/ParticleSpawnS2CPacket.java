package net.sn0wix_.misc_additions.common.networking.custom.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.sn0wix_.misc_additions.client.util.particles.CopperDoorRedstoneParticleUtil;
import net.sn0wix_.misc_additions.client.util.particles.EndRelayTpParticleUtil;
import net.sn0wix_.misc_additions.common.MiscAdditions;

public class ParticleSpawnS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender) {
        int i = packetByteBuf.readInt();
        BlockPos pos = packetByteBuf.readBlockPos();
        client.execute(() -> {

            switch (i) {
                case 0 -> CopperDoorRedstoneParticleUtil.spawnParticles(pos, client);
                case 1 -> EndRelayTpParticleUtil.spawnDestinationParticles(packetByteBuf, client);
                default ->
                        MiscAdditions.LOGGER.error("Wrong particle packet id: " + i + " Try upgrading to newer version.");
            }
        });
    }
}
