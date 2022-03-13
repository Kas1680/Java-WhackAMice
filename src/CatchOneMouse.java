import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


// Just a simple brainless game for de-stressing
public class CatchOneMouse extends Application {
    public void start(Stage pS){

        // Create a mouse object, give it a random coord, hookup random move handler
        Mouse mouse = new Mouse(Color.RED);
        RandomCoordinateGenerator randomMove = new RandomCoordinateGenerator();
        RandomMouseMoveHandler randomMouseMoveHandler = new RandomMouseMoveHandler(randomMove, mouse);


        mouse.getGroup().setTranslateX(randomMove.getxMove());
        mouse.getGroup().setTranslateY(randomMove.getyMove());
        mouse.getGroup().addEventHandler(MouseEvent.MOUSE_CLICKED, randomMouseMoveHandler);

        // Set the pane, pane size, pane background color
        Pane mouseArea = new Pane();
        mouseArea.setPrefSize(800, 600);
        mouseArea.setStyle("-fx-background-color: white");


        // add the mouse to the pane
        mouseArea.getChildren().add(mouse.getGroup());


        // Scene and start the Stage
        Scene scene = new Scene(mouseArea);
        pS.setScene(scene);
        pS.show();
    }


}
