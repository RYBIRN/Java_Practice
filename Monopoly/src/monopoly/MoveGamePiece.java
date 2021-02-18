/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.security.SecureRandom;

/**
 *
 * @author RyanB
 */
public class MoveGamePiece {
    
     private final SecureRandom Dice = new SecureRandom();
     
     private int diceRoll = 0;
     
     private int playerOnePosition = 1;
     private int playerTwoPosition = 1;
     private int playerThreePosition = 1;
     private int playerFourPosition = 1;
     private boolean PlyOneinCanada = false;
     private boolean PlyTwoinCanada = false;
     private boolean PlyThreeinCanada = false;
     private boolean PlyFourinCanada = false;
     
     private boolean plyOneMove = true;
             private boolean plyTwoMove, plyThreeMove, plyFourMove;
   
     public void pickRandomCard(){
         diceRoll = Dice.nextInt(2);
         System.out.println("random card is: " +diceRoll);
     }
     
     public void rollDice(){
         diceRoll = 2;
    diceRoll += Dice.nextInt(10);
         System.out.println(diceRoll);
}
     
     public void movePlayer(){
         if (plyOneMove) {
             if (PlyOneinCanada)
                 playerOnePosition = 10;
             else
             playerOnePosition += diceRoll;
             if (playerOnePosition >= 40){
                 playerOnePosition = playerOnePosition%40;
             }
             System.out.println("PlyOnePos: " +playerOnePosition);
         }
         else if (plyTwoMove){
               if (PlyTwoinCanada)
                 playerTwoPosition = 10;
             else
             playerTwoPosition += diceRoll;
              if (playerTwoPosition >= 40){
                 playerTwoPosition = playerTwoPosition%40;
             }
             System.out.println("PlyTwoPos: " +playerTwoPosition);
         }
         else if(plyThreeMove){
               if (PlyThreeinCanada)
                 playerThreePosition = 10;
             else
             playerThreePosition += diceRoll;
              if (playerThreePosition >= 40){
                 playerThreePosition = playerThreePosition%40;
             }
             System.out.println("PlyThreePos: " +playerThreePosition);
         }
         else if(plyFourMove){
               if (PlyFourinCanada)
                 playerFourPosition = 10;
             else
             playerFourPosition += diceRoll;
              if (playerFourPosition >= 40){
                 playerFourPosition = playerFourPosition%40;
             }
             System.out.println("PlyFourPos: " +playerFourPosition);
         }
         
         
     }

    public int getDiceRoll() {
        return diceRoll;
    }
     

    public int getPlayerOnePosition() {
        return playerOnePosition;
    }

    public int getPlayerTwoPosition() {
        return playerTwoPosition;
    }

    public int getPlayerThreePosition() {
        return playerThreePosition;
    }

    public int getPlayerFourPosition() {
        return playerFourPosition;
    }
     
     
     
    public void setPlyOneMove(boolean plyOne) {
        plyOneMove = plyOne;
    }

    public void setPlyTwoMove(boolean plyTwo) {
       plyTwoMove = plyTwo;
    }

    public void setPlyThreeMove(boolean plyThree) {
        plyThreeMove = plyThree;
    }

    public void setPlyFourMove(boolean plyFour) {
        plyFourMove = plyFour;
    }

    public void setPlyOneinCanada(boolean PlyOneinCanada) {
        this.PlyOneinCanada = PlyOneinCanada;
    }

    public void setPlyTwoinCanada(boolean PlyTwoinCanada) {
        this.PlyTwoinCanada = PlyTwoinCanada;
    }

    public void setPlyThreeinCanada(boolean PlyThreeinCanada) {
        this.PlyThreeinCanada = PlyThreeinCanada;
    }

    public void setPlyFourinCanada(boolean PlyFourinCanada) {
        this.PlyFourinCanada = PlyFourinCanada;
    }
    
    

    
    
     
}
