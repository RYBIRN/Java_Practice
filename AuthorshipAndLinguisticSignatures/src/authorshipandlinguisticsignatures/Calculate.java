/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;

/**
 *
 * @author RyanB
 */
public class Calculate {
    
    private float totalNumberWords = 0;
    private float totalNumberChars = 0;
    private float totalNumberSentences = 0;
    private float totalNumberUniqueWords = 0;
    private float totalNumberWordsOccurOnce = 0;
    private float totalNumberPhrases = 0;
    
    private float averageWordLength = 0;
    private float typeTokenRatio = 0;
    private float hapaxLegomanaRatio = 0;
    private float averageWordsPerSentence = 0;
    private float averagePhrasePerSentence = 0;
    
    public Calculate(int numwords, int numchars, int numsentences, int numuniwords, int numwordsoneoccur, int numphrases) {
        totalNumberWords = numwords;
        totalNumberChars = numchars;
        totalNumberSentences = numsentences;
        totalNumberUniqueWords = numuniwords;
        totalNumberWordsOccurOnce = numwordsoneoccur;
        totalNumberPhrases = numphrases;
        
       // System.out.println("total number of words: " +totalNumberWords);
       // System.out.println("total number of chars: " +totalNumberChars);
       // System.out.println("total number of sentences: " +totalNumberSentences);
       // System.out.println("total number unique words: " +totalNumberUniqueWords);
       // System.out.println("total number words occur once: " +totalNumberWordsOccurOnce);
       // System.out.println("total number of phrases: " +totalNumberPhrases);
    }
    
    public void MakeCalculations(){
//        System.out.println("total num words: " +totalNumberWords);
//        System.out.println("total num chars: " +totalNumberChars);
//        System.out.println("Total num sentences: " +totalNumberSentences);
//        System.out.println("total num unique words: " +totalNumberUniqueWords);
//        System.out.println("total num words occur once: "+totalNumberWordsOccurOnce);
//        System.out.println("total num phrases :" +totalNumberPhrases);
      
        AverageWordLength();
        TypeTokenRatio();
        HapaxLegomanaRatio();
        AverageWordsPerSentence();
        AveragesPhrasesPerSentence();
    }
    
    
    private void AverageWordLength(){
        averageWordLength = totalNumberChars/totalNumberWords;
        //System.out.println("avg wd length: " +averageWordLength);
    }
    
    private void TypeTokenRatio(){
        typeTokenRatio = totalNumberUniqueWords/totalNumberWords;
    }
    
    private void HapaxLegomanaRatio(){
        hapaxLegomanaRatio = totalNumberWordsOccurOnce/totalNumberWords;
    }
    
    private void AverageWordsPerSentence(){
        averageWordsPerSentence = totalNumberWords/totalNumberSentences;
    }
    
    private void AveragesPhrasesPerSentence(){
        averagePhrasePerSentence = totalNumberPhrases/totalNumberSentences;
    }

    public float getAverageWordLength() {
        return averageWordLength;
    }

    public float getTypeTokenRatio() {
        return typeTokenRatio;
    }

    public float getHapaxLegomanaRatio() {
        return hapaxLegomanaRatio;
    }

    public float getAverageWordsPerSentence() {
        return averageWordsPerSentence;
    }

    public float getAveragePhrasePerSentence() {
        return averagePhrasePerSentence;
    }
    
    
    
}
