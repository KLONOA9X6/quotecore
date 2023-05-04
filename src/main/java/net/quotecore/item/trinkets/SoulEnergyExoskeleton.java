package net.quotecore.item.trinkets;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.quotecore.QuoteCore;
import net.quotecore.client.QuoteCoreClient;
import net.quotecore.item.ItemList;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static net.minecraft.entity.effect.StatusEffects.*;
import static net.minecraft.util.Formatting.GRAY;

public class SoulEnergyExoskeleton extends TrinketItem {
    public SoulEnergyExoskeleton() {
        super(new Item.Settings().group(QuoteCore.GROUP).maxCount(1));  // 基本属性
    }
    @Override
    @Environment(value = EnvType.CLIENT)
    // ToolTip
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(getTranslationKey() + ".tooltip").formatted(GRAY));
    }

    public static boolean equipped(PlayerEntity playerEntity) { // 装备检测
        Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(playerEntity);
        if (optional.isPresent()) {
            TrinketComponent component = optional.get();
            return component.isEquipped(ItemList.SOUL_ENERGY_EXOSKELETON);
        }
        return false;
    }

    public static boolean enoughExperience (PlayerEntity playerEntity) { // 玩家经验检测
        return playerEntity.totalExperience >= QuoteCoreClient.SEExperienceCost || playerEntity.experienceLevel > 0;
    }

    public static void costSoulEnergy(PlayerEntity playerEntity) {
        // 消耗经验给予效果
        World world = playerEntity.world;
        boolean second = world.getTime() % 20 == 0;
        if (!second || !equipped(playerEntity))
            return;
        if (equipped(playerEntity) && !enoughExperience(playerEntity)) {
            playerEntity.addStatusEffect(new StatusEffectInstance(SLOWNESS, 30, 0),playerEntity);
            return;
        }
        playerEntity.addStatusEffect(new StatusEffectInstance(STRENGTH, 30 ,3),playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(HASTE, 30 ,3),playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(JUMP_BOOST, 30, 2),playerEntity);
        if (!playerEntity.isCreative()) {
            playerEntity.addExperience(-QuoteCoreClient.SEExperienceCost);
        }
    }

    public static float hurt(DamageSource damageSource, LivingEntity entity, float v) { // 玩家受伤时减少经验
        if (entity instanceof PlayerEntity player && equipped(player) && enoughExperience(player)) {
            int damageDecExp = Math.round(v);
            player.addExperience(-damageDecExp);
        }
        return v;
    }
}
