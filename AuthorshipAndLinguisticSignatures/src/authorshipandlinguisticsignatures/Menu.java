/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;



import java.util.Scanner;

/**
 *
 * @author RyanB
 */
public class Menu {
   
   
    Scanner input = new Scanner(System.in);
   
  
    
    private String authorName = "";
     private String newBook;
     private boolean programRepeat;
     
    public void Welcome(){
        System.out.println("Welcome to RyanB's authorship and linguistic signature calculator!");
    }
    
    public void AuthorName(){
       String auth;
        System.out.println("Please enter the name of an author");
        auth = input.nextLine();
        authorName = auth;
        //System.out.println(authorName);
    }
    
    public void BookNameMenu(){
        System.out.println("Now, please enter the names of the books you would like to analyze followed by \".txt\"");
        System.out.println("For example if you wanted to analyze the book Great Expectations, you would type Great Expectations.txt");
        System.out.println("To stop adding books, type STOP (in all caps) to begin analyzing your selection");
        
       
       /** System.out.println(newBook);
            for(int i = 0; i < newBook.size(); i++) {
            System.out.println(newBook.get(i));
             **/
    }
    
    public void NextBooks(){
        System.out.println("Book names?"); 
    }
    
    public void RepeatForNextAuthor(){
        programRepeat = false;
        boolean tryAgain = true;
        String repeat = "";
        
        System.out.println("Linguistic Signature has been succesfully calculated for " + authorName);
        System.out.println("Would you like to calculate the signature for another author? (Y/N)");
        
        while(tryAgain){
        repeat = input.next();
        repeat = repeat.toUpperCase();
        
        if (repeat.equals("Y")){
            programRepeat = true;
            tryAgain = false;
        }
        else if (repeat.equals("N"))
        {
            programRepeat = false;
            tryAgain = false;
        }
        else{
            System.out.println("Please enter either a Y for yes or N for No");
            tryAgain = true;
        }
        } 
    }
    
    public void NewAuthor(){
        String auth;
        System.out.println("Author?");
        auth = input.nextLine();
        authorName = auth;
    }
    
    public void InputBookName(){
        newBook = input.nextLine();
    }
    
    public String getNewBook() {
        return newBook;
    }
         
    public String getAuthorName() {
        return authorName;
    }

    public boolean isProgramRepeat() {
        return programRepeat;
    }
    
  
    
}

