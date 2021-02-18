/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author RyanB
 */
public class PropertyInfo {
   
    private int playerPosition;
 
    private String propertyName;
    private String propertyLabel;
    private int propertyPrice;
    private String propertyGroup;
    private boolean inCanada = false;
    
    public void updatePropertLabels(){
          if (playerPosition == 0){
            propertyName = "AMC Paycheck";
            propertyLabel = "Collect $200";
            propertyGroup = "";
         
        }
        if (playerPosition == 1){
                propertyName = "Cocoa Beach";
            propertyLabel = "Price: $60";
            propertyGroup = "(Beach trips)";
            propertyPrice = 60;
        }
        if (playerPosition == 2 || playerPosition == 17 || playerPosition == 33){
                      propertyName = "Community Chest";
            propertyLabel = "Draw a Community Chest card";
            propertyGroup = "";
        }
        if (playerPosition == 3){
                 propertyName = "Clearwater Beach";
            propertyLabel = "Price: $60";
            propertyGroup = "(Beach trips)";
            propertyPrice = 60;
        }
        if (playerPosition == 4){
              propertyName = "Pay Credit Card Bills";
            propertyLabel = "Pay 10% or $200";
           propertyGroup = "";
        }
        if (playerPosition == 5){
              propertyName = "Epcot";
            propertyLabel = "Price: $200";
            propertyGroup = "(Disney)";
            propertyPrice = 200;
        }
        if (playerPosition == 6){
              propertyName = "Blue Ridge GA";
            propertyLabel = "Price: $100";
              propertyGroup = "(South East Trips)";
            propertyPrice = 100;
        }
        if (playerPosition == 7 || playerPosition == 22 || playerPosition ==  36){
              propertyName = "Chance";
            propertyLabel = "Draw a Chance card";
             propertyGroup = "";
        }
        if (playerPosition == 8){
              propertyName = "Blue Ridge TN";
            propertyLabel = "Price: $100";
             propertyGroup = "(South East Trips)";
            propertyPrice = 100;
        }
        if (playerPosition == 9){
              propertyName = "Asheville NC";
            propertyLabel = "Price: $120";
             propertyGroup = "(South East Trips)";
            propertyPrice = 120;
        }
        if (playerPosition == 10){
              propertyName = "In Canada";
               propertyGroup = "";
              if (inCanada) {
                  propertyLabel = "pay $200, or wait three turns to leave.";
            }
          else
            propertyLabel = "Just visiting";
          
        }
        if (playerPosition == 11){
              propertyName = "Carnival Cruise";
            propertyLabel = "Price: $140";
             propertyGroup = "(Bahammas Trips)";
            propertyPrice = 140;
        }
        if (playerPosition == 12){
              propertyName = "Buy new Guitar";
            propertyLabel = "Price: $150";
            propertyGroup = "(New Music Gear)";
            propertyPrice = 150;
        }
        if (playerPosition == 13){
              propertyName = "Atlantis Resort";
            propertyLabel = "Price: $140";
            propertyGroup = "(Bahammas Trips)";
            propertyPrice = 140;
        }
        if (playerPosition == 14){
             propertyName = "Disney Cruise";
            propertyLabel = "Price: $160";
            propertyGroup = "(Bahammas Trips)";
            propertyPrice = 160;
            
        }
        if (playerPosition == 15){
             propertyName = "Animal Kingdom";
            propertyLabel = "Price: $200";
            propertyGroup = "(Disney)";
            propertyPrice = 200;
        }
        if (playerPosition == 16){
             propertyName = "New Orleans";
            propertyLabel = "Price: $180";
            propertyGroup = "(South City Trips)";
            propertyPrice = 180;
        }
        if (playerPosition == 18){
               propertyName = "Nashville TN";
            propertyLabel = "Price: $180";
            propertyGroup = "(South City Trips)";
            propertyPrice = 180;
        }
        if (playerPosition == 19){
               propertyName = "Atlanta GA";
            propertyLabel = "Price: $200";
            propertyGroup = "(South City Trips)";
            propertyPrice = 200;
        }
        if (playerPosition == 20){
               propertyName = "Found Parking";
            propertyLabel = "Collect money from center board, if no money on board get $200";
          propertyGroup = "";
        }
        if (playerPosition == 21){
               propertyName = "New York City";
            propertyLabel = "Price: $220";
            propertyGroup = "(North East Trips)";
            propertyPrice = 220;
        }
        if (playerPosition == 23){
              propertyName = "Vermont";
            propertyLabel = "Price: $220";
            propertyGroup = "(North East Trips)";
            propertyPrice = 220;
        }
        if (playerPosition == 24){
              propertyName = "New Hampshire";
            propertyLabel = "Price: $240";
            propertyGroup = "(North East Trips)";
            propertyPrice = 240;
        }
        if (playerPosition == 25){
              propertyName = "Hollywood Studios";
            propertyLabel = "Price: $200";
            propertyGroup = "(Disney)";
            propertyPrice = 200;
            
        }
        if (playerPosition == 26){
              propertyName = "Colorado";
            propertyLabel = "Price: $260";
            propertyGroup = "(West Trips)";
            propertyPrice = 260;
            
        }
        if (playerPosition == 27){
              propertyName = "California";
            propertyLabel = "Price: $260";
            propertyGroup = "(West Trips)";
            propertyPrice = 220;
        }
        if (playerPosition == 28){
              propertyName = "Buy new Equipment";
            propertyLabel = "Price: $150";
            propertyGroup = "(New Music Gear)";
            propertyPrice = 150;
        }
        if (playerPosition == 29){
               propertyName = "Oregon";
            propertyLabel = "Price: $280";
            propertyGroup = "(West Trips)";
            propertyPrice = 220;
        }
        if (playerPosition == 30){
               propertyName = "Go to Canada";
            propertyLabel = "Pay $200 or wait three turns to leave.";
             propertyGroup = "";
        }
        if (playerPosition == 31){
               propertyName = "England";
            propertyLabel = "Price: $300";
            propertyGroup = "(Europe)";
            propertyPrice = 300;
        }
        if (playerPosition == 32){
                propertyName = "France";
            propertyLabel = "Price: $300";
            propertyGroup = "(Europe)";
            propertyPrice = 300;
        }
        if (playerPosition == 34){
                propertyName = "Italy";
            propertyLabel = "Price: $320";
            propertyGroup = "(Europe)";
            propertyPrice = 300;
        }
        if (playerPosition == 35){
             propertyName = "Magic Kingdom";
            propertyLabel = "Price: $200";
            propertyGroup = "(Disney)";
            propertyPrice = 200;
        }
        if (playerPosition == 37){
             propertyName = "Germany";
            propertyLabel = "Price: $350";
            propertyGroup = "(Europe - Mountains)";
            propertyPrice = 350;
        }
        if (playerPosition == 38){
                propertyName = "Make Car Payment";
            propertyLabel = "Pay: $100";
           propertyGroup = "";
        }
        if (playerPosition == 39){
                propertyName = "Austria";
            propertyLabel = "Price: $400";
            propertyGroup = "(Europe - Mountains)";
            propertyPrice = 400;
        }
    }

    public void setInCanada(boolean inCan) {
        inCanada = inCan;
    }
    
    
    

    public void setPlayerPosition(int playerPos) {
        playerPosition = playerPos;
    }

    public String getPropertyLabel() {
        return propertyLabel;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyGroup() {
        return propertyGroup;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }
    
    

 
    
    
    
    
            
}
