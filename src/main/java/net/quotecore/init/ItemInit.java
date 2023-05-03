package net.quotecore.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.quotecore.QuoteCore;
import net.quotecore.item.ItemList;
import net.quotecore.item.trinkets.SoulEnergyExoskeleton;

public class ItemInit {
    public static void registerItem() {
        ItemList.SOUL_ENERGY_EXOSKELETON = Registry.register(Registry.ITEM,new Identifier(QuoteCore.MOD_ID,"soul_energy_exoskeleton"),
                new SoulEnergyExoskeleton()
        );
    }
}
