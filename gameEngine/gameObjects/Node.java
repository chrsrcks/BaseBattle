package gameEngine.gameObjects;

import java.awt.*;

public class Node {

    private int x;
    private int y;
    private int size;

    public Node(int _x, int _y, int _size) {
        x = _x;
        y = _y;
        size = _size;
    }

    public /*final*/ Node clicked(int mX, int mY) {

        if (mX >= x && mX <= x + size
            && mY >= y && mY <= y + size)

            return this;
        else
            return null;
    }

    public void drawBorder(Graphics2D g2d, Color c) {

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor( c );
        g2d.drawRect(x, y, size, size);
    }

    public void drawDebug(Graphics2D g2d, Color c) {

        drawBorder(g2d, c);
        g2d.setColor( c );
        g2d.drawString(" x: " + x + " y: " + y, x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        return "Node:\n" +
                "x: "+ this.x +"\n"+
                "y: "+ this.y +"\n"+
                "size: "+ this.size;
    }

}
