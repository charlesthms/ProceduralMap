import Core.SimplexNoiseGenerator;
import Core.World;
import Core.Interface.WorldGenerator;
import Gui.Window;

public class Main {

    public static void main(String[] args) {
        WorldGenerator worldGen = new SimplexNoiseGenerator(5, .5, .005);
        Window gui = new Window();

        double[][] array = worldGen.createWorld(Window.WIDTH, Window.HEIGHT);
        gui.visualize(array);

    }

}
