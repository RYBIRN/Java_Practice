package monopoly;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXMLDocumentController {

   
    private int numPlayers;
    private int playerPosition;
    private int turnsInCanada = 0;
    private int playerOneCanCount = 0;
    private int playerTwoCanCount = 0;
    private int playerThreeCanCount = 0;
    private int playerFourCanCount = 0;
    
    private boolean plyOneinCanada = false;
    private boolean plyTwoinCanada = false;
    private boolean plyThreeinCanada = false;
    private boolean plyFourinCanada = false;
    
    private boolean plyOneMove, plyTwoMove, plyThreeMove,plyFourMove;
   
    MoveGamePiece newMove = new MoveGamePiece();
    PropertiesPositions properties = new PropertiesPositions();
    PropertyInfo propertyInfo = new PropertyInfo();

    public void setNumPlayers(int numPlayer) {
        numPlayers = numPlayer;
        System.out.println(numPlayers);
        plyOneMove = true;
    }

        @FXML
    private Label PropertyGroup;
  

        @FXML
    private GridPane Grid;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

   
    @FXML
    private Label needNewTiresText;
    
        @FXML
    private Label PlayerOneLabel;
    
        @FXML
    private Label PlayerTwoLabel;

    @FXML
    private Label PlayerFourLabel;

    @FXML
    private Label PlayerThreeLabel;

    @FXML
    private Button Quit;

    @FXML
    private Button Reset;

    @FXML
    private Button RollDiceButton;
    
       @FXML
    private Button EndTurnButton;

    @FXML
    private ImageView PlayerOne;

    @FXML
    private ImageView PlayerTwo;

    @FXML
    private ImageView PlayerThree;

    @FXML
    private ImageView PlayerFour;

    @FXML
    private Button BuyPropertyButton;

    @FXML
    private Label Property;

    @FXML
    private Label PropertyPrice;

    @FXML
    private Label OwnedBy;

    @FXML
    private Label PlayerOneMoney;

    @FXML
    private Label PlayerTwoMoney;

    @FXML
    private Label PLayerThreeMoney;

    @FXML
    private Label PlayerFourMoney;

    @FXML
    private Label BossCaughtYouText;

    @FXML
    private Label BossPayText;

    @FXML
    private Label CatCollectText;

    @FXML
    private ImageView UglyDogPic;

    @FXML
    private ImageView BossFoundPic;

    @FXML
    private ImageView CatPic;

    @FXML
    private ImageView newTiresPic;

    @FXML
    private Label UglyDogText;

    @FXML
    private Label CatSnuckInText;

    @FXML
    private Label TiresPayText;

    @FXML
    private Label UglyDogCollectText;
    


    @FXML
    void BuyProperty(ActionEvent event) {

    }

    @FXML
    void QuitGame(ActionEvent event){
                  // get a handle to the stage
    Stage stage = (Stage) Quit.getScene().getWindow();
    // do what you have to do
   
    stage.close();
  
    }

    @FXML
    void ResetGame(ActionEvent event) {

    }

    
    
    @FXML
    void RollDice(ActionEvent event) {
        System.out.println("Rolling Dice");
        Integer[] propertyPosition; 
     newMove.rollDice();
       newMove.movePlayer();
       
       
       if(plyOneMove){
           
           properties.setPlayerPosition(newMove.getPlayerOnePosition());
           playerPosition = newMove.getPlayerOnePosition();
           properties.findPropPosition();
           propertyPosition =  properties.getPropertyPosition();
           propertyInfo.setPlayerPosition(newMove.getPlayerOnePosition());
           propertyInfo.updatePropertLabels();
           updateLabels();
           setBuyButtonVisible();
           updateCommChesAndChan();
      GridPane.setColumnIndex(PlayerOne, propertyPosition[0]);
      GridPane.setRowIndex(PlayerOne, propertyPosition[1]);
    //GridPane.setConstraints(child, x, y);
       }
       if (plyTwoMove){
             properties.setPlayerPosition(newMove.getPlayerTwoPosition());
               playerPosition = newMove.getPlayerTwoPosition();
              properties.findPropPosition();
              propertyPosition =  properties.getPropertyPosition();
               propertyInfo.setPlayerPosition(newMove.getPlayerTwoPosition());
                 propertyInfo.updatePropertLabels();
                 updateLabels();
                 setBuyButtonVisible();
                  updateCommChesAndChan();
      GridPane.setColumnIndex(PlayerTwo, propertyPosition[0]);
      GridPane.setRowIndex(PlayerTwo, propertyPosition[1]);
       }
       if(plyThreeMove){
             properties.setPlayerPosition(newMove.getPlayerThreePosition());
               playerPosition = newMove.getPlayerThreePosition();
              properties.findPropPosition();
              propertyPosition =  properties.getPropertyPosition();
               propertyInfo.setPlayerPosition(newMove.getPlayerThreePosition());
                 propertyInfo.updatePropertLabels();
                 updateLabels();
                 setBuyButtonVisible();
                  updateCommChesAndChan();
      GridPane.setColumnIndex(PlayerThree, propertyPosition[0]);
      GridPane.setRowIndex(PlayerThree, propertyPosition[1]);
       }
       if(plyFourMove){
             properties.setPlayerPosition(newMove.getPlayerFourPosition());
               playerPosition = newMove.getPlayerFourPosition();
              properties.findPropPosition();
              propertyPosition =  properties.getPropertyPosition();
               propertyInfo.setPlayerPosition(newMove.getPlayerFourPosition());
                 propertyInfo.updatePropertLabels();
                 updateLabels();
                 setBuyButtonVisible();
                  updateCommChesAndChan();
      GridPane.setColumnIndex(PlayerFour, propertyPosition[0]);
      GridPane.setRowIndex(PlayerFour, propertyPosition[1]);
       }
   
        
        EndTurnButton.setVisible(true);
        RollDiceButton.setVisible(false);
    }
    
      @FXML
    void EndTurn(ActionEvent event) {
        RollDiceButton.setVisible(true);
         EndTurnButton.setVisible(false);
        goToCanada();
        if(numPlayers == 2){
        if (plyOneMove){
            plyOneMove = false;
            plyTwoMove = true;
            PlayerTwoLabel.setTextFill(Color.LAWNGREEN);
            PlayerOneLabel.setTextFill(Color.BLACK);
            if(plyTwoinCanada){
                RollDiceButton.setText("End Turn");
            }
            else
                RollDiceButton.setText("Roll Dice");
        }
        else{
            plyOneMove = true;
            plyTwoMove = false;
                PlayerOneLabel.setTextFill(Color.LAWNGREEN);
                   PlayerTwoLabel.setTextFill(Color.BLACK);
            if(plyOneinCanada){
                RollDiceButton.setText("End Turn");
            }
               else
                RollDiceButton.setText("Roll Dice");
        }
        } else if (numPlayers == 3){
              if (plyOneMove){
            plyOneMove = false;
            plyTwoMove = true;
            plyThreeMove = false;
            
            
        }
              else if (plyTwoMove){
            plyOneMove = false;
            plyTwoMove = false;
            plyThreeMove = true;
              }
            else{
            plyOneMove = true;
            plyTwoMove = false;
            plyThreeMove = false; 
                    }
        } else {
                     if (plyOneMove){
            plyOneMove = false;
            plyTwoMove = true;
            plyThreeMove = false;
            plyFourMove = false;
            
        }
              else if (plyTwoMove){
            plyOneMove = false;
            plyTwoMove = false;
            plyThreeMove = true;
            plyFourMove = false;
              }
              else if (plyThreeMove){
            plyOneMove = false;
            plyTwoMove = false;
            plyThreeMove = false; 
            plyFourMove = true;
                    }
              else {
                       plyOneMove = true;
            plyTwoMove = false;
            plyThreeMove = false; 
            plyFourMove = false;
              }
        }
        
        newMove.setPlyOneMove(plyOneMove);
        newMove.setPlyTwoMove(plyTwoMove);
        newMove.setPlyThreeMove(plyThreeMove);
        newMove.setPlyFourMove(plyFourMove);     
    }
    


    @FXML
    void initialize() {
        assert needNewTiresText != null : "fx:id=\"needNewTiresText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerFourLabel != null : "fx:id=\"PlayerFourLabel\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerThreeLabel != null : "fx:id=\"PlayerThreeLabel\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert Quit != null : "fx:id=\"Quit\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert Reset != null : "fx:id=\"Reset\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert RollDiceButton != null : "fx:id=\"RollDiceButton\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerOne != null : "fx:id=\"PlayerOne\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerTwo != null : "fx:id=\"PlayerTwo\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerThree != null : "fx:id=\"PlayerThree\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerFour != null : "fx:id=\"PlayerFour\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert BuyPropertyButton != null : "fx:id=\"BuyPropertyButton\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert Property != null : "fx:id=\"Property\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PropertyPrice != null : "fx:id=\"PropertyPrice\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert OwnedBy != null : "fx:id=\"OwnedBy\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerOneMoney != null : "fx:id=\"PlayerOneMoney\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerTwoMoney != null : "fx:id=\"PlayerTwoMoney\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PLayerThreeMoney != null : "fx:id=\"PLayerThreeMoney\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert PlayerFourMoney != null : "fx:id=\"PlayerFourMoney\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert BossCaughtYouText != null : "fx:id=\"BossCaughtYouText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert BossPayText != null : "fx:id=\"BossPayText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert CatCollectText != null : "fx:id=\"CatCollectText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert UglyDogPic != null : "fx:id=\"UglyDogPic\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert BossFoundPic != null : "fx:id=\"BossFoundPic\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert CatPic != null : "fx:id=\"CatPic\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert newTiresPic != null : "fx:id=\"newTiresPic\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert UglyDogText != null : "fx:id=\"UglyDogText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert CatSnuckInText != null : "fx:id=\"CatSnuckInText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert TiresPayText != null : "fx:id=\"TiresPayText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        assert UglyDogCollectText != null : "fx:id=\"UglyDogCollectText\" was not injected: check your FXML file 'FXMLGameBoard.fxml'.";
        
        
         
        
    
    }
    

public void goToCanada(){
    if (newMove.getPlayerOnePosition() == 30 || plyOneinCanada){
        plyOneinCanada = true;
        if(plyOneMove)
        playerOneCanCount++;
        if(playerOneCanCount == 4){
              plyOneinCanada = false;
              playerOneCanCount = 0;
             
        }
    }
    else 
        plyOneinCanada = false;
    if (newMove.getPlayerTwoPosition() == 30 || plyTwoinCanada){
        plyTwoinCanada = true;
         if(plyTwoMove)
        playerTwoCanCount++;
        if(playerTwoCanCount == 4){
            plyTwoinCanada = false;
            playerTwoCanCount = 0;
        }
    }
    else 
        plyTwoinCanada = false;
    if (newMove.getPlayerThreePosition() == 30 || plyThreeinCanada){
        plyThreeinCanada = true;
         if(plyThreeMove)
          playerThreeCanCount++;
          
        if(playerThreeCanCount == 4){
            plyThreeinCanada = false;
            playerThreeCanCount = 0;
    }
    }
    else
        plyThreeinCanada = false;
    if (newMove.getPlayerFourPosition() == 30 || plyFourinCanada){
        plyFourinCanada = true;
         if(plyFourMove)
          playerFourCanCount++;
        if(playerFourCanCount == 4){
            plyFourinCanada = false;
            playerFourCanCount = 0;
    }
    }
    else
        plyFourinCanada = false;
    
    newMove.setPlyOneinCanada(plyOneinCanada);
     newMove.setPlyTwoinCanada(plyTwoinCanada);
      newMove.setPlyThreeinCanada(plyThreeinCanada);
     newMove.setPlyFourinCanada(plyFourinCanada);
    
    
}
    
    
    public void setVisible(){
         if (numPlayers == 2){
            PlayerThree.setVisible(false);
            PlayerFour.setVisible(false);
            PLayerThreeMoney.setVisible(false);
            PlayerFourMoney.setVisible(false);
            PlayerThreeLabel.setVisible(false);
            PlayerFourLabel.setVisible(false);
        }
        else if (numPlayers == 3){
            PlayerFour.setVisible(false);
             PlayerFourMoney.setVisible(false);
             PlayerFourLabel.setVisible(false);
        }
        
         
}
    
    public void setBuyButtonVisible(){
        //System.out.println(playerPosition);
        if(playerPosition == 0 || playerPosition == 2 || playerPosition == 17 ||
                playerPosition == 33 || playerPosition == 7 || playerPosition == 22 ||
                playerPosition ==  36 || playerPosition == 4 || playerPosition == 10 ||
                playerPosition == 20 || playerPosition == 30 || playerPosition == 38){
            BuyPropertyButton.setVisible(false);
        }
        else
            BuyPropertyButton.setVisible(true);
    }
    
    
    public void updatePlayerCash(){
        
    }
    
    public void updateCommChesAndChan(){
         CatSnuckInText.setVisible(false);
                CatPic.setVisible(false);
                 TiresPayText.setVisible(false);
                  UglyDogText.setVisible(false);
                  needNewTiresText.setVisible(false);
                newTiresPic.setVisible(false);
                        UglyDogPic.setVisible(false);
                         UglyDogCollectText.setVisible(false);
                           BossCaughtYouText.setVisible(false);
                        BossFoundPic.setVisible(false);
                        
        if(playerPosition == 2 || playerPosition == 17 ||
                playerPosition == 33){
            newMove.pickRandomCard();
            if (newMove.getDiceRoll() == 0) {
                CatSnuckInText.setVisible(true);
                CatPic.setVisible(true);
                TiresPayText.setText("Collect $100");
                TiresPayText.setVisible(true);
            }
            else
            {
                needNewTiresText.setVisible(true);
                newTiresPic.setVisible(true);
                TiresPayText.setText("Pay $100");
                TiresPayText.setVisible(true);
            }
        }
            else if(playerPosition == 7 || playerPosition == 22 || playerPosition ==  36){
                newMove.pickRandomCard();
                    if (newMove.getDiceRoll() == 0){
                        UglyDogText.setVisible(true);
                        UglyDogPic.setVisible(true);
                        UglyDogCollectText.setText("Collect $200");
                        UglyDogCollectText.setVisible(true);
                    }
                    else{
                        BossCaughtYouText.setVisible(true);
                        BossFoundPic.setVisible(true);
                         UglyDogCollectText.setText("Pay $200");
                        UglyDogCollectText.setVisible(true);
                    }
                
            }   
    }
    
    public void updateLabels(){
        Property.setText(propertyInfo.getPropertyName());
        PropertyPrice.setText(propertyInfo.getPropertyLabel());
        PropertyGroup.setText(propertyInfo.getPropertyGroup());
        
    }
    
}







