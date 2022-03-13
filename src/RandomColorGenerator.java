

import javafx.scene.paint.Color;

import java.util.Random;


// Generate random RGB float value, create and return a new color
public class RandomColorGenerator {

    public RandomColorGenerator(){
    }

    public Color getColor() {
        float r = new Random().nextFloat();
        float g = new Random().nextFloat();
        float b = new Random().nextFloat();
        Color color = new Color(r, g, b, 1);
        return color;
    }

}
