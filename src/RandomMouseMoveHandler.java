import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RandomMouseMoveHandler implements EventHandler<MouseEvent> {
    private RandomCoordinateGenerator randomMove;
    private Mouse mouse;

    public RandomMouseMoveHandler(RandomCoordinateGenerator randomMove, Mouse mouse){
        this.randomMove = randomMove;
        this.mouse = mouse;
    }

    // Use a random generator to set the mouse X and Y position after being clicked
    public void handle(MouseEvent event){
        if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            this.randomMove.setMove();
            int x = randomMove.getxMove();
            int y = randomMove.getyMove();
            this.mouse.move(x, y);
        }

    }


}
