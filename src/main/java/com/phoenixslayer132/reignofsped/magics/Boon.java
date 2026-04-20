package com.phoenixslayer132.reignofsped.magics;

import com.phoenixslayer132.reignofsped.magics.vocalmagic.FIMagicEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.phys.Vec3;

public class Boon {

    public static FIMagicEffect potionEffect(Holder<MobEffect> effect, int duration, int level) {
        return player -> {
            player.addEffect(
                    new MobEffectInstance(effect, duration, level));
        };
    }

    public static FIMagicEffect enchantMainHand(ResourceKey<Enchantment> enchantment, int level) {
        return player -> {
            ItemStack stack = player.getMainHandItem();
            stack.enchant(player.level().holderOrThrow(enchantment), level);
        };
    }

    public static FIMagicEffect summonEntity(EntityType<?> entityType, double forwardOffset) {
        return player -> {
            ServerLevel level = (ServerLevel) player.level();
            Entity entity = entityType.create(level);
            if (entity != null) {
                Vec3 forward = player.getLookAngle().scale(forwardOffset);
                entity.setPos(
                        player.getX() + forward.x,
                        player.getY(),
                        player.getZ() + forward.z
                );
                level.addFreshEntity(entity);
            }
        };
    }

//    public static FIMagicEffect shootProjectile(MagicComponents.eElement element) {
//        return player -> {
//
//        };
//    }

    public static FIMagicEffect notify(String message) {
        return player -> player.sendSystemMessage(Component.literal(message));
    }

    public static FIMagicEffect combine(FIMagicEffect... effects) {
        return player -> {
            for (FIMagicEffect e : effects) e.apply(player);
        };
    }
}
