import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


// Seperate infoArea and gameStage, increment score by 1 for each mouse pulverized
public class CatchOneMouseWithScore extends Application{
    public void start(Stage pS){

        // Create mouse obj and randomCoord obj
        Mouse mouse = new Mouse(Color.RED);
        RandomCoordinateGenerator randomMove = new RandomCoordinateGenerator();

        // Create score Panel
        InfoArea infoArea = new InfoArea();

        // Create random move and score handler
        RandomMouseMoveHandler randomMouseMoveHandler = new RandomMouseMoveHandler(randomMove, mouse);
        ScoreHdler scoreHdler = new ScoreHdler(mouse, infoArea);

        // Set mouse to a random initial position
        mouse.getGroup().setTranslateX(randomMove.getxMove());
        mouse.getGroup().setTranslateY(randomMove.getyMove());


        // Hook up mouse object to both event handler
        mouse.getGroup().addEventHandler(MouseEvent.MOUSE_CLICKED, randomMouseMoveHandler);
        mouse.getGroup().addEventHandler(MouseEvent.MOUSE_CLICKED, scoreHdler);

        // Create game view (The container that contain gameStage and infoArea)
        GameView gameView = new GameView();

        // Create game Stage and add mouse object
        GameStage gameStage = new GameStage();
        gameStage.getMouseArea().getChildren().add(mouse.getGroup());

        // Add infoArea and gameStage to gameView
        gameView.getGameArea().add(gameStage.getMouseArea(), 0,0);
        gameView.getGameArea().add(infoArea.getInfoArea(), 1, 0);


        // Scene and start the Stage
        Scene scene = new Scene(gameView.getGameArea());
        pS.setScene(scene);
        pS.show();
    }

}
