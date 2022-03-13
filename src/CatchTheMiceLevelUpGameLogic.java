import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class CatchTheMiceLevelUpGameLogic {
    private InfoArea infoArea;
    private GameStage gameStage;
    private int numberOfMiceLeft;
    protected int level;
    private int score;
    private static final int max_level = 5;
    private Boolean isFade;
    private Boolean isNinja;

    public CatchTheMiceLevelUpGameLogic(){
        this.setTheStage();
    }

    // Constructor initialize the gameStage and infoArea and also
    // set some instance variables to default values
    public void setTheStage(){
        this.infoArea = new InfoArea();
        this.gameStage = new GameStage();
        this.score = 0;
        this.infoArea.getLevelText().setText("Level: ");
        this.isNinja = false;
    }



    /**
     * Begin the game here depending on if it's LevelUp, Final or Ninja
     * Levelup start automatically, Final or Ninja need to press startButton
     * @param levelEntry level to be entered, default to 1 in LevelUp
     * @param isFade only true for Final
     */
    public void startGame(int levelEntry, Boolean isFade){
        this.isFade = isFade;
        this.level = levelEntry;
        this.numberOfMiceLeft = this.level;
        this.spawnMoreMice();
        this.infoArea.getLevelText().setText("Level: " + this.level);
    }

    // Main logic component
    public void mouseClicked(Mouse mouse){
        // Hide mouse
        mouse.hide();

        // update the score and score label
        this.score ++;
        String s = String.format("Score: %d", this.score);
        this.infoArea.getScore().setText(s);

        // update number of mice
        this.numberOfMiceLeft --;

        // Check for mice == 0, then check for current level != 5.
        // if both condition satisfied, level up the game, clean up the game of mice corpses,
        // then spawn more preys
        if(this.numberOfMiceLeft == 0){
            if(this.level != max_level) {
                this.levelup();
                this.cleanup();
                this.spawnMoreMice();
            } else{
                // if current level = 5, invoke gameOver
                this.gameOver();
            }
        }
    }


    // Level up the game, update level up label, reset # of mice equal to current level
    public void levelup(){
        this.level++;
        String s = String.format("Level: %d", this.level);
        this.infoArea.getLevelText().setText(s);
        this.numberOfMiceLeft = this.level;
    }

    // Clear the stage
    public void cleanup(){
        gameStage.getMouseArea().getChildren().clear();
    }


    /**
     * Spawn different mice with different properties depending on instance variables
     * isFade and isNinja
     * Default regular mice with no Fade in LevelUp
     */
    public void spawnMoreMice(){

        // Declare mouse object

        Mouse mouse;
        // For each level, we give the mouse object a certain properties
        for(int i = 0; i < this.level; i++){
            RandomCoordinateGenerator rand = new RandomCoordinateGenerator();

            // isNinja = true, we create a ninjaMouse object and invoke activateNinjutsu
            if(this.isNinja){
                this.spawnNinjaMice();
                return;
            // Just a regular mickey (hope I don't violate copyright?)
            }else{
                mouse = new Mouse(new RandomColorGenerator().getColor());
                mouse.move(rand.getxMove(), rand.getyMove());

            }
            // Fade the mouse into the stage in 0.5 second
            if (this.isFade) {
                FadeTransition fade = new FadeTransition(Duration.seconds(0.5), mouse.getGroup());
                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();
            }

            // Hookup the mouse object with MouseEventHandler and add to the stage
            mouse.getGroup().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(this, mouse));
            this.gameStage.getMouseArea().getChildren().add(mouse.getGroup());
        }
    }


    public void spawnNinjaMice(){
        for(int j = 0; j < this.level; j++){
            NinjaMouse ninjamouse = new NinjaMouse(new RandomColorGenerator().getColor());
            ninjamouse.activateNinjutsu();
            ninjamouse.getGroup().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(this, ninjamouse));
            this.gameStage.getMouseArea().getChildren().add(ninjamouse.getGroup());

        }
    }

    // if max level is reached, invoke gameOver and a pop-up dialog box show up
    public void gameOver(){
        String s = "You've reached the daily limit " +
                "for pulverizing these pesky mice!";
        Stage dialog = new Stage();
        dialog.setTitle("Game Over!");
        dialog.initStyle(StageStyle.UTILITY);
        Text text = new Text(0,0, s);
        text.setFont(Font.font(15));
        HBox h = new HBox(text);
        h.setPadding(new Insets(20));
        Scene scene = new Scene(h);
        dialog.setScene(scene);
        dialog.getScene().getWindow().sizeToScene();
        dialog.show();

    }


    public void setNinja(Boolean ninja) {
        isNinja = ninja;
    }

    public InfoArea getInfoArea() {
        return infoArea;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setFade(Boolean fade) {
        isFade = fade;
    }

    public Boolean getNinja() {
        return isNinja;
    }
}


