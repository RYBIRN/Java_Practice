/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enigma;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class EnigmaMachineDemo {
    
    private String innerWheel;
    private String middleWheel;
    private String outerWheel;
    
    private int innerWheelStart;
    private int middleWheelStart;
    private int outerWheelStart;
    
    private File fileName;
    
    private String plugboardSettings;
    private String reflectorSettings;
    
    private List<Character> plugboard_1 = new ArrayList<Character>();
    private List<Character> plugboard_2 = new ArrayList<Character>();
    private List<Character> Reflector_1 = new ArrayList<Character>();
    private List<Character> Reflector_2 = new ArrayList<Character>();
    
         private List<Character> Rotor_1 = new ArrayList<Character>();
    private List<Character> Rotor_2 = new ArrayList<Character>();
    private List<Character> Rotor_3 = new ArrayList<Character>();
    private List<Character> Rotor_4 = new ArrayList<Character>();
    private List<Character> Rotor_5 = new ArrayList<Character>();
    
    private String ROTOR1 = "AUNGHOVBIPWCJQXDKRY ELSZFMT.";
    private String ROTOR2 = "O J.ETYCHMRWAFKPUZDINSXBGLQV";
    private String ROTOR3 = "FBDHJLNPRTVXZ.ACEGI KMOQSUWY";
    private String ROTOR4 = ".HKPDEAC WTVQMYNLXSURZOJFBGI";
    private String ROTOR5 = "YDNGLCIQVEZRPTAOXWBMJSUH.K F";

    public EnigmaMachineDemo(String innerWhee, String middleWhee, String outerWhee, int innerWheelStar, int middleWheelStar, int outerWheelStar, File fileNam, String plugboardSetting, String reflectorSetting) {
        innerWheel = innerWhee;
        middleWheel = middleWhee;
        outerWheel = outerWhee;
        innerWheelStart = innerWheelStar;
        middleWheelStart = middleWheelStar;
        outerWheelStart = outerWheelStar;
        fileName = fileNam;
        plugboardSettings = plugboardSetting;
        reflectorSettings = reflectorSetting;
    }
    
    
    
    public void EncodeDecode(){
        //test to see if values were properly sent over.
//        System.out.println(innerWheel);
//        System.out.println(middleWheel);
//        System.out.println(outerWheel);
//        System.out.println(innerWheelStart);
//        System.out.println(middleWheelStart);
//        System.out.println(outerWheelStart);
//        System.out.println(fileName);
//        System.out.println(plugboardSettings);
//        System.out.println(reflectorSettings);

//          Create plugboard and reflector lists and rotors
            SetPlugboard();
            setReflector();
            SetRotorChars();
            
//        Send eveyrthing to ProcessEncryptionClass
            ProcessEncryption newProcessEncryption = new ProcessEncryption(fileName, innerWheel, middleWheel, outerWheel, 
                   innerWheelStart, middleWheelStart, outerWheelStart, 
                   plugboard_1, plugboard_2, Reflector_1, Reflector_2,
                   Rotor_1, Rotor_2, Rotor_3, Rotor_4, Rotor_5);
            
//      open the file and run 
        newProcessEncryption.OpenFile();
            

       
    }
    
    
   
    
    private void SetPlugboard(){
   
            char[] characters = plugboardSettings.toCharArray();
             boolean listSwitch = true;
            for (char c : characters)
            {
                c = Character.toLowerCase(c);
                   if(Character.isLetter(c) || c == '.') {
                if (listSwitch == true){
                    plugboard_1.add(c);
                    listSwitch = false;
                }
                else {
                    plugboard_2.add(c);
                    listSwitch = true;
                }
                   }
            }
       
//         System.out.println("Plugboard one list: " +plugboard_1);
//         System.out.println("Plugboard two list: " +plugboard_2);
      
    }
    
    private void setReflector(){

           char[] characters = reflectorSettings.toCharArray();
           
             boolean listSwitch = true;
             
             boolean lastCharisSpace = false;
            
             
             
             
             if (reflectorSettings.charAt(0) == ' '){
                 Reflector_1.add(' ');
                 listSwitch = false;
                 lastCharisSpace = true;
             }
            
                 
             
            for (char c : characters)
            {
               c = Character.toLowerCase(c);
             if (lastCharisSpace == true && c == ' ' && !Reflector_1.contains(' ') && !Reflector_2.contains(' ')){
                        if (listSwitch == true){
                   Reflector_1.add(' ');
                    listSwitch = false;
                }
                else {
                    Reflector_2.add(' ');
                    listSwitch = true;
                }
             }
                
                if (c == ' ') {
                    lastCharisSpace = true;
                }
                
                if(Character.isLetter(c) || c == '.')
                {
                           if (listSwitch == true){
                   Reflector_1.add(c);
                    listSwitch = false;
                    lastCharisSpace = false;
                }
                else {
                    Reflector_2.add(c);
                    listSwitch = true;
                    lastCharisSpace = false;
                }
                }
             
            }
            
             if (!Reflector_1.contains(' ') && !Reflector_2.contains(' '))
                 Reflector_2.add(' ');
       
      
//         System.out.println("reflector one list: " +Reflector_1);
//         System.out.println("reflector two list: " +Reflector_2);
        
         
    }
    
     private void SetRotorChars(){
       char[]R1 = ROTOR1.toCharArray();
       char[]R2 = ROTOR2.toCharArray();
       char[]R3 = ROTOR3.toCharArray();
       char[]R4 = ROTOR4.toCharArray();
       char[]R5 = ROTOR5.toCharArray();
       
       for (char c : R1){
           c = Character.toLowerCase(c);
           Rotor_1.add(c);
       }
         for (char c : R2){
              c = Character.toLowerCase(c);
           Rotor_2.add(c);
         }
           for (char c : R3){
                c = Character.toLowerCase(c);
           Rotor_3.add(c);
           }
             for (char c : R4){
                  c = Character.toLowerCase(c);
           Rotor_4.add(c);
             }
               for (char c : R5){
                    c = Character.toLowerCase(c);
           Rotor_5.add(c);
               }
//               System.out.println(Rotor_1);
//               System.out.println(Rotor_2);
//               System.out.println(Rotor_3);
//               System.out.println(Rotor_4);
//               System.out.println(Rotor_5);
               
   }
    
}
