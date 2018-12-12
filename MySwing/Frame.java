package MySwing;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {

        add(new Panel());

        setResizable(false);
        pack();

        setTitle("My first Java App");
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