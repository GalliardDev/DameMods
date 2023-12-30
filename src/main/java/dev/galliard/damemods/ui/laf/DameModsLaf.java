package dev.galliard.damemods.ui.laf;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;

import javax.swing.*;
import java.awt.*;

public class DameModsLaf extends FlatGitHubDarkIJTheme {
    public static boolean setup() {
        setProperties();
        return setup( new DameModsLaf() );
    }

    private static void setProperties() {
        UIManager.put( "Button.arc", 0 );
    }

    @Override
    public String getName() {
        return "DameModsLaf";
    }
}
