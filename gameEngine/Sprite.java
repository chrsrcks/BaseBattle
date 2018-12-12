package gameEngine;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite extends GameObject {

    private Image img;
    private int imgW; // width
    private int imgH; // height

    public Sprite(double _x, double _y, Image _img, int _imgW, int _imgH) {
        super(_x, _y);
        this.img = _img;
        this.imgW = _imgW;
        this.imgH = _imgH;
    }

    public void draw(Graphics g) {

        g.drawImage(this.img, (int) this.x - (this.imgW/2), (int) (this.y - (this.imgH/2)), null);
    }
}
