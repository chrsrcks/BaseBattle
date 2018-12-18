package gameEngine.gameObjects;

import java.awt.geom.Point2D;

public class GameObject extends Point2D {

    double x;
    double y;

    public GameObject() {
        this.x = 0;
        this.y = 0;
    }

    public GameObject(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
