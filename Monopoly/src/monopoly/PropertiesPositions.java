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
public class PropertiesPositions {
 
   
   private int playerPosition;
   //private boolean inCanada = false;
   
private Integer[] propertyPosition = new Integer[2];
   
  
    public PropertiesPositions() {
      
    }
    
    public void findPropPosition(){
        propertyPosition[0] = 10;
        propertyPosition[1] = 10;
      
        //used to test for problems in moving piece
       // playerPosition = 30;
        
//       if(inCanada == true)
//            {
//                 propertyPosition[0] = 0;
//                   propertyPosition[1] = 10;
//            }
        
       if (playerPosition < 10){
           propertyPosition[0] = 10 - playerPosition;
       propertyPosition[1] = 10;
       }
       
       if (playerPosition >= 10 && playerPosition < 20){
           propertyPosition[0] = 0;
               propertyPosition[1] = 10 - (playerPosition % 10);
       }
       
               if (playerPosition >= 20 && playerPosition < 31){
                   propertyPosition[0] = playerPosition % 20;
                           propertyPosition[1] = 0;
               }
               
               if(playerPosition >= 31){
                   propertyPosition[0] = 10;
                   propertyPosition[1] = playerPosition%30;
               }
            
           
      
    }

    public void setPlayerPosition(int playerPos) {
        playerPosition = playerPos;
    }

    public Integer[] getPropertyPosition() {
        return propertyPosition;
    }

//    public void setInCanada(boolean inCan) {
//        inCanada = inCan;
//    }

   
    
    
   
   
}
