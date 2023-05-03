package net.quotecore.item.trinkets;

import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
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

import static net.minecraft.entity.effect.StatusEffects.*;
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
        // 消耗经验给予效果
        World world = playerEntity.world;
        boolean second = world.getTime() % 20 == 0;
        boolean enough_experience = playerEntity.totalExperience >= 3 || playerEntity.experienceLevel > 0;
        boolean equipped = TrinketsApi.getTrinketComponent(playerEntity).get().isEquipped(ItemList.SOUL_ENERGY_EXOSKELETON);
        if (!equipped)
            return;
        if (!second)
            return;
        if (!enough_experience)
            return;
        playerEntity.addStatusEffect(new StatusEffectInstance(STRENGTH, 30 ,3),playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(HASTE, 30 ,3),playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(JUMP_BOOST, 30, 2),playerEntity);
        if (!playerEntity.isCreative()) {
            playerEntity.addExperience(-3);
        }
    }
}
