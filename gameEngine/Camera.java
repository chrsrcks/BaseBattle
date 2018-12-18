package gameEngine;

import gameEngine.gameObjects.Mover;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Camera extends Mover {

    public Camera(double _x, double _y, Image _img, int _imgW, int _imgH, int _speed) {
        super(_x, _y, _img, _imgW, _imgH, _speed);
    }

    private class KeyInput extends KeyAdapter {

        private boolean strgHold;

        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) { // left
                dx = -1;
            } else if (key == KeyEvent.VK_D) { // right
                dx = 1;
            }
            if (key == KeyEvent.VK_W) { // up
                dy = -1;
            } else if (key == KeyEvent.VK_S) { // down
                dy = 1;
            }
        }

        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                dx = 0;
            }

            if (key == KeyEvent.VK_D) {
                dx = 0;
            }

            if (key == KeyEvent.VK_W) {
                dy = 0;
            }

            if (key == KeyEvent.VK_S) {
                dy = 0;
            }
        }

    }
}
