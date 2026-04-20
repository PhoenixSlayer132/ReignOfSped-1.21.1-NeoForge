package com.phoenixslayer132.reignofsped.network;

import com.phoenixslayer132.reignofsped.magics.UsageComponents;
import com.phoenixslayer132.reignofsped.magics.vocalmagic.VocalMagic;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class VocalCueHandler {
    public static void handle(VocalCuePayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();

            for (VocalMagic magic : VocalMagic.ROS_PRESETS) {
                if (payload.cue().equalsIgnoreCase(magic.getMagicComponents().getVocalCue())) {
                    UsageComponents usage = magic.getMagicComponents().getUsage().getUsageComponents();
                    if (usage.getBoon() != null) usage.getBoon().apply(player);
                    return;
                }
            }
        });
    }
}