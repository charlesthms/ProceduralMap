package Core;

import Core.Interface.WorldGenerator;

import java.util.Random;

public class World implements WorldGenerator {

    @Override
    public double[][] createWorld(int width, int height) {
        double[][] map = new double[width][height];

        Random r = new Random();

        for(int x = 0; x<map.length; x++) {
            for(int y = 0; y < map[x].length; y++) {
                map[x][y] = r.nextInt(2); //Random value between 0 and 1;
            }
        }
        return map;
    }

}
