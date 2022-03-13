import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MouseEventHandler implements EventHandler<MouseEvent> {
    private CatchTheMiceLevelUpGameLogic catchTheMiceLevelUpGameLogic;
    private Mouse mouse;


    public MouseEventHandler (CatchTheMiceLevelUpGameLogic catchTheMiceLevelUpGameLogic, Mouse mouse) {
        this.catchTheMiceLevelUpGameLogic = catchTheMiceLevelUpGameLogic;
        this.mouse = mouse;
    }

    // if a mouse is being clicked, invoke mouseClick method in logic
    public void handle(MouseEvent event){
        if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            this.catchTheMiceLevelUpGameLogic.mouseClicked(this.mouse);
        }
    }

}
