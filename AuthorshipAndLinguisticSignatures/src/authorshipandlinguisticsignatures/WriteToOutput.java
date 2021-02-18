/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class WriteToOutput {
    
   
    
    private List<String> authorName = new ArrayList<>();
       private List<Integer> numberOfBooks = new ArrayList<>();
    private List<Float> AvgWordLength = new ArrayList<>();
    private List<Float> TypeToken = new ArrayList<>();
    private List<Float> Hapax = new ArrayList<>();
    private List<Float> AvgWordPerSentence = new ArrayList<>();
    private List<Float> AvgPhrasePerSentence = new ArrayList<>();
    
    private String fileOutput;
    private List<String> FinalList = new ArrayList<>();

    public WriteToOutput(List<String> author, List<Integer> numbk, List<Float> avgwdL, List<Float> TypeToke, List<Float> Hap, List<Float> AvgWdPerS, List<Float> AvgPhrPerS) {
        authorName.addAll(author);
        numberOfBooks.addAll(numbk);
        AvgWordLength.addAll(avgwdL);
        TypeToken.addAll(TypeToke);
        Hapax.addAll(Hap);
        AvgWordPerSentence.addAll(AvgWdPerS);
        AvgPhrasePerSentence.addAll(AvgPhrPerS);
    }
 
    
    public void CreateFinalList(){
        for (int i = 0; i < authorName.size(); i++)
        {
            String auth = authorName.get(i);
            String numBks = numberOfBooks.get(i).toString();
            String avgWdLeng = String.format("%.3f", AvgWordLength.get(i));
            String typeToke = String.format("%.3f", TypeToken.get(i));
            String hapa = String.format("%.3f", Hapax.get(i));
            String avgWdPerSen = String.format("%.3f", AvgWordPerSentence.get(i));
            String avgPhrPerSen = String.format("%.3f", AvgPhrasePerSentence.get(i));
            
            int nameLength = auth.length();
            if(nameLength > 24){
            auth.substring(0, 24);
            nameLength = 24;
            }
            
            int numSpaces = 26 - nameLength;
            
            while(nameLength < 28){
                auth += new String(" ");
                nameLength++;
            }
            
            String finalOutput = auth +  numBks + "\t\t    " + avgWdLeng + "\t\t" 
                    + typeToke + "\t\t     " + hapa + "\t\t\t" + avgWdPerSen + "\t\t\t     " + avgPhrPerSen;
                FinalList.add(finalOutput);
        }
       // System.out.println("Final List: " +FinalList);
        WriteWithBufferedWriter();
    }
    
    public void WriteWithBufferedWriter(){
        try {
            fileOutput = "Signature.txt";
            FileWriter fileWriter = new FileWriter(fileOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            
            bufferedWriter.write("Name" + "\t\t\t" + "# of Books" + "   " + "Average Word Length" + "   " + "Type Token Ratio" + "   " + "Hapax Legomana Ratio" + "   " + "Average Words Per Sentence" + "   " + "Average Phrases Per Sentence");
          //  System.out.println("Name" + "\t" + "# of Books" + "\t" + "Average Word Length" + "\t" + "Type Token Ratio" + "\t" + "Hapax Legomana Ratio" + "\t" + "Average Words Per Sentence" + "\t" + "Average Phrases Per Sentence");
            bufferedWriter.newLine();
            bufferedWriter.write("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            bufferedWriter.newLine();
           // System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            for (int i = 0; i < FinalList.size(); i++)
            {
                bufferedWriter.write(FinalList.get(i));
                bufferedWriter.newLine();
              //  System.out.println(FinalList.get(i));
            }
            
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("No input");
        }
    }
    
    
}
