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
    }

    public static UIDameMods getInstance() {
        return new UIDameMods();
    }

    private void closeBtnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void minimizeBtnActionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        if(frame.getState()!=Frame.ICONIFIED) {
            frame.setState(Frame.ICONIFIED);
        } else {
            frame.setState(Frame.NORMAL);
        }
    }

    private void minimizeBtnMouseEntered(MouseEvent e) {
        minimizeBtn.setBackground(new Color(0x353F44));
    }

    private void minimizeBtnMouseExited(MouseEvent e) {
        minimizeBtn.setBackground(new Color(0x24292e));
    }

    private void closeBtnMouseEntered(MouseEvent e) {
        closeBtn.setBackground(new Color(0xc42b1c));
    }

    private void closeBtnMouseExited(MouseEvent e) {
        closeBtn.setBackground(new Color(0x24292e));
    }

    private void panel1MouseDragged(MouseEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());

        // Calcular la nueva posición de la ventana
        int newX = frame.getLocation().x + e.getX() - posX;
        int newY = frame.getLocation().y + e.getY() - posY;

        // Establecer la nueva posición de la ventana
        frame.setLocation(newX, newY);
    }

    private void panel1MousePressed(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
        panel1 = new JPanel();
        label1 = new JLabel();
        minimizeBtn = new JButton();
        closeBtn = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        btnWrapper = new JPanel();
        allBtn = new JButton();

        //======== this ========
        setResizable(false);
        setUndecorated(true);
        setTitle("Dame Mods client v1.0");
        setIconImage(new ImageIcon(getClass().getResource("/images/smurf_small.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 5 5",
            // columns
            "[fill]",
            // rows
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[grow,fill]"));

        //======== panel1 ========
        {
            panel1.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    panel1MouseDragged(e);
                }
            });
            panel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    panel1MousePressed(e);
                }
            });

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
            minimizeBtn.addActionListener(e -> minimizeBtnActionPerformed(e));
            minimizeBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    minimizeBtnMouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    minimizeBtnMouseExited(e);
                }
            });

            //---- closeBtn ----
            closeBtn.setPreferredSize(new Dimension(47, 40));
            closeBtn.setMinimumSize(new Dimension(47, 40));
            closeBtn.setMaximumSize(new Dimension(47, 40));
            closeBtn.setBorder(null);
            closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/close_small.png")));
            closeBtn.setBackground(new Color(0x24292e));
            closeBtn.addActionListener(e -> closeBtnActionPerformed(e));
            closeBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    closeBtnMouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    closeBtnMouseExited(e);
                }
            });

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

        //---- label2 ----
        label2.setText("Servidor: X");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));
        contentPane.add(label2, "cell 0 1");

        //---- label3 ----
        label3.setText("Versi\u00f3n: Y | Peso: Z");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));
        contentPane.add(label3, "cell 0 2");

        //======== btnWrapper ========
        {
            btnWrapper.setLayout(new MigLayout(
                "insets 0,hidemode 3,align center center,gap 5 5",
                // columns
                "[grow,fill]",
                // rows
                "[grow,fill]"));

            //---- allBtn ----
            allBtn.setText("Requisitos y Mods");
            allBtn.setFont(allBtn.getFont().deriveFont(allBtn.getFont().getStyle() | Font.BOLD, allBtn.getFont().getSize() + 10f));
            allBtn.setIcon(new ImageIcon(getClass().getResource("/images/download_small.png")));
            allBtn.setIconTextGap(12);
            allBtn.setFocusable(false);
            btnWrapper.add(allBtn, "pad 0 0 -10 10,cell 0 0,align center center,grow 0 0,height 60:60:60");
        }
        contentPane.add(btnWrapper, "cell 0 3");
        setSize(400, 210);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - José Manuel Amador Gallardo (José Manuel Amador)
    protected static JPanel panel1;
    protected static JLabel label1;
    protected static JButton minimizeBtn;
    protected static JButton closeBtn;
    protected static JLabel label2;
    protected static JLabel label3;
    protected static JPanel btnWrapper;
    protected static JButton allBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
