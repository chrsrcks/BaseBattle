package gameEngine.gameObjects;

import java.awt.*;

public class Matrix extends GameObject {

    protected final int width;
    protected final int height;
    protected int nodeSize;
    private Node[] allNodes;
    public boolean debug=false;

    public Matrix(double _x, double _y, int _w, int _h, int _s) {
        super(_x, _y);
        this.width = _w;
        this.height = _h;
        this.nodeSize = _s;
        allNodes = new Node[this.width * this.height];
    }
    public Matrix(double _x, double _y, int _w, int _h, int _s, boolean _f) {
        this(_x, _y, _w, _h, _s);
        this.fill();
    }
    public Matrix(double _x, double _y, int _w, int _h, int _s, Node _node) {
        this(_x, _y, _w, _h, _s);
        this.fill(_node);
    }

    public void fill() {
        for (int i=0; i < allNodes.length; i++) {
            //System.out.println(( i % this.width )+" : "+( i / this.height ));
            allNodes[i] = new Node(i%this.width, i/this.height, this.nodeSize);
        }
    }

    public void fill(Node node) {
        for (int i=0; i < allNodes.length; i++) {
            //System.out.println(( i % this.width )+" : "+( i / this.height ));
            allNodes[i] = node;
            allNodes[i].setX( i % this.width );
            allNodes[i].setY( i / this.height);
            allNodes[i].setSize(this.nodeSize);
        }
    }

    public Node clicked(int mouseX, int mouseY) {

        Node re = null;

        for (Node n : allNodes) {
            if (null != n.clicked(mouseX, mouseY))
                re = n;
        }
        return re;
    }

    public void add(int i, Node n) {
        allNodes[i] = n;
    }

    public int getLength() {
        return allNodes.length;
    }

    public Node getNode(int x, int y) {

        x = (x > this.width ) ? this.width-1 : x;
        y = (y > this.height) ? this.height-1 : y;

        return allNodes[y * width + x];
    }

    public void drawDebug(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (this.debug) {

            for (Node node : allNodes) {
                node.drawDebug( g2d, Color.green );
            }
        }

    }

    public String toString() {

        return "Matrix:\n" +
                "width: "+ this.width +"\n"+
                "height: "+ this.height +"\n"+
                "node size: "+ this.nodeSize;
    }
}
