import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartButtonHandler implements EventHandler<ActionEvent> {
    private CatchTheMiceFinalGameLogic catchTheMiceFinalGameLogic;

    public StartButtonHandler(CatchTheMiceFinalGameLogic catchTheMiceFinalGameLogic){
        this.catchTheMiceFinalGameLogic = catchTheMiceFinalGameLogic;
    }


    public void handle(ActionEvent event){

        // error handling for non-integer input
          try{
              Integer level = Integer.parseInt
                  (catchTheMiceFinalGameLogic.getLevelInput().getText());


              // if input is between 1-5, we start the game
              if(level >= 1 && level <= 5){
                  // start the game with ninja mice
                  if(catchTheMiceFinalGameLogic.getNinja()){
                      catchTheMiceFinalGameLogic.getErrorMsg().setText("");
                      catchTheMiceFinalGameLogic.startGame(level, false);
                  }else{

                      // start with regular mice, fade = true
                      catchTheMiceFinalGameLogic.getErrorMsg().setText("");
                      catchTheMiceFinalGameLogic.startGame(level, true);
                  }
              }
              else{
                  throw new InvalidLevelException();
              }
          }
          catch(NumberFormatException ex){
              catchTheMiceFinalGameLogic.getErrorMsg().setText("Invalid Input");
          }

        catch(InvalidLevelException ex) {
            catchTheMiceFinalGameLogic.getErrorMsg().setText("Invalid Level");
        }
    }
}
