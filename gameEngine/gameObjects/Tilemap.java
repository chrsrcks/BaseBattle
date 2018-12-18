package gameEngine.gameObjects;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Tilemap extends Matrix {

    private Image[] images;
    private int[][] map;

    public Tilemap(double _x, double _y, int _w, int _h, int _s, Image[] _i, int[][] _m) {
        super(_x, _y, _w, _h, _s);
        this.images = _i;
        this.map = _m;
    }

    public void drawTiles(Graphics g) {

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {

                if (map[y][x] != 0) // 0 = emty
                {
                    int posX = ((int) this.x) + (x*this.nodeSize);
                    int posY = ((int) this.y) + (y*this.nodeSize);
                    g.drawImage(this.images[map[y][x] - 1], posX, posY, null);
                }

            }
        }

    }

    public int click(MouseEvent e) {

        int mX = e.getX();
        int mY = e.getY();
        int tile=0;

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {

                int posX = ((int) this.x) + (x*this.nodeSize);
                int posY = ((int) this.y) + (y*this.nodeSize);

                if ( mX >= posX && mX <= posX + this.nodeSize
                  && mY >= posY && mY <= posY + this.nodeSize)
                {
                    tile = this.map[y][x]; // TODO getTile()
                }

            }
        }
        return tile;
    }

    @Override
    public void drawDebug(Graphics g) {
        super.drawDebug(g);

        g.setColor(Color.green);

        if (this.debug) {
            g.drawString(String.format("pos: %s : %s", this.x, this.y), (int) this.x, (int) this.y);

            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {

                    g.drawString("img: " + map[y][x], x * this.nodeSize, y * this.nodeSize + 40);
                }
            }
        }


    }
}
