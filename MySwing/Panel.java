package MySwing;


import game.MyGame;
//import game.MouseInput;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    private MyGame myGame;
    private final int DELAY = 10;
    private Thread animator;


    public Panel() {

        myGame = new MyGame(this);

        setFocusable(true);
        //addKeyListener(new KeyInput());
        //addMouseListener(new MouseInput());
        //setBackground(Color.DARK_GRAY);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    } // start new thread

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            update();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0)  sleep = 2;

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    } // run update & repaint

    private void update() {
        myGame.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        myGame.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }





}
