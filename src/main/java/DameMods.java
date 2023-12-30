import dev.galliard.damemods.ui.UIDameMods;
import dev.galliard.damemods.ui.laf.DameModsLaf;

import javax.swing.*;

public class DameMods {
    public static void main(String[] args) {
        DameModsLaf.setup();

        SwingUtilities.invokeLater(() -> {
            UIDameMods ui = UIDameMods.getInstance();
            ui.setVisible(true);
        });
    }
}
