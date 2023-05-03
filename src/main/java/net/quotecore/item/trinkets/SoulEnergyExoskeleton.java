package net.quotecore.item.trinkets;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.quotecore.QuoteCore;
import net.quotecore.item.ItemList;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.entity.effect.StatusEffects.HASTE;
import static net.minecraft.entity.effect.StatusEffects.STRENGTH;
import static net.minecraft.util.Formatting.GRAY;

public class SoulEnergyExoskeleton extends TrinketItem {
    public SoulEnergyExoskeleton() {
        super(new Item.Settings().group(QuoteCore.GROUP).maxCount(1));
    }
    @Override
    @Environment(value = EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(getTranslationKey() + ".tooltip").formatted(GRAY));
    }
    public static void costSoulEnergy(PlayerEntity playerEntity) {
        World world = playerEntity.world;
        boolean second = world.getTime() % 20 == 0;
        boolean out_of_experience = playerEntity.totalExperience >= 2;
        boolean equipped = playerEntity.getItemsEquipped() == ItemList.SOUL_ENERGY_EXOSKELETON; // 不对，这个是查背包，不是查饰品栏
        if (!equipped)
            return;
        if (!second)
            return;
        if (out_of_experience)
            return;
        playerEntity.addStatusEffect(new StatusEffectInstance(STRENGTH, 30 ,3),playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(HASTE, 30 ,3),playerEntity);
        playerEntity.addExperience(-2);
    }
}
