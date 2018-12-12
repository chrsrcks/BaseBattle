package gameEngine;

import java.awt.geom.Point2D;

public class GameObject extends Point2D {

    double x;
    double y;

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
