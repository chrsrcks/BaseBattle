package gameEngine.gameObjects;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player extends Mover {

    private int KEY_LEFT = KeyEvent.VK_A;
    private int KEY_RIGHT = KeyEvent.VK_D;
    private int KEY_UP = KeyEvent.VK_W;
    private int KEY_DOWN = KeyEvent.VK_S;

    public Player(double _x, double _y, Image _img, int _imgW, int _imgH, int _speed) {
        super(_x, _y, _img, _imgW, _imgH, _speed);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KEY_LEFT) { // left
            this.dx = -1;
        } else if (key == KEY_RIGHT) { // right
            this.dx = 1;
        }
        if (key == KEY_UP) { // up
            this.dy = -1;
        } else if (key == KEY_DOWN) { // down
            this.dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KEY_LEFT || key == KEY_RIGHT) this.dx = 0; // not testet this version
        if (key == KEY_UP) this.dy = 0;
        if (key == KEY_DOWN) this.dy = 0;
    }
}
