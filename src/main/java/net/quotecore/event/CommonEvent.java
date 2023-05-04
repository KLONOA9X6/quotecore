package net.quotecore.event;

import io.github.fabricators_of_create.porting_lib.event.common.LivingEntityEvents;
import io.github.fabricators_of_create.porting_lib.event.common.PlayerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.quotecore.item.trinkets.SoulEnergyExoskeleton;
import net.quotecore.network.s2c.SyncConfigValuesPacket;

public class CommonEvent {
    public static void registerEvent() {
        PlayerTickEvents.START.register(SoulEnergyExoskeleton::costSoulEnergy); // 经验消耗检测
        LivingEntityEvents.ACTUALLY_HURT.register(SoulEnergyExoskeleton::hurt); // 灵能外骨骼受伤检测
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> SyncConfigValuesPacket.send(handler.player)); // 服务端设置同步
    }
}
