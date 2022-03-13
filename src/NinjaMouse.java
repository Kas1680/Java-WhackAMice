import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;



public class NinjaMouse extends Mouse {
    private static final Duration SEC_2 = Duration.millis(200);
    private static final Duration SEC_6 = Duration.millis(600);
    private static final Duration SEC_01 = Duration.millis(10);
    private Group ninjaMouse;

    private int posX;
    private int posY;


    // Create ninja mouse and randomize starting position with NinjaMove
    public NinjaMouse(Color noseColor){
        super(noseColor);
        ninjaMouse = this.getGroup();
        NinjaMove();
    }



    // activate Ninjutsu consist of 5 parts:
    // 1) Parallell transition Intonjutsu1 includes: horizontal move and fade out (0.2 second)
    // 2) Parallel transition Intonjutsu2 incldues: vertical move and fade in (0.2 second)
    // 3) Pause transition for 0.6 seconds to make up 1 second
    // 4) Parallel Transition smokebomb includes: (x, y) origin to a random (x, y)
    // to achieve the effect of teleporting     : Fade in and fade out
    // All 4 of this components are grouped under a sequential transition ninjutsu
    public void activateNinjutsu(){

        TranslateTransition kotariX = new TranslateTransition(SEC_2);
        kotariX.setFromX(posX);
        kotariX.setToX(posX + this.getNinjaMoveX());
        FadeTransition intonjutsuOut = new FadeTransition(SEC_2);
        intonjutsuOut.setFromValue(1.0);
        intonjutsuOut.setToValue(1);


        ParallelTransition Intonjutsu1 =
                new ParallelTransition(this.ninjaMouse, kotariX, intonjutsuOut);
        Intonjutsu1.play();


        TranslateTransition kotariY = new TranslateTransition(SEC_2);
        kotariY.setFromY(posY);
        kotariY.setToY(posY + this.getNinjaMoveY());
        FadeTransition intonjuTsuIn = new FadeTransition(SEC_2);
        intonjuTsuIn.setFromValue(0);
        intonjuTsuIn.setToValue(1.0);


        ParallelTransition Intonjutsu2 =
                new ParallelTransition(this.ninjaMouse, kotariY, intonjuTsuIn);

        PauseTransition rest = new PauseTransition(SEC_6);

        TranslateTransition poff = new TranslateTransition(SEC_01);
        poff.setFromX(posX);
        poff.setFromY(posY);
        poff.setToX(posX + getNinjaMoveX());
        poff.setToY(posY + getNinjaMoveY());

        FadeTransition nowYouSeeMe = new FadeTransition(SEC_01);
        nowYouSeeMe.setFromValue(1);
        nowYouSeeMe.setToValue(0);

        FadeTransition nowYouDont = new FadeTransition(SEC_01);
        nowYouDont.setFromValue(0);
        nowYouDont.setToValue(1);

        ParallelTransition smokeBomb =
                new ParallelTransition(this.ninjaMouse, nowYouSeeMe, poff, nowYouDont);

        SequentialTransition ninjutsu =
                new SequentialTransition(Intonjutsu1, Intonjutsu2, rest, smokeBomb);
        ninjutsu.play();
    }

    // Randomize starting coordinate
    public void NinjaMove(){
        RandomCoordinateGenerator rand = new RandomCoordinateGenerator();
        rand.setMove();
        this.posX = rand.getxMove();
        this.posY = rand.getyMove();
    }

    // randomize the scale to move in x y direction. Random coordinator receive an int
    // of the range - max move to + max move. getNinjaMove calculate the distance
    // a mouse allowed to move in the x or y direction.
    public int getNinjaMoveX(){
        int ninjaMoveX = new RandomCoordinateGenerator().getNinjaXMove();
        while(ninjaMoveX + posX < 0 || ninjaMoveX + posX > 661){
            ninjaMoveX = new RandomCoordinateGenerator().getxMove();
        }
        return ninjaMoveX;
    }

    public int getNinjaMoveY(){
        int ninjaMoveY = posY + new RandomCoordinateGenerator().getNinjaYMove();
        while(ninjaMoveY + posY < 0 || ninjaMoveY + posY > 416){
            ninjaMoveY = new RandomCoordinateGenerator().getNinjaYMove();
        }
        return ninjaMoveY;
    }
}
