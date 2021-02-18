/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class AuthDemo {
    
   
    
    private String authorName; //used to add users input into the authors list.
     private String bookName; //used to add a book to the books list.
     
    private List<String> newBook = new ArrayList<>(); //keeps track of book names that are going out to get signatures.
    private List<String> authors = new ArrayList<>(); //main list for author names
   
    //these lists are the final average signatures for each author
    private List<Float> avgWdLengList = new ArrayList<>();
  private List<Float> typeTokenList = new ArrayList<>();
   private List<Float> hapaxList = new ArrayList<>();
   private List<Float> avgWdPerSentList = new ArrayList<>();
   private List<Float> avgPhrPerSentList = new ArrayList<>();
   
   private List<Integer> numBooksList = new ArrayList<>(); // keeps a list of the number of books for each author
    
    private List<Float> tempAvgList = new ArrayList<>(); // lisst that sends out an authors signatures to get averages
    
    
     private int booksToDelete = 0; //if a book is not found this variable is incremented 
       
     
        
 
    
    public void MainDemo() {
     
        boolean programRepeat;  
       
        
    Menu initialMenu = new  Menu();
     CombineBooks combineBooks = new CombineBooks();
        initialMenu.Welcome(); //asks for initial author
        
          InitialInput(initialMenu); //takes in the author name and books
         // System.out.println("Loading...");
         
          ReadInBooks(combineBooks); //reads in each book one at a time and calculates signatures for each book
        
          SetAverage(combineBooks); //sets the averages signature scores for the initial author.
     
          initialMenu.RepeatForNextAuthor(); // asks if youd like to add a new author
          programRepeat = initialMenu.isProgramRepeat(); // sets repeat to true if Y is selected
          
          while(programRepeat){
              Menu newMenu = new Menu();
              
               CombineBooks newcombineBooks = new CombineBooks();
               
              newMenu.NewAuthor(); //gets new author name
              
              authorName = newMenu.getAuthorName();
              
              //checks to see if the author is already in the list. If they are then it adds the scores of their new books to their average and creates a new average. 
              //If they're not in the list it adds the new author to the authors list, and then loops again if user wants to input new author.
              if(authors.contains(authorName)){
                  System.out.println("Author already in list, this program will now add the next books that are input to that authors linguistic signature.");
                  
                  newMenu.NextBooks();
                  
                  bookName = "";
                  
                  inputBookName(newMenu);
                
                  
                 // System.out.println("index is: " +authors.indexOf(authorName));
                  
                  ReadInBooks(newcombineBooks);
                  
                 SetAverageSameAuthor(newcombineBooks); //new set average method if the author already has books associated with them.
                  
                  
                  
                  newMenu.RepeatForNextAuthor();
          programRepeat = newMenu.isProgramRepeat();
              }
              else{
                  authors.add(authorName);
                  newMenu.NextBooks();
                  bookName = "";
              inputBookName(newMenu);
              ReadInBooks(newcombineBooks);
              SetAverage(newcombineBooks);
               newMenu.RepeatForNextAuthor();
          programRepeat = newMenu.isProgramRepeat();
              }
          
          }
          //sends out the final lists to write the output to the Signature.txt file.
        WriteToOutput writeToOutput = new WriteToOutput(authors, numBooksList, avgWdLengList, typeTokenList, hapaxList, avgWdPerSentList, avgPhrPerSentList);
              writeToOutput.CreateFinalList();
              //Finally, this asks users to input a new author to guess the authorthat wrote the book based on weighted signatures.
              findMystery();
            
                       
              }
       // System.out.println(newBook);
       // System.out.println(authorName);
      // System.out.println(authors);
      
       
  
    
    
  
    public void findMystery(){
  System.out.println("Now, please enter in the name of a book with an unknown author. This program will make a guess as to which author"
                     + " is the writer of this book.");
                        
               boolean finalBookFound = false; //set to false in order to keep adding book files incase an incorrect name is entered.
              
              while (finalBookFound == false)
              {
                  Menu FinalMenu = new Menu(); 
                  bookName = "";
                FinalMenu.InputBookName(); 
                bookName = FinalMenu.getNewBook();
                
                  ReadIn finalReadIn = new ReadIn(); 
                  finalReadIn.setBookName(bookName);
                  
                   System.out.println("Reading " +bookName+"...");
                   finalReadIn.readWithBufferedReader(); // opens the final book and gathers signatures for it.
                   finalBookFound = finalReadIn.isBookFound();
                   if (finalBookFound){
                      float mysAvgWord;
                      float mysTypeTo;
                      float mysHapax;
                      float mysAvgWPS;
                      float mysAvgPPS;
                              
                        mysAvgWord = finalReadIn.getAverageWordLength();
                         mysTypeTo = finalReadIn.getTypeTokenRatio();
                           mysHapax = finalReadIn.getHapaxLegomanaRatio();
                            mysAvgWPS = finalReadIn.getAverageWordsPerSentence();
                            mysAvgPPS = finalReadIn.getAveragePhrasePerSentence();
                            //sends the mystery authors signature to get compared against the final lists for each author.
                            MysteryAuthor findAuthor = new MysteryAuthor(mysAvgWord, mysTypeTo, mysHapax, 
                                    mysAvgWPS, mysAvgPPS, authors, avgWdLengList, 
                                    typeTokenList, hapaxList, avgWdPerSentList, avgPhrPerSentList);
                            findAuthor.FindMysteryAuthor();
              
                   }
                   else
                       System.out.println("Book not found please renter the book name.");
}
    }

 public void InitialInput(Menu newMenu){
       newMenu.AuthorName();
       newMenu.BookNameMenu();
         authorName = newMenu.getAuthorName();
        authors.add(authorName); 
       inputBookName(newMenu);
        }
 
    public void inputBookName(Menu newMenu){
  while(!"STOP".equals(bookName)){ //while the word STOP is not entered repeat loop to gather as many book names as user wishes to enter.
            newMenu.InputBookName();
            bookName = newMenu.getNewBook();  
        if(!"STOP".equals(bookName)) //checks to make sure the user diddnt enter STOP then adds the book name to the newbook list.
            newBook.add(bookName);
}
    }  
 public void ReadInBooks(CombineBooks combineBooks) {
   
   booksToDelete = 0;
       for (int i = 0; i < newBook.size(); i++){ 
         
           ReadIn newReadIn = new ReadIn();
           
          
          List<Float> readInList  = new ArrayList<>();
          
          newReadIn.setBookName(newBook.get(i));
           System.out.println("Reading " +newBook.get(i)+"...");
      newReadIn.readWithBufferedReader();
      booksToDelete += newReadIn.getRemoveNumberBook();
      
      readInList.add(newReadIn.getAverageWordLength());
      readInList.add(newReadIn.getTypeTokenRatio());
      readInList.add(newReadIn.getHapaxLegomanaRatio());
      readInList.add(newReadIn.getAverageWordsPerSentence());
      readInList.add(newReadIn.getAveragePhrasePerSentence());
      combineBooks.setTempReadInList(readInList);
      combineBooks.Combine();
         // System.out.println(readInList);
     /** newReadIn.getNumberOfWords();
      newReadIn.getNumberOfLetters();
      newReadIn.getNumberOfPunctuation();
      newReadIn.getNumberOfUniqueWords();
      newReadIn.getNumberOfWordsOccuringOnce();
      newReadIn.getNumberOfSentences();
      newReadIn.getNumberOfPhrases();
      **/
      }
     
 }
 
 public void SetAverage(CombineBooks combineBooks){
      tempAvgList.clear();
     
     int numberOfBooks = 0;
      numberOfBooks = newBook.size() - booksToDelete;
       // System.out.println(numberOfBooks);
       numBooksList.add(numberOfBooks);
       //System.out.println("number of books list: " +numBooksList);
       
      newBook.clear();
        
      combineBooks.setNumberOfBooks(numberOfBooks);
      combineBooks.AuthorsAverage();
      tempAvgList.addAll(combineBooks.getReadInList());
       // System.out.println("temp avg list: " +tempAvgList);
      
      avgWdLengList.add(tempAvgList.get(0));
      //  System.out.println("avg word lengths: " +avgWdLengList);
       typeTokenList.add(tempAvgList.get(1));
       // System.out.println("Type token list: " +typeTokenList);
      hapaxList.add(tempAvgList.get(2));
      //  System.out.println("hapax list: " +hapaxList);
      avgWdPerSentList.add(tempAvgList.get(3));
       // System.out.println("avg wd per sent list: " +avgWdPerSentList);
           avgPhrPerSentList.add(tempAvgList.get(4));
       // System.out.println("avg phr per sent list: " +avgPhrPerSentList);
 }
 
 public void SetAverageSameAuthor(CombineBooks combineBooks){
     tempAvgList.clear();
     List<Float> sameAuthorRebuildList = new ArrayList<>();
     
      int numberOfBooks = 0;
      numberOfBooks = newBook.size();
      int numbk = numberOfBooks + 1;
      
     int index = authors.indexOf(authorName);
     
     numberOfBooks = numBooksList.get(index) + numberOfBooks;
     numBooksList.set(index, numberOfBooks);
     
     sameAuthorRebuildList.add(avgWdLengList.get(index));
     sameAuthorRebuildList.add(typeTokenList.get(index));
     sameAuthorRebuildList.add(hapaxList.get(index));
     sameAuthorRebuildList.add(avgWdPerSentList.get(index));
     sameAuthorRebuildList.add(avgPhrPerSentList.get(index));
     System.out.println("Same author list: " +sameAuthorRebuildList);
     
     newBook.clear();
     
     combineBooks.setTempReadInList(sameAuthorRebuildList);
     combineBooks.Combine();
     
     combineBooks.setNumberOfBooks(numbk);
     combineBooks.AuthorsAverage();
     
     tempAvgList.addAll(combineBooks.getReadInList());
       // System.out.println("temp avg list: " +tempAvgList);
        
         avgWdLengList.set(index, tempAvgList.get(0));
      //  System.out.println("avg word lengths: " +avgWdLengList);
       typeTokenList.set(index, tempAvgList.get(1));
       // System.out.println("Type token list: " +typeTokenList);
      hapaxList.set(index, tempAvgList.get(2));
      //  System.out.println("hapax list: " +hapaxList);
      avgWdPerSentList.set(index, tempAvgList.get(3));
       // System.out.println("avg wd per sent list: " +avgWdPerSentList);
           avgPhrPerSentList.set(index, tempAvgList.get(4));
       // System.out.println("avg phr per sent list: " +avgPhrPerSentList);
 }
   

 
}
