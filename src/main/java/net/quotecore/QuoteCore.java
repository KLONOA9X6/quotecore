package net.quotecore;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.quotecore.event.CommonEvent;
import net.quotecore.init.ItemInit;
import net.quotecore.item.ItemList;
import org.slf4j.Logger;

public class QuoteCore implements ModInitializer {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "quotecore";
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"), () -> new ItemStack(ItemList.SOUL_ENERGY_EXOSKELETON));
    @Override
    public void onInitialize() {
        ItemInit.registerItem();
        CommonEvent.registerEvent();
        LOGGER.info("QuoteCore Initialized.");
    }
}
