package Gui;

import Core.Interface.WorldGenerator;
import Core.SimplexNoiseGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements KeyListener {
    public static final int TILE_SIZE = 10;
    public static final int WIDTH = 1280;

    public static final int HEIGHT= 720;

    private JPanel map;
    private JFrame frame;

    public void visualize(double[][] array){
        frame = new JFrame("Procedural Generator");
        Dimension dim = new Dimension(WIDTH, HEIGHT);
        this.map = new Map(array);

        frame.add(map);
        frame.setSize(dim);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            // Generate new seed and redraw

            WorldGenerator worldGen = new SimplexNoiseGenerator(4, .5, .005);
            double[][] array = worldGen.createWorld(Window.WIDTH, Window.HEIGHT);

            this.frame.remove(map);
            this.map = new Map(array);
            this.frame.add(map);
            this.frame.revalidate();
            this.frame.repaint();
        } else if (e.getKeyCode() == 0) {
            this.frame.setVisible(false);
            this.frame.dispose();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
