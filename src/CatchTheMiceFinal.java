import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class CatchTheMiceFinal extends Application{
    public void start(Stage pS){


        // Create logic
        CatchTheMiceFinalGameLogic catchTheMiceFinalGameLogic =
                new CatchTheMiceFinalGameLogic();


        // Create startButtonhandler and hook it up to button
        StartButtonHandler startButtonHandler = new StartButtonHandler(catchTheMiceFinalGameLogic);
        catchTheMiceFinalGameLogic.getStart().
                addEventHandler(ActionEvent.ANY, startButtonHandler);


        GameView gameView = new GameView();
        gameView.getGameArea().add(catchTheMiceFinalGameLogic.getGameStage().getMouseArea(), 0, 0);
        gameView.getGameArea().add(catchTheMiceFinalGameLogic.getInfoArea().getInfoArea(), 1, 0);

        Scene scene = new Scene(gameView.getGameArea());
        pS.setScene(scene);
        pS.show();





    }
}
