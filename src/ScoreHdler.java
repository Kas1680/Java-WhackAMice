import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ScoreHdler implements EventHandler<MouseEvent> {
    private Mouse mouse;
    private InfoArea infoArea;
    private int scoreCount;

    public ScoreHdler(Mouse mouse, InfoArea infoArea){
        this.mouse = mouse;
        this.infoArea = infoArea;
        this.scoreCount = 0;
    }

    // Everytime a mouse is clicked, update the score and score label
    public void handle(MouseEvent event){
        if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            this.scoreCount++;
            String s = String.format("Score: %d", this.scoreCount);
            this.infoArea.getScore().setText(s);
        }
    }
}
