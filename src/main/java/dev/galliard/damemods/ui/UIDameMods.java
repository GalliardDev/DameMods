/*
 * Created by JFormDesigner on Sat Dec 30 05:19:00 CET 2023
 */

package dev.galliard.damemods.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author jomaa
 */
public class UIDameMods extends JFrame {
    private int posX, posY;
    private UIDameMods() {
        initComponents();
        new Thread(new InfoGetterThread()).start();
    }

    public static UIDameMods getInstance() {
        return new UIDameMods();
    }

    private void downloadBtnActionPerformed(ActionEvent e) {
        new Thread(new DownloaderThread()).start();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
        serverLabel = new JLabel();
        versionWeightLabel = new JLabel();
        btnWrapper = new JPanel();
        downloadBtn = new JButton();
        progressBar1 = new JProgressBar();

        //======== this ========
        setResizable(false);
        setTitle("Dame Mods client v1.0");
        setIconImage(new ImageIcon(getClass().getResource("/images/smurf_small.png")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(false);
        setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
            "[grow,fill]",
            // rows
            "[]" +
            "[fill]" +
            "[fill]" +
            "[grow,fill]" +
            "[fill]"));

        //---- serverLabel ----
        serverLabel.setText("Servidor: X");
        serverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        serverLabel.setFont(serverLabel.getFont().deriveFont(serverLabel.getFont().getStyle() | Font.BOLD, serverLabel.getFont().getSize() + 8f));
        contentPane.add(serverLabel, "cell 0 1,align center center,grow 0 0");

        //---- versionWeightLabel ----
        versionWeightLabel.setText("Versi\u00f3n: Y | Peso: Z");
        versionWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        versionWeightLabel.setFont(versionWeightLabel.getFont().deriveFont(versionWeightLabel.getFont().getSize() + 8f));
        contentPane.add(versionWeightLabel, "cell 0 2,align center center,grow 0 0");

        //======== btnWrapper ========
        {
            btnWrapper.setLayout(new MigLayout(
                "insets 0,hidemode 3,align center center,gap 5 5",
                // columns
                "[grow,fill]",
                // rows
                "[grow,fill]"));

            //---- downloadBtn ----
            downloadBtn.setText("Requisitos y Mods");
            downloadBtn.setFont(downloadBtn.getFont().deriveFont(downloadBtn.getFont().getStyle() | Font.BOLD, downloadBtn.getFont().getSize() + 10f));
            downloadBtn.setIcon(new ImageIcon(getClass().getResource("/images/download_small.png")));
            downloadBtn.setIconTextGap(12);
            downloadBtn.setFocusable(false);
            downloadBtn.addActionListener(e -> downloadBtnActionPerformed(e));
            btnWrapper.add(downloadBtn, "pad 0 0 -10 10,cell 0 0,align center center,grow 0 0,height 60:60:60");
        }
        contentPane.add(btnWrapper, "cell 0 3");
        contentPane.add(progressBar1, "cell 0 4,height 16:16:16");
        setSize(350, 200);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
    protected static JLabel serverLabel;
    protected static JLabel versionWeightLabel;
    protected static JPanel btnWrapper;
    protected static JButton downloadBtn;
    protected static JProgressBar progressBar1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
