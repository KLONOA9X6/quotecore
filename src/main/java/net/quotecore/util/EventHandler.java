package net.quotecore.util;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.quotecore.network.s2c.SyncConfigValuesPacket;

public class EventHandler {
    public static void commonEvents() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> SyncConfigValuesPacket.send(handler.player));
    }
}
