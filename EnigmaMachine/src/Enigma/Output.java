/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enigma;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class Output {
    
 
  private String line;
  private int n = 0;
  private List<String> finalOutput = new ArrayList<>();
  
    public void setLine(String lin) {
        line = lin;
    }
  
    public void addToArray(){
      finalOutput.add(line);
    }
  
    
      public void WriteWithBufferedWriter(){
          
        try {
            String fileOutput = "EnigmaMachine_Output.txt";
            FileWriter fileWriter = new FileWriter(fileOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
           for (int i = 0; i < finalOutput.size(); i++){
            bufferedWriter.write(finalOutput.get(i));
            bufferedWriter.newLine();
           }
          
           // bufferedWriter.newLine();
           
           
            
            
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("No input");
        }
    }
    
    
}
