import Core.SimplexNoiseGenerator;
import Core.Interface.WorldGenerator;
import Gui.Window;

/**
 * A procedural map generator
 *
 * @author Charles Thomas
 * @project Procedural Generator
 */

public class Main {

    public static void main(String[] args) {
        WorldGenerator worldGen = new SimplexNoiseGenerator(5, .5, .005);
        Window gui = new Window();

        double[][] array = worldGen.createWorld(Window.WIDTH, Window.HEIGHT);
        gui.visualize(array);
    }

}
