/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author RyanB
 */
public class MonopolyDemo {
    
    private int numberOfPlayers;
    private boolean playerOneTurn, playerTwoTurn, playerThreeTurn, playerFourTurn;

    public MonopolyDemo(int Players) {
        numberOfPlayers = Players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    
    

    
    public void newGame() throws IOException{
        System.out.println(numberOfPlayers);
        
     
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        FXMLDocumentController controller=fxmlLoader.<FXMLDocumentController>getController();
        controller.setNumPlayers(numberOfPlayers);
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        controller.setVisible();
       
    
}
    
}
