package com.phoenixslayer132.reignofsped.magics.vocalmagic;

import com.phoenixslayer132.reignofsped.magics.UsageComponents;
import com.phoenixslayer132.reignofsped.network.VocalCuePayload;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;

import net.neoforged.neoforge.network.PacketDistributor;
import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;

import java.io.File;

public class VoskIntegration {
    private static Model model;
    private static Recognizer recognizer;
    private static TargetDataLine microphone;

    private static Thread speechThread;
    public static boolean running = false;

    public static void toggle() {
        if (running) {
            stop();
        } else {
            start();
        }
    }

    public static void start() {

        if (running) return;
        running = true;

        speechThread = new Thread(() -> {
            try {
                File modelPath = new File("vosk-model");
                if (!modelPath.exists()) {
                    modelPath = new File("src/main/resources/vosk-model");
                }
                model = new Model(modelPath.getAbsolutePath());

                String grammar = """
                    [
                        "give diamond",
                        "fah",
                        "wah",
                        "hah",
                        "gah",
                        "lah",
                        "rah",
                        "pah",
                        "shu",
                        "shi",
                        "suh"
                    ]
                    """;

                recognizer = new Recognizer(model, 16000, grammar);

                AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                microphone = (TargetDataLine) AudioSystem.getLine(info);
                microphone.open(format);
                microphone.start();

                byte[] buffer = new byte[4096];

                while (running) {
                    int bytesRead = microphone.read(buffer, 0, buffer.length);

                    if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                        String result = recognizer.getResult();
                        handleResult(result);
                    }
                }

                microphone.close();
                recognizer.close();
                model.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        speechThread.setDaemon(true);
        speechThread.start();
    }

    private static void handleResult(String json) {

        String text = json.replaceAll(".*\"text\"\\s*:\\s*\"([^\"{}]*)\".*", "$1").replace("{", "").replace("}", "").trim();
        if (text.isEmpty()) return;

        System.out.printf("Heard: \"%s\"", text);

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) return;

        for (VocalMagic magic : VocalMagic.ROS_PRESETS) {
            if (text.equalsIgnoreCase(magic.getMagicComponents().getVocalCue())) {
                PacketDistributor.sendToServer(new VocalCuePayload(text));
                return;
            }
        }

//        if (text.contains("give diamond")) {
//            mc.execute(() -> {
//                player.addItem(Items.DIAMOND.getDefaultInstance());
//                player.sendSystemMessage(Component.literal("Heres a shiny!"));
//            });
//        }
//
//        if (text.contains("fah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Fire"));
//                    }
//            );
//        }
//        if (text.contains("wah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Water"));
//                    }
//            );
//        }
//        if (text.contains("hah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Air"));
//                    }
//            );
//        }
//        if (text.contains("gah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Earth"));
//                    }
//            );
//        }
//        if (text.contains("lah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("5%"));
//                    }
//            );
//        }
//        if (text.contains("rah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("50%"));
//                    }
//            );
//        }
//        if (text.contains("pah")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("100%"));
//                    }
//            );
//        }
//        if (text.contains("shu")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Projectile"));
//                    }
//            );
//        }
//        if (text.contains("shi")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Self"));
//                    }
//            );
//        }
//        if (text.contains("suh")) {
//            mc.execute(() ->
//                    {
//                        player.sendSystemMessage(Component.literal("Summon"));
//                    }
//            );
//        }
    }

    public static void displayLanguage() {
        Minecraft mc = Minecraft.getInstance();

        mc.execute( () -> {
            assert mc.player != null;
            mc.player.sendSystemMessage(Component.literal("Elements:"));
            mc.player.sendSystemMessage(Component.literal(" * Fire (\"Fah\")"));
            mc.player.sendSystemMessage(Component.literal(" * Water (\"Wah\")"));
            mc.player.sendSystemMessage(Component.literal(" * Air (\"Hah\")"));
            mc.player.sendSystemMessage(Component.literal(" * Earth (\"Gah\")"));

            mc.player.sendSystemMessage(Component.literal("Mana Amount:"));
            mc.player.sendSystemMessage(Component.literal(" * 5% (\"Lah\")"));
            mc.player.sendSystemMessage(Component.literal(" * 50% (\"Rah\")"));
            mc.player.sendSystemMessage(Component.literal(" * 100% (\"Pah\")"));

            mc.player.sendSystemMessage(Component.literal("Usage Type:"));
            mc.player.sendSystemMessage(Component.literal(" * Projectile (\"Shu\") [UNDER IMPLEMENTATION]"));
            mc.player.sendSystemMessage(Component.literal(" * Self (\"Shi\")"));
            mc.player.sendSystemMessage(Component.literal(" * Summon (\"Suh\")"));
        });
    }

    public static void stop() {
        if (!running) return;
        running = false;
    }
}
