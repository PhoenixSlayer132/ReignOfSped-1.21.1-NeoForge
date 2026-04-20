package com.phoenixslayer132.reignofsped.item.custom;


import com.phoenixslayer132.reignofsped.magics.vocalmagic.VoskIntegration;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;

public class MicrophoneItem extends Item {
    public MicrophoneItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        if(level.isClientSide() && !VoskIntegration.running) {
            if (player.getUsedItemHand().equals(usedHand)) {
                player.sendSystemMessage(Component.literal("Starting Vosk"));
                VoskIntegration.start();
                VoskIntegration.displayLanguage();
            }
        } else if (level.isClientSide() && VoskIntegration.running) {

            if (player.getUsedItemHand().equals(usedHand)) {
                player.sendSystemMessage(Component.literal("Stopping Vosk"));
                VoskIntegration.stop();
            }
        }

        player.getCooldowns().addCooldown(this, 40);

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        assert pContext.getPlayer() != null;
        use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());

        return InteractionResult.CONSUME;
    }
}
