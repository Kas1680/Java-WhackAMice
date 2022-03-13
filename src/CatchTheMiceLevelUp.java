import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


// Added level up, max level = 5
public class CatchTheMiceLevelUp extends Application{
    public void start(Stage pS){

    // Create logic component
    CatchTheMiceLevelUpGameLogic catchTheMiceLevelUpGameLogic =
                new CatchTheMiceLevelUpGameLogic();

    // Invoke spawnMoreMice method
    catchTheMiceLevelUpGameLogic.spawnMoreMice();

    // Add infoArea and gameStage to gameView
    GameView gameView = new GameView();
    gameView.getGameArea().add(catchTheMiceLevelUpGameLogic.getGameStage().getMouseArea(), 0, 0);
    gameView.getGameArea().add(catchTheMiceLevelUpGameLogic.getInfoArea().getInfoArea(), 1, 0);

    // Invoke startGame method with level default at 1, fade = false
    catchTheMiceLevelUpGameLogic.startGame(1, false);


    Scene scene = new Scene(gameView.getGameArea());
    pS.setScene(scene);
    pS.show();


    }


}
