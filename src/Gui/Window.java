package Gui;

import Core.Interface.WorldGenerator;
import Core.Noise;
import Core.SimplexNoiseGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A procedural map generator
 *
 * @author Charles Thomas
 * @project Procedural Generator
 */

public class Window extends JFrame implements KeyListener {
    public static final int TILE_SIZE = 10;
    public static final int WIDTH = 1280;
    public static final int HEIGHT= 720;

    private JPanel map;
    private JFrame frame;
    private JLabel t;

    public void visualize(double[][] array){
        this.frame = new JFrame("Procedural Generator");
        this.map = new Map(array);

        // App icon
        try {
            URL url = new URL("https://img.icons8.com/fluency/48/000000/globe.png");
            ImageIcon icon = new ImageIcon(url);
            super.setIconImage(icon.getImage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        frame.setTitle("Procedural Generator");
        frame.add(generateSeedUI(Long.toString(Noise.seed)));
        frame.add(map);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    private JLabel generateSeedUI(String seed){
        this.t = new JLabel(seed);
        this.t.setForeground(Color.WHITE);
        this.t.setBounds(20, HEIGHT - 65, 100, 20);
        this.t.setSize(new Dimension(200, 20));

        return this.t;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            // Generate new seed and redraw
            WorldGenerator worldGen = new SimplexNoiseGenerator(4, .5, .005);
            double[][] array = worldGen.createWorld(Window.WIDTH, Window.HEIGHT);

            this.frame.remove(map);
            this.frame.remove(this.t);
            this.map = new Map(array);
            this.frame.add(generateSeedUI(Long.toString(Noise.seed)));
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
