package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * A procedural map generator
 *
 * @author Charles Thomas
 * @project Procedural Generator
 */

public class Map extends JPanel {

    double[][] array;

    public Map(double[][] array){
        this.array = array;
        this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int x=0; x<this.array.length; x++){
            for (int y=0; y < this.array[x].length; y++) {
                Color c = this.getColour(x, y);
                g2d.setColor(c);
                g2d.fillRect(x, y, Window.TILE_SIZE, Window.TILE_SIZE);
            }
        }

        g2d.setColor(new Color(0, 0, 0, 119));
        g2d.fillRoundRect(10, Window.HEIGHT - 75, 100, 40, 10, 10);
    }

    /**
     * Determine color based on noise value
     *
     * @param x coordinate
     * @param y coordinate
     * @return
     */
    private Color getColour(int x, int y) {

        if(array[x][y] < 0) {
            return new Color(55, 146, 237);
        } else if (array[x][y] < .2){
            return new Color(60, 158, 255);
        } else if (array[x][y] < .4) {
            return new Color(234, 207, 163, 221);
        } else if (array[x][y] < .8) {
            return new Color(82, 164, 93, 90);
        } else if (array[x][y] <.95) {
            return new Color(89, 153, 98, 90);
        } else {
            return new Color(214, 227, 216, 255);
        }

    }
}
