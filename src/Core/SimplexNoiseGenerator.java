package Core;

import Core.Interface.WorldGenerator;

import java.util.Random;

public class SimplexNoiseGenerator implements WorldGenerator {

    private double SCALE;
    private double ROUGHNESS;
    private int OCTAVES;

    public SimplexNoiseGenerator(int ocatves, double roughness, double scale) {
        this.SCALE = scale;
        this.ROUGHNESS = roughness;
        this.OCTAVES = ocatves;
    }

    @Override
    public double[][] createWorld(int width, int height) {
        return generateOctavedSimplexNoise(width, height);
    }

    private double[][] generateOctavedSimplexNoise(int width, int height) {
        double[][] totalNoise = new double[width][height];
        double layerFrequency = SCALE;
        double layerWeight = 1;
        double weightSum = 0;

        Random r = new Random();
        Noise.setSeed(r.nextInt(Integer.MAX_VALUE));

        System.out.println("[SEED] " + Noise.seed);

        // Summing up all octaves, the whole expression makes up a weighted average
        // computation where the noise with the lowest frequencies have the least effect

        for (int octave = 0; octave < OCTAVES; octave++) {
            // Calculate single layer/octave of simplex noise, then add it to total noise
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    totalNoise[x][y] += Noise.noise(x * layerFrequency, y * layerFrequency) * layerWeight;
                }
            }

            // Increase variables with each incrementing octave
            layerFrequency *= 2;
            weightSum += layerWeight;
            layerWeight *= ROUGHNESS;

        }
        return totalNoise;
    }
}
