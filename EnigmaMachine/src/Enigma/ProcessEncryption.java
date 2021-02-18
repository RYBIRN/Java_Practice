/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enigma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class ProcessEncryption {
    
    Output newOutput = new Output();
    
    private URL url;
    
     private File fileName;
     
     private String temp;
     private String finalLine = "";
 
     
     private char[] tempToChar;
    
     private String ONE = "ONE";
     private String TWO = "TWO";
     private String THREE= "THREE";
     private String FOUR = "FOUR";
     private String FIVE = "FIVE";
     private String SIX = "SIX";
     private String SEVEN = "SEVEN";
     private String EIGHT = "EIGHT";
     private String NINE = "NINE";
     
     private char preChar;
   
     
     private String innerWheel;
    private String middleWheel;
    private String outerWheel;
    
    private int innerWheelStart;
    private int middleWheelStart;
    private int outerWheelStart;
   
    private int cypherWheelIndex;
    
    private List<Character> plugboard_1 = new ArrayList<Character>();
    private List<Character> plugboard_2 = new ArrayList<Character>();
    private List<Character> Reflector_1 = new ArrayList<Character>();
    private List<Character> Reflector_2 = new ArrayList<Character>();
    
     private List<Character> Rotor_1 = new ArrayList<Character>();
    private List<Character> Rotor_2 = new ArrayList<Character>();
    private List<Character> Rotor_3 = new ArrayList<Character>();
    private List<Character> Rotor_4 = new ArrayList<Character>();
    private List<Character> Rotor_5 = new ArrayList<Character>();
    
     private List<Character> innerWheelFinal = new ArrayList<Character>();
    private List<Character> middleWheelFinal = new ArrayList<Character>();
    private List<Character> outerWheelFinal = new ArrayList<Character>();
    
    private boolean Encode = false;
   private boolean isCapital = false;
private boolean cypherInReverse = false;

private int R_1 = 0;
private int R_2 = 0;
private int R_3 = 0;

    public ProcessEncryption(File file, String innerWhe, String MidWhee, String OutWhe,
            int innerWhSt, int MidWheSt, int outWheSt,
            List<Character> pBoard1, List<Character> pBoard2, List<Character> Ref1, List<Character> ref2,
            List<Character> rot1, List<Character> rot2, List<Character> rot3, List<Character> rot4, List<Character> rot5) {
        
        fileName = file;
        innerWheel = innerWhe;
        middleWheel = MidWhee;
        outerWheel = OutWhe;
        innerWheelStart = innerWhSt;
        middleWheelStart = MidWheSt;
        outerWheelStart = outWheSt;
        plugboard_1.addAll(pBoard1);
        plugboard_2.addAll(pBoard2);
        Reflector_1.addAll(Ref1);
        Reflector_2.addAll(ref2);
        Rotor_1.addAll(rot1);
        Rotor_2.addAll(rot2);
        Rotor_3.addAll(rot3);
        Rotor_4.addAll(rot4);
        Rotor_5.addAll(rot5);
      
         
     R_1 = innerWheelStart;
      //  R_2 = middleWheelStart;
       //R_3 = outerWheelStart;
        
        setWheelChoice();
        //System.out.println(fileName);
  
    }

   
  public void OpenFile(){
     
        try{
            
      
           BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            temp = bufferedReader.readLine();
           
           while(temp!= null)
           {
               finalLine = "";
               System.out.println(temp);
             tempToChar = temp.toCharArray();
            
             //change numbers to words
              ChangeNumToWord();
              
              
               
              
                   DecryptEncrypt();
               //System.out.println(temp);
               finalLine = finalLine + "\n";
               newOutput.setLine(finalLine);
               newOutput.addToArray();
               
               temp = bufferedReader.readLine();
        }     
           
           bufferedReader.close();
            System.out.println(finalLine);
           newOutput.WriteWithBufferedWriter();
        }
             catch (IOException | NullPointerException e) {
            System.out.println(fileName + " File not Found.");
           
           
        }
   
            
        }
  

  
  private void DecryptEncrypt(){
       List<Character> finalCharactersList = new ArrayList<Character>();
    
      for (char c : tempToChar){
          
      if (Character.isLetter(c) || c == '.' || c == ' '){
          cypherInReverse = false;
            if(Character.isUpperCase(c)){
              isCapital = true;
            }
              else
              isCapital = false;
          c = Character.toLowerCase(c);
            
        preChar = c;
          //System.out.println("Character to be encrypted: " +preChar);
          //go to plugboard
          Plugboard();
          //System.out.println("After plugboard 1: " +preChar);
          //cypher wheel
          cypherWheel();
          //System.out.println("After Cypher: " +preChar);
          // reflector
          Reflector();
          cypherInReverse = true;
          //System.out.println("After reflector: " +preChar);
          
          // cypher in reverse
          cypherWheel();
          //System.out.println("After cypher in reverse: " +preChar);
          //final plugboard
          Plugboard();
          //System.out.println("After final plugboard: " +preChar);
          
          //spin wheels
          Rotate();
          System.out.println("New Wheel positions: " +innerWheelFinal);
          System.out.println("New Wheel positions: " +middleWheelFinal);
          System.out.println("New Wheel positions: " +outerWheelFinal);
          if (isCapital)
              preChar = Character.toUpperCase(preChar);
          
       finalCharactersList.add(preChar);
      }
      else{ 
          preChar = c;
          finalCharactersList.add(preChar);
      }
      }
      
      finalCharactersList.forEach((w) -> {
          finalLine += w;
        });
      finalCharactersList.clear();
          System.out.println(finalLine); 
  }
  
  private void ChangeNumToWord(){
      int i = 0;
      for (char c : tempToChar){
          if (Character.isDigit(c)){
             i = Arrays.asList(tempToChar).indexOf(c);
             switch (c){
                 case '1' : Arrays.asList(tempToChar).set(i,ONE.toCharArray());
                 break;
                  case '2' : Arrays.asList(tempToChar).set(i,TWO.toCharArray());
                 break;
                  case '3' : Arrays.asList(tempToChar).set(i,THREE.toCharArray());
                 break;
                  case '4' : Arrays.asList(tempToChar).set(i,FOUR.toCharArray());
                 break;
                  case '5' : Arrays.asList(tempToChar).set(i,FIVE.toCharArray());
                 break;
                  case '6' : Arrays.asList(tempToChar).set(i,SIX.toCharArray());
                 break;
                  case '7' : Arrays.asList(tempToChar).set(i,SEVEN.toCharArray());
                 break;
                  case '8' : Arrays.asList(tempToChar).set(i,EIGHT.toCharArray());
                 break;
                  case '9' : Arrays.asList(tempToChar).set(i,NINE.toCharArray());
                 break;
                  default : break;
             }
          }
      }
  }
  
  
  
private void setWheelChoice(){
    switch (innerWheel){
        case "Rotor 1": innerWheelFinal.addAll(Rotor_1);
        break;
        case "Rotor 2": innerWheelFinal.addAll(Rotor_2);
        break;
        case "Rotor 3": innerWheelFinal.addAll(Rotor_3);
        break;
        case "Rotor 4" : innerWheelFinal.addAll(Rotor_4);
        break;
        case "Rotor 5" : innerWheelFinal.addAll(Rotor_5);
        break;
        default: break;
    }
    
    switch(middleWheel){
           case "Rotor 1": middleWheelFinal.addAll(Rotor_1);
        break;
        case "Rotor 2": middleWheelFinal.addAll(Rotor_2);
        break;
        case "Rotor 3": middleWheelFinal.addAll(Rotor_3);
        break;
        case "Rotor 4" : middleWheelFinal.addAll(Rotor_4);
        break;
        case "Rotor 5" : middleWheelFinal.addAll(Rotor_5);
        break;
        default: break;
    }
    
       switch(outerWheel){
           case "Rotor 1": outerWheelFinal.addAll(Rotor_1);
        break;
        case "Rotor 2": outerWheelFinal.addAll(Rotor_2);
        break;
        case "Rotor 3": outerWheelFinal.addAll(Rotor_3);
        break;
        case "Rotor 4" : outerWheelFinal.addAll(Rotor_4);
        break;
        case "Rotor 5" : outerWheelFinal.addAll(Rotor_5);
        break;
        default: break;
    }
               //System.out.println("Before rotating: " +innerWheelFinal);
        //System.out.println("Before rotating: " +middleWheelFinal);
      // System.out.println("Before rotating: " +outerWheelFinal);
       //System.out.println(innerWheelStart);
      // System.out.println(middleWheelStart);
       //System.out.println(outerWheelStart);
       
       Collections.rotate(innerWheelFinal, -(innerWheelStart - 1));
       Collections.rotate(middleWheelFinal, -(middleWheelStart - 1));
       Collections.rotate(outerWheelFinal, -(outerWheelStart - 1));
       
        System.out.println("After rotating: " +innerWheelFinal);
       System.out.println("After rotating: " +middleWheelFinal);
       System.out.println("After rotating: " +outerWheelFinal);
}
  
  
    
private void Plugboard(){
    int i = 0;
    
    if (plugboard_1.contains(preChar)){
      i = plugboard_1.indexOf(preChar);
        preChar = plugboard_2.get(i);
    }
    else if (plugboard_2.contains(preChar))
    {
        i = plugboard_2.indexOf(preChar);
        preChar = plugboard_1.get(i);
    }
   // System.out.println("After Plugboard: " +preChar);
}

private void Reflector(){
       int i = 0;
    
    if (Reflector_1.contains(preChar)){
      i = Reflector_1.indexOf(preChar);
        preChar = Reflector_2.get(i);
    }
    else if (Reflector_2.contains(preChar))
    {
        i = Reflector_2.indexOf(preChar);
        preChar = Reflector_1.get(i);
    }
    //System.out.println("After reflector: " +preChar);
}

private void Rotate(){

    if (R_1 < 26){
        Collections.rotate(innerWheelFinal, 1);
        R_1++;
        System.out.println("Rotating inner.");
        System.out.println(R_1);
       // System.out.println("Rotated inner: " + innerWheelFinal);
    }
    else if(R_2 < 27){
         R_1 = 1;
         Collections.rotate(innerWheelFinal, 1);
         System.out.println("Rotating inner.");
        System.out.println(R_1);
        
          Collections.rotate(middleWheelFinal, 1);
        R_2++;
        System.out.println("Rotating middle.");
        System.out.println(R_2);
       //  System.out.println("Rotated middlke: " + middleWheelFinal);
    }
    else if (R_3 < 27){
        R_1 = 0;
            R_2 = 0;
         Collections.rotate(innerWheelFinal, 1);
         System.out.println("Rotating inner.");
        System.out.println(R_1);
        
        Collections.rotate(outerWheelFinal, 1);
        R_3++;
        System.out.println("Rotating outer.");
        System.out.println(R_3);
        // System.out.println("Rotated outer: " + outerWheelFinal);
    }
    else
    {
        R_1 = 0;
        Collections.rotate(innerWheelFinal, 1);
        System.out.println("Rotating all Wheels.");
        // System.out.println("Rotated inner: " + innerWheelFinal);
        R_1++;
        R_2 = 0;
        R_3 = 0;
    }
}

private void cypherWheel(){
    if (cypherInReverse){
        findOuter();
        findMiddle();
        findOuter();
        findInner();
    }
    else{
    findInner();
    findOuter();
    findMiddle();
    findOuter();
            }
}

private void findInner(){
    if (cypherInReverse) {
        preChar = innerWheelFinal.get(cypherWheelIndex);
      //  System.out.println("Char Changed to: " +preChar);
    }
    else
    cypherWheelIndex = innerWheelFinal.indexOf(preChar);
}

private void findMiddle(){
    if (cypherInReverse){
        preChar = middleWheelFinal.get(cypherWheelIndex);
    //System.out.println("Char Changed to: " +preChar);
    }
    else
    cypherWheelIndex = middleWheelFinal.indexOf(preChar);
}

private void findOuter(){
    if (cypherInReverse){
        cypherWheelIndex = outerWheelFinal.indexOf(preChar);
    }
    else{
    preChar = outerWheelFinal.get(cypherWheelIndex);
   // System.out.println("Char Changed to: " + preChar);
    }
   
}
   
}
