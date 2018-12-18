package gameEngine.gameObjects;

import java.awt.Image;

public class Mover extends Sprite {

    private int speed;
    protected int dx=0; // direction x
    protected int dy=0; // direction y

    public Mover(double _x, double _y, Image _img, int _imgW, int _imgH, int _speed) {
        super( _x, _y, _img, _imgW, _imgH);
        this.speed = _speed;
    }

    public void update() {

        int speed;

        if (this.dx != 0 && this.dy != 0) speed = this.speed / 2;
        else speed = this.speed;

        this.x += this.dx * speed;
        this.y += this.dy * speed;

    }

    /*public void tryMove(int _dirX, int _dirY) {

        this.x += _dirX * this.speed;
        this.y += _dirY * this.speed;

    }*/



}