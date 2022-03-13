import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NinjaMiceGame extends Application {
    public void start(Stage pS) {

        // Create final logic, set ninja to true and fade to false
        CatchTheMiceFinalGameLogic catchTheMiceFinalGameLogic = new CatchTheMiceFinalGameLogic();
        catchTheMiceFinalGameLogic.setNinja(true);



        StartButtonHandler startButtonHandler = new StartButtonHandler(catchTheMiceFinalGameLogic);
        catchTheMiceFinalGameLogic.getStart().
                addEventHandler(ActionEvent.ANY, startButtonHandler);


        GameView gameView = new GameView();
        gameView.getGameArea().add(catchTheMiceFinalGameLogic.getGameStage().getMouseArea(), 0, 0);
        gameView.getGameArea().add(catchTheMiceFinalGameLogic.getInfoArea().getInfoArea(),1,0);
        Scene scene = new Scene(gameView.getGameArea());
        pS.setScene(scene);
        pS.show();




    }
}