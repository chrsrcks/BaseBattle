package game;

import gameEngine.Game;
import gameEngine.gameObjects.Node;
import gameEngine.gameObjects.Tilemap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyGame extends Game {

    // matrix
    private final int matrixW = 10;
    private final int matrixH = 8;
    private final int tileSize = 64;
    private Lands landsMatrix;
    private Node selectedLand;
    // tilemap
    private Tilemap tM_streets;
    private Image[] img_streets = new Image[13];
    private int[][] map_streets = { // TODO load file
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,0,0,0,0},
            {1,1,5,13,13,13,8,1,1,1},
            {3,3,3,3,6,7,3,3,3,3},
            {0,0,0,0,2,4,0,0,0,0},
            {0,0,0,0,2,4,0,0,0,0},
            {0,0,0,0,2,4,0,0,0,0}
    };
    private Tilemap tM_buildings;
    private int numBuildImg = 4;
    private Image[] img_buildings = new Image[numBuildImg];
    private int[][] map_buildings = { // TODO load file
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,4,1,2,3,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
    };


    public MyGame(JPanel p) {
        super(p);

        p.setPreferredSize(new Dimension(640,512));
        p.setBackground(Color.getHSBColor(0.3f,.6f,.7f));
        p.addMouseListener(new MouseInput());

        loadImages();

        double tMposX = 0; // (this.width/2)-((matrixW/2) * this.tileSize); // center map
        double tMposY = 0; // (this.height/2)-((matrixH/2) * this.tileSize);
        tM_buildings = new Tilemap(tMposX,tMposY, matrixW, matrixH, tileSize, img_buildings, map_buildings);
        tM_streets   = new Tilemap(tMposX,tMposY, matrixW, matrixH, tileSize, img_streets, map_streets);


        landsMatrix = new Lands(tMposX, tMposY, matrixW, matrixH, tileSize);
        for (int i=0; i < landsMatrix.getLength(); i++) {
            //System.out.println(( i % this.width )+" : "+( i / this.height ));
            landsMatrix.add( i, new Land(i % matrixW, i/matrixH, tileSize));
        }
        System.out.println(landsMatrix.getNode(5, 4));
    }

    public void draw(Graphics g) {
        drawSky(g);
        tM_streets.drawTiles(g);
        tM_buildings.drawTiles(g);

        if (null != selectedLand) selectedLand.drawBorder((Graphics2D) g, Color.red);


        tM_streets.drawDebug(g);
        tM_buildings.drawDebug(g);
    }

    public void update() {

    }

    private void loadImages() {

        ImageIcon ii;

        for (int i = 0; i < numBuildImg; i++) {
            ii = new ImageIcon("assets/tile_"+ (i+1) +".png");
            img_buildings[i] = ii.getImage();
        }
        for (int i = 0; i < 13; i++) {
            ii = new ImageIcon("assets/street_"+ (i+1) +".png");
            img_streets[i] = ii.getImage();
        }

    }

    // -- mouse listener --
    private class MouseInput implements MouseListener {

        public void mousePressed(MouseEvent e) {
            /*log("Mouse pressed; # of clicks: "
                    + e.getClickCount(), e);*/
        }

        public void mouseReleased(MouseEvent e) {
            /*log("Mouse released; # of clicks: "
                    + e.getClickCount(), e);*/
        }

        public void mouseEntered(MouseEvent e) {
            /*log("Mouse entered", e);*/
        }

        public void mouseExited(MouseEvent e) {
            /*log("Mouse exited", e);*/
        }

        public void mouseClicked(MouseEvent e) {
            log("Mouse clicked (# of clicks: "
                    + e.getClickCount() + ")", e);

            // TODO drawInfo()
            int mX = e.getX();
            int mY = e.getY();

            if (null != landsMatrix.clicked(mX, mY)) {
                log("tileImg Index: " + landsMatrix.clicked(mX, mY), e);
                selectedLand = landsMatrix.clicked(mX, mY);
            } else
                log("Hä!?", e);
        }

        void log(String eventDescription, MouseEvent e) {
            System.out.println(eventDescription + " detected on "
                    + e.getComponent().getClass().getName()
                    + "." + "\n");
        }
    }

    private void drawSky(Graphics g) {

        g.setColor(Color.getHSBColor(.55f,.5f,1f));
        g.fillRect(0,0,(int)this.width, /*(int)(this.height/2)-((matrixH/2) * */ 2*64/*)*/);
    }

}
