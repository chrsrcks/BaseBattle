package MySwing;

import gameEngine.Player;
import gameEngine.Tilemap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements Runnable {

    private int width = 640;
    private int height = 480;
    private final int DELAY = 10;
    private Thread animator;
    private Image img_robot;
    private Image[] img_tile = new Image[2];
    private Tilemap tilemap;
    private Player player;
    private int[][] map;

    public Panel() {

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addKeyListener(new Input());
        setBackground(Color.DARK_GRAY);

        loadImages();
        int imgW = img_robot.getWidth(this);
        int imgH = img_robot.getHeight(this);
        player = new Player(width/2,height/2,img_robot,imgW,imgH,2);

        map = new int[][]{ // TODO load file
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1},
            {1,1,1,1,2,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,2,1,1},
            {1,1,1,1,1,1,1,1,1,1},
        };
        tilemap = new Tilemap(10, 7,64, img_tile, map);
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
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        tilemap.drawTiles(g);
        player.draw(g);

        tilemap.drawDebug(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private class Input extends KeyAdapter {

        private boolean strgHold;

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_CONTROL) strgHold = true;
            if (key == KeyEvent.VK_D && strgHold) tilemap.debug = !tilemap.debug;
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_CONTROL) strgHold = false;
        }

    }

    private void loadImages() {

        ImageIcon ii = new ImageIcon("assets/robot.png");
        img_robot = ii.getImage();
        ii = new ImageIcon("assets/tile_1.png");
        img_tile[0] = ii.getImage();
        ii = new ImageIcon("assets/tile_2.png");
        img_tile[1] = ii.getImage();
    }

}
