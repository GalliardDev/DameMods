package dev.galliard.damemods;

import dev.galliard.damemods.ui.UIDameMods;
import dev.galliard.damemods.ui.laf.DameModsLaf;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DameMods {
    public static final String MINECRAFT_FOLDER = "C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/.minecraft";
    public static final String DOWNLOADS_FOLDER = "C:/Users/"+System.getProperty("user.name")+"/Downloads";
    public static final String MODPACK = "https://github.com/GalliardDev/DameMods/releases/download/Modpack/modpack.zip";
    public static void main(String[] args) {
        DameModsLaf.setup();
        if(Files.notExists(Path.of(MINECRAFT_FOLDER))) {
            try {
                Files.createDirectory(Path.of(MINECRAFT_FOLDER));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        SwingUtilities.invokeLater(() -> {
            UIDameMods ui = UIDameMods.getInstance();
            ui.setVisible(true);
        });
    }
}
