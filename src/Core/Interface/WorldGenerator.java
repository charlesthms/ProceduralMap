package Core.Interface;

/**
 * A procedural map generator
 *
 * @author Charles Thomas
 * @project Procedural Generator
 */

public interface WorldGenerator {
    double[][] createWorld(int width, int height);
}
