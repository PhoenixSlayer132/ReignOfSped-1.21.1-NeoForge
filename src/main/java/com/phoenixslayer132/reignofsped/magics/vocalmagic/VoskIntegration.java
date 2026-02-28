package com.phoenixslayer132.reignofsped.magics.vocalmagic;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;

import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
public class VoskIntegration {


    private static Thread speechThread;
    private static boolean running = false;

    public static void start() {
        if (running) return;
        running = true;

        speechThread = new Thread(() -> {
            try {
                Model model = new Model("run/vosk-model");

                String grammar = """
                    [
                        "give diamond",
                        "say hello"
                    ]
                    """;

                Recognizer recognizer = new Recognizer(model, 16000, grammar);

                AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
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

        String text = json.replaceAll(".*\"text\"\\s*:\\s*\"([^\"]*)\".*", "$1");

        if (text.isEmpty()) return;

        System.out.println("Heard: " + text);

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) return;

        text = text.toLowerCase();

        if (text.contains("give diamond")) {
            mc.execute(() -> {
                player.addItem(Items.DIAMOND.getDefaultInstance());
                player.sendSystemMessage(Component.literal("Heres a shiny!"));
            });
        }

        if (text.contains("say hello")) {
            mc.execute(() ->
                    player.sendSystemMessage(Component.literal("no. *humph*"))
            );
        }
    }

    public static void stop() {
        running = false;
    }
}
