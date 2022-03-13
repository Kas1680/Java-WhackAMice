
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class CatchTheMiceFinalGameLogic extends CatchTheMiceLevelUpGameLogic{
    private TextField levelInput;
    private Label errorMsg;
    private HBox inputArea;
    private Button start;


    // Construct the gameStage with additional content including start button, level input,
    // and error message. Add them to a HBox and add HBox to infoArea
    // CatchTheMiceLevelUpLogic will get the rest of the components
    public CatchTheMiceFinalGameLogic(){

        this.start = new Button("Start");
        this.start.setFont(Font.font(16));
        this.levelInput = new TextField();
        this.levelInput.setPromptText("Start Level");
        // set mouse cursor not default at textfield so prompt text would show
        this.levelInput.setFocusTraversable(false);
        this.levelInput.setMaxWidth(80);
        this.errorMsg = new Label();
        this.inputArea = new HBox(10, this.levelInput, this.errorMsg);

        super.getInfoArea().getInfoArea().getChildren().add(0, this.inputArea);
        super.getInfoArea().getInfoArea().getChildren().add(1, this.start);
    }


    public TextField getLevelInput() {
        return levelInput;
    }

    public Label getErrorMsg() {
        return errorMsg;
    }

    public HBox getInputArea() {
        return inputArea;
    }

    public Button getStart() {
        return start;
    }


}
