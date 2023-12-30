import dev.galliard.damemods.ui.UIDameMods;

import javax.swing.*;

public class DameMods {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIDameMods ui = UIDameMods.getInstance();
            ui.setVisible(true);
        });
    }
}
