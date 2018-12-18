package gameEngine;

import javax.swing.*;
import java.awt.*;

public abstract class Game {

    protected double width;
    protected double height;
    protected JPanel panel;

    public Game(JPanel panel) {
        this.panel = panel;
        Dimension d = this.panel.getToolkit().getScreenSize();
        this.width = d.getWidth();
        this.height = d.getHeight();
    }

    protected abstract void draw(Graphics g);

    protected abstract void update();
}
