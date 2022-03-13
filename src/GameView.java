
import javafx.scene.layout.*;


public class GameView {

    private GridPane gameArea;

    /**
     * The container for both left and right panel (gameStage and infoArea)
     * Initialize the gameView with certain matrices
     */
    public GameView(){
        GridPane gameArea = new GridPane();
        gameArea.setPrefSize(1000, 600);

        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setPercentWidth(80);
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setPercentWidth(20);
        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(100);
        gameArea.getRowConstraints().add(rc);
        gameArea.getColumnConstraints().addAll(cc1, cc2);

        this.gameArea = gameArea;
    }

    public GridPane getGameArea() {
        return gameArea;
    }
}
