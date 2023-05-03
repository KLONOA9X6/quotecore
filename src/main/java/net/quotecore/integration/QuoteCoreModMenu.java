package net.quotecore.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.quotecore.QuoteCore;

public class QuoteCoreModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> QuoteCoreConfig.getScreen(parent, QuoteCore.MOD_ID);
    }
}
