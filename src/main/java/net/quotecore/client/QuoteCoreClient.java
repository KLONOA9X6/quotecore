package net.quotecore.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.quotecore.network.s2c.SyncConfigValuesPacket;

@Environment(EnvType.CLIENT)
public class QuoteCoreClient implements ClientModInitializer {

    public static int SEExperienceCost;
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(SyncConfigValuesPacket.ID, SyncConfigValuesPacket::handle);
    }
}
