/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class MysteryAuthor {
    
    private float mysAvgWord, mysTypeToke, mysHapax, mysAWPS, mysAPPS ;
    
    private float AvgWordLengthWeight = 11, TypeTokenWeight = 33, HapaxWeight = 50, AverageWPSWeight = (float) 0.4, AveragePPSWeight = 4;
  
        private List<String> authorName = new ArrayList<>();
      // private List<Integer> numberOfBooks = new ArrayList<>();
    private List<Float> AvgWordLength = new ArrayList<>();
    private List<Float> TypeToken = new ArrayList<>();
    private List<Float> Hapax = new ArrayList<>();
    private List<Float> AvgWordPerSentence = new ArrayList<>();
    private List<Float> AvgPhrasePerSentence = new ArrayList<>();

    public MysteryAuthor(float mysAvgWor, float mysTypeTok, float mysHapa, float mysAWP, 
            float mysAPP, List<String> authors, 
            List<Float> AvgWordLengt, List<Float> TypeToke, 
            List<Float> Hapa, List<Float> AvgWordPerSentenc, List<Float> AvgPhrasePerSentenc) {
        
       mysAvgWord = mysAvgWor;
        mysTypeToke = mysTypeTok;
        mysHapax = mysHapa;
        mysAWPS = mysAWP;
        mysAPPS = mysAPP;
        
        authorName.addAll(authors);
        AvgWordLength.addAll(AvgWordLengt);
        TypeToken.addAll(TypeToke);
        Hapax.addAll(Hapa);
        AvgWordPerSentence.addAll(AvgWordPerSentenc);
        AvgPhrasePerSentence.addAll(AvgPhrasePerSentenc);
    }
    
    
       
       public void FindMysteryAuthor(){
           float tempWordL, tempToken, tempHapax, tempAWPS, tempAPPS;
           float tempSum, finalSum;
                   int finalIndex;
                   finalIndex = -1;
                   finalSum = 100;
           
           for (int i = 0; i < authorName.size(); i++){
               
               tempWordL = abs(AvgWordLength.get(i) - mysAvgWord) * AvgWordLengthWeight;
               tempToken = abs(TypeToken.get(i) - mysTypeToke) * TypeTokenWeight;
               tempHapax = abs(Hapax.get(i) - mysHapax) * HapaxWeight;
               tempAWPS = abs(AvgWordPerSentence.get(i) - mysAWPS) * AverageWPSWeight;
               tempAPPS = abs(AvgPhrasePerSentence.get(i) - mysAPPS) * AveragePPSWeight;
               
               tempSum = tempWordL + tempToken + tempHapax + tempAWPS +tempAPPS;
               
              if(tempSum < finalSum){
                  finalSum = tempSum;
                  finalIndex = i;
              } 
               
               
           }
           
           System.out.println("The Author that most resembles this books linguistic signature is, " +authorName.get(finalIndex) + ".");
           
           
       }
        
        
    
    
    
    
}
