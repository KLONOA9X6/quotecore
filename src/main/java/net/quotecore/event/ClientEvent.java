package net.quotecore.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.quotecore.network.s2c.SyncConfigValuesPacket;

public class ClientEvent {
    public static void registerEvent() {
        ClientPlayNetworking.registerGlobalReceiver(SyncConfigValuesPacket.ID, SyncConfigValuesPacket::handle); // 客户端设置同步
    }
}
