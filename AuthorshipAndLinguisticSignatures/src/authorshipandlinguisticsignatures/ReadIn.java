/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class ReadIn {
    
  // private String bookName;
    private URL url;
   
    private List<String> newWord = new ArrayList<>();
     private List<String> wordsOccuringOnce = new ArrayList<>();
     private List<String> totalWords = new ArrayList<>();
    
   private String temp;
   
   private int numberOfWords = 0;
   private int numberOfLetters = -1; // The count number of letters method adds one extra letter count 
   private int numberOfPunctuation = 0;
   private int numberOfUniqueWords = 0;
   private int numberOfWordsOccuringOnce = 0;
   private int numberOfSentences = 0;
   private int numberOfPhrases = 0;
   private int removeNumberBook = 0;
   
   private float averageWordLength = 0;
    private float typeTokenRatio = 0;
    private float hapaxLegomanaRatio = 0;
    private float averageWordsPerSentence = 0;
    private float averagePhrasePerSentence = 0;
   
    private String bookName;
    private boolean bookFound;
   
    
    public void setBookName(String book) {
        newWord.clear();
        wordsOccuringOnce.clear();
        bookName = book;
        url = getClass().getResource("../resources/files/"+bookName);
        //System.out.println(url);
    }
    
    public void readWithBufferedReader(){
        
        try{
            String decodedPath = URLDecoder.decode(url.getPath(), "UTF-8");
            //System.out.println(decodedPath);
           FileReader fileReader = new FileReader(decodedPath);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
            temp = bufferedReader.readLine();
           
           while(temp!= null)
           {
              
               CountWordCharSentPuncPhrase();
               AddWordToList();
               numberOfWordsOccuringOnce = wordsOccuringOnce.size();
              
               
               //System.out.println(temp);
               temp = bufferedReader.readLine();
        }     
           
           bufferedReader.close();
           DoCalculations();
           bookFound = true;
        }
             catch (IOException | NullPointerException e) {
            System.out.println(bookName + " File not Found.");
           removeNumberBook++;
           bookFound = false;
            
        }
   
            
        
        }

    private void CountWordCharSentPuncPhrase(){
    String word[] = temp.split(" ");
    boolean lastCharisLetter = false;
                       for (String w : word){
                          w = w.trim();
                                   if (!w.equals(""))
                           numberOfWords++;
        char[] wtoCharArray = w.toCharArray();
                           for (char wd : wtoCharArray){
                                  if(wd == '.' || wd == '!' || wd == '?'){
                                   if(lastCharisLetter){
                                   numberOfSentences++;
                               lastCharisLetter = false;
                               numberOfPunctuation++;
                               numberOfPhrases++;
                                   }
                                  }
                               else if(wd == ',' || wd == ';' || wd == ':'){
                                   if(lastCharisLetter){
                                       numberOfPhrases++;
                                   numberOfPunctuation++;
                                   lastCharisLetter = false;
                                   }
                                  }
                                  else if (wd == '.' || wd == ',' || wd == '?' || wd == ':'
                                       || wd == ';' || wd == '\'' || wd == '"' || wd == '/'
                                       || wd == '<' || wd == '>' || wd == '[' || wd == ']'
                                       || wd == '{' || wd == '}' || wd == '\\' || wd == '|'
                                       || wd == '!' || wd == '@' || wd == '#' || wd == '$'
                                       || wd == '%' || wd == '^' || wd == '&' || wd == '*'
                                       || wd == '(' || wd == ')' || wd == '=' || wd == '+'
                                       || wd == '`' || wd == '~'){
                                   numberOfPunctuation++;
                                   lastCharisLetter = false;
                                   }
                                  else{
                                   numberOfLetters++;
                           lastCharisLetter = true;
                                  }
                           }
                       }        
}
    


    
    private void AddWordToList(){
        String word[] = temp.split(" ");
                       for (String w : word){
                           String words = w.toLowerCase();
                          words = words.replaceAll("\\p{P}", "");
                          words = words.replaceAll("\\s+", "");
                           if(!newWord.contains(words)){
                               newWord.add(words);
                               wordsOccuringOnce.add(words);
                               numberOfUniqueWords++;
                               numberOfWordsOccuringOnce++;
                           }
                           else if(wordsOccuringOnce.contains(words))
                               wordsOccuringOnce.remove(words);
                       }
    }
    
    private void DoCalculations(){
         Calculate newCalculate = new Calculate(numberOfWords, numberOfLetters, numberOfSentences, numberOfUniqueWords, numberOfWordsOccuringOnce, numberOfPhrases);
           newCalculate.MakeCalculations();
           averageWordLength = newCalculate.getAverageWordLength();
           typeTokenRatio = newCalculate.getTypeTokenRatio();
           hapaxLegomanaRatio = newCalculate.getHapaxLegomanaRatio();
           averageWordsPerSentence = newCalculate.getAverageWordsPerSentence();
           averagePhrasePerSentence = newCalculate.getAveragePhrasePerSentence();
           
    }

    public float getAverageWordLength() {
        System.out.println("Average word length: " +averageWordLength);
        return averageWordLength;
    }

    public float getTypeTokenRatio() {
        System.out.println("Type Token-Ratio: " +typeTokenRatio);
        return typeTokenRatio;
    }

    public float getHapaxLegomanaRatio() {
       System.out.println("hapax Legomana: " +hapaxLegomanaRatio);
        return hapaxLegomanaRatio;
    }

    public float getAverageWordsPerSentence() {
        System.out.println("average Words per sentence: " +averageWordsPerSentence);
        return averageWordsPerSentence;
    }

    public float getAveragePhrasePerSentence() {
        System.out.println("Average Phrase per Sentence: " +averagePhrasePerSentence);
        return averagePhrasePerSentence;
    }

    public int getRemoveNumberBook() {
        return removeNumberBook;
    }

    public boolean isBookFound() {
        return bookFound;
    }
    
    

    
  
    
    
    
    
    
/** used to test if output is correct for book
    public int getNumberOfPhrases() {
        System.out.println("number of phrases: " +numberOfPhrases);
        return numberOfPhrases;
    }

    
    
    public int getNumberOfSentences() {
        System.out.println("number of sentences: " +numberOfSentences);
        return numberOfSentences;
    }
   
    
    public int getNumberOfWords() {
        System.out.println("number of words: " +numberOfWords);
        
        return numberOfWords;
    }

    public int getNumberOfLetters() {
        System.out.println("number of letters: " +numberOfLetters);
        return numberOfLetters;
        
    }

    public int getNumberOfPunctuation() {
        System.out.println("number of punctuation: " +numberOfPunctuation);
        return numberOfPunctuation;
    }

    public int getNumberOfUniqueWords() {
        System.out.println("number of unique words: " +numberOfUniqueWords);
      //  System.out.println(newWord);
        return numberOfUniqueWords;
    }

    public int getNumberOfWordsOccuringOnce() {
       // System.out.println(wordsOccuringOnce);
        System.out.println("number of words occuring once: " +numberOfWordsOccuringOnce);
        return numberOfWordsOccuringOnce;
    }
    
    **/
    
    
    
}
