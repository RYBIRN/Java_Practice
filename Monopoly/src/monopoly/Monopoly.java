/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author RyanB
 */
public class Monopoly extends Application {
  
    
    @Override
    public void start(Stage stage) throws Exception {
    
        Parent root = FXMLLoader.load(getClass().getResource("FXMLWelcomScreen.fxml"));
        
        
        Scene sceneTwo = new Scene(root);
        
        stage.setScene(sceneTwo);
        stage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
