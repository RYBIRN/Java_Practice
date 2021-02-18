package monopoly;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class WelcomScreenController {
    
      ObservableList<Integer> NumberPlayersList = FXCollections.observableArrayList(2,3,4);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Integer> NumberofPlayers;

    @FXML
    private Button StartGameButton;

    @FXML
    void StartGameButton(ActionEvent event) throws IOException {
        int numberofPlyrs = NumberofPlayers.getValue();
        
        MonopolyDemo newMonopolyDemo = new MonopolyDemo(numberofPlyrs);
        newMonopolyDemo.newGame();
       
     
            // get a handle to the stage
    Stage stage = (Stage) StartGameButton.getScene().getWindow();
    // do what you have to do
   
    stage.close();
    
  
    
   
    }

    @FXML
    void initialize() {
        assert NumberofPlayers != null : "fx:id=\"NumberofPlayers\" was not injected: check your FXML file 'FXMLWelcomScreen.fxml'.";
        assert StartGameButton != null : "fx:id=\"StartGameButton\" was not injected: check your FXML file 'FXMLWelcomScreen.fxml'.";
   NumberofPlayers.setItems(NumberPlayersList);
        NumberofPlayers.setValue(2);

    }
}
