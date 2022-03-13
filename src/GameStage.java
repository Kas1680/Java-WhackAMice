
import javafx.scene.layout.Pane;


/**
 * The left panel of the game. This is the area where all the actions are
 */
public class GameStage {
    private Pane mouseArea;



    public GameStage(){
        Pane mouseArea = new Pane();
        mouseArea.setPrefSize(800, 600);
        mouseArea.setStyle("-fx-background-color: white");

        this.mouseArea = mouseArea;
    }

    public Pane getMouseArea() {
        return mouseArea;
    }


}
