package MySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    private int width = 640;
    private int height = 480;
    private Image img_robot;
    private boolean running;

    public Panel() {

        addKeyListener(new Listener());
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        setBackground(Color.DARK_GRAY);


        ImageIcon icon_robot = new ImageIcon("robot.png");

        img_robot = icon_robot.getImage();

        running = true;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            g.drawImage(img_robot, 300, 200, this);



        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {

        }
    }
}
