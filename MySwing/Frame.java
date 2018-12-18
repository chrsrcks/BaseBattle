package MySwing;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {

        add(new Panel());
        // fullscreen
        /*setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);*/
        // ---
        setResizable(false);
        pack();

        //setTitle("Base Battle");
        //setIconImage(new ImageIcon("assets/robot.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new Frame();
            frame.setVisible(true);
        });
    }
}
