import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class InfoArea {
    private VBox infoArea;
    private Label scoreText;
    private Label levelText;


    /**
     * Add score label and add it to a VBox
     * The right panel of gameView
     */
    public InfoArea(){
        Label scoreText = new Label();
        scoreText.setText("Score: ");
        scoreText.setFont(Font.font(24));


        VBox infoArea = new VBox();
        infoArea.setSpacing(20);
        infoArea.setPadding(new Insets(20));
        infoArea.setStyle("-fx-background-color: #3da55a");
        infoArea.setPrefSize(200, 600);



        this.scoreText = scoreText;
        this.infoArea = infoArea;
        this.levelText = new Label();
        this.levelText.setFont(Font.font(16));
        this.infoArea.getChildren().addAll(this.levelText, this.scoreText);
    }

    public VBox getInfoArea() {
        return infoArea;
    }

    public Label getScore() {
        return scoreText;
    }

    public Label getLevelText() {
        return levelText;
    }
}
