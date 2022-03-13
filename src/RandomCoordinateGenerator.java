
import java.util.Random;


// Generate random x and y no larger than x = 661 and y = 416
// gameStage is 800 x 600. Mice width and height is 140/185
// max x can only be 800 - 140 = 660
// max y can only be 600 - 185 = 415
public class RandomCoordinateGenerator {
    private Random rand;
    private int xMove;
    private int yMove;

    private static final int maxXMove = 661;
    private static final int maxYMove = 416;

    // Create new random and set the initial x and y value
    public RandomCoordinateGenerator(){
        this.rand = new Random();
        this.setMove();
    }

    // randomize x and y with upper bound
    public void setMove(){
        this.xMove = rand.nextInt(maxXMove);
        this.yMove = rand.nextInt(maxYMove);
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }

    // Ninja mice can move in both X and Y direction. We randomize the X value between -661 to 661
    // and Y value between -416 to 416. NinjaMouse have methods to check for out of bound.
    public int getNinjaXMove(){
        return rand.nextInt((maxXMove - (-maxXMove)) + 1) -maxXMove;
    }

    public int getNinjaYMove(){
        return rand.nextInt((maxYMove - (-maxYMove)) + 1) -maxYMove;
    }
}
