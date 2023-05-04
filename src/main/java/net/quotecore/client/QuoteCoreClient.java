package net.quotecore.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.quotecore.event.ClientEvent;

@Environment(EnvType.CLIENT)
public class QuoteCoreClient implements ClientModInitializer {

    public static int SEExperienceCost;
    @Override
    public void onInitializeClient() {
        ClientEvent.registerEvent();
    }
}
