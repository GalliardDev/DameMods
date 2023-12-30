/*
 * Created by JFormDesigner on Sat Dec 30 05:19:00 CET 2023
 */

package dev.galliard.damemods.ui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author jomaa
 */
public class UIDameMods extends JFrame {
    private UIDameMods() {
        initComponents();
    }

    public static UIDameMods getInstance() {
        return new UIDameMods();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
        panel1 = new JPanel();
        label1 = new JLabel();
        minimizeBtn = new JButton();
        closeBtn = new JButton();
        subTitle1Label = new JLabel();
        subTitle2Label = new JLabel();
        downloadBtnsWrapper = new JPanel();
        nonPresentBtn = new JButton();
        allBtn = new JButton();
        listPane = new JScrollPane();
        list = new JList();

        //======== this ========
        setResizable(false);
        setUndecorated(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
            "[grow,fill]",
            // rows
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[grow,fill]"));

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("Dame Mods client v1.0");
            label1.setPreferredSize(new Dimension(220, 40));
            label1.setMinimumSize(new Dimension(220, 40));
            label1.setMaximumSize(new Dimension(220, 40));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
            label1.setOpaque(true);
            label1.setIcon(new ImageIcon(getClass().getResource("/images/smurf_small.png")));
            label1.setIconTextGap(6);

            //---- minimizeBtn ----
            minimizeBtn.setMaximumSize(new Dimension(47, 40));
            minimizeBtn.setMinimumSize(new Dimension(47, 40));
            minimizeBtn.setPreferredSize(new Dimension(47, 40));
            minimizeBtn.setBorder(null);
            minimizeBtn.setIcon(new ImageIcon(getClass().getResource("/images/minimize_small.png")));
            minimizeBtn.setBackground(new Color(0x24292e));

            //---- closeBtn ----
            closeBtn.setPreferredSize(new Dimension(47, 40));
            closeBtn.setMinimumSize(new Dimension(47, 40));
            closeBtn.setMaximumSize(new Dimension(47, 40));
            closeBtn.setBorder(null);
            closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/close_small.png")));
            closeBtn.setBackground(new Color(0x24292e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(minimizeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
        }
        contentPane.add(panel1, "cell 0 0");

        //---- subTitle1Label ----
        subTitle1Label.setText("El cliente definitivo para descargar mods");
        subTitle1Label.setFont(subTitle1Label.getFont().deriveFont(subTitle1Label.getFont().getStyle() & ~Font.BOLD, subTitle1Label.getFont().getSize() + 9f));
        subTitle1Label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(subTitle1Label, "cell 0 1");

        //---- subTitle2Label ----
        subTitle2Label.setText("de nuestros servers de Maincra.");
        subTitle2Label.setFont(subTitle2Label.getFont().deriveFont(subTitle2Label.getFont().getStyle() & ~Font.BOLD, subTitle2Label.getFont().getSize() + 9f));
        subTitle2Label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(subTitle2Label, "cell 0 2");

        //======== downloadBtnsWrapper ========
        {
            downloadBtnsWrapper.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]"));

            //---- nonPresentBtn ----
            nonPresentBtn.setText("Descargar faltantes");
            nonPresentBtn.setFont(nonPresentBtn.getFont().deriveFont(nonPresentBtn.getFont().getSize() + 4f));
            nonPresentBtn.setIcon(new ImageIcon(getClass().getResource("/images/download_small.png")));
            nonPresentBtn.setIconTextGap(12);
            downloadBtnsWrapper.add(nonPresentBtn, "pad 0 3 0 0,cell 0 0,height 40:40:40");

            //---- allBtn ----
            allBtn.setText("Descargar todos");
            allBtn.setFont(allBtn.getFont().deriveFont(allBtn.getFont().getSize() + 4f));
            allBtn.setIcon(new ImageIcon(getClass().getResource("/images/download_small.png")));
            allBtn.setIconTextGap(12);
            downloadBtnsWrapper.add(allBtn, "pad 0 0 0 -3,cell 1 0,height 40:40:40");
        }
        contentPane.add(downloadBtnsWrapper, "cell 0 3");

        //======== listPane ========
        {
            listPane.setViewportView(list);
        }
        contentPane.add(listPane, "pad 0 10 -10 -10,cell 0 4");
        setSize(400, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
    private JPanel panel1;
    private JLabel label1;
    private JButton minimizeBtn;
    private JButton closeBtn;
    private JLabel subTitle1Label;
    private JLabel subTitle2Label;
    private JPanel downloadBtnsWrapper;
    private JButton nonPresentBtn;
    private JButton allBtn;
    private JScrollPane listPane;
    private JList list;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
