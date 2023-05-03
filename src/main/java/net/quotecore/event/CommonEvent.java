package net.quotecore.event;

import io.github.fabricators_of_create.porting_lib.event.common.PlayerTickEvents;
import net.quotecore.item.trinkets.SoulEnergyExoskeleton;

public class CommonEvent {
    public static void registerEvent() {
        PlayerTickEvents.START.register(SoulEnergyExoskeleton::costSoulEnergy);
    }
}
