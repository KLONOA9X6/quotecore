package net.quotecore.network.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.quotecore.QuoteCore;
import net.quotecore.client.QuoteCoreClient;
import net.quotecore.integration.QuoteCoreConfig;

public class SyncConfigValuesPacket {
    public static final Identifier ID = new Identifier(QuoteCore.MOD_ID, "sync_config_values");

    public static void send(ServerPlayerEntity player) {
        PacketByteBuf buf = PacketByteBufs.create();

        buf.writeInt(QuoteCoreConfig.SEExperienceCost);

        ServerPlayNetworking.send(player, ID, buf);
    }

    public static void handle(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
        int SEExperienceCost = buf.readInt();

        client.execute(() -> {
            QuoteCoreClient.SEExperienceCost = SEExperienceCost;
        });
    }
}
