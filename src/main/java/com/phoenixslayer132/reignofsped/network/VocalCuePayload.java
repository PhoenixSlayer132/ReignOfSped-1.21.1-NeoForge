package com.phoenixslayer132.reignofsped.network;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record VocalCuePayload(String cue) implements CustomPacketPayload {

    public static final Type<VocalCuePayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("reignofsped", "vocal_cue"));

    public static final StreamCodec<FriendlyByteBuf, VocalCuePayload> CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, VocalCuePayload::cue,
                    VocalCuePayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() { return TYPE; }
}
