import java.util.*;

 /** 
   * Hangman Game
   * @author Efe Beydoðan and a lot of other people from Section 3
   * @version 16.02.2020
   */ 
   
public class HangmanGame
{
   public static void  main(String[] args) 
   {
      
      //constants
      
      
      // variables
      
      Hangman hangman = new Hangman();
      boolean testGameOver;
      String letter;
      char letterChar;
      Scanner scan;
      int returnedInteger;
      boolean canAppend;
      
      //program code
      scan = new Scanner( System.in);
      
      testGameOver = hangman.isGameOver();  // CHECKS IF THE GAME IS OVER, SUPPOSED THAT isGameOver() METHOD 
      // GIVES THE RESULT "FALSE" INITIALLY SINCE THE GAME IS NOT OVER, YET EVEN STARTED :)
      
      
      System.out.println( hangman.getAllLetters());  //  SHOWS THE USER ALL POSSIBLE LETTERS IN THE ALPHABET, SUPPOSED THAT getAllLeters() METHOD
      //  RETURNS THE STRING OF ENGLISH ALPHABET
      
      System.out.print( "Hello there! ");
      
      //This is true at first
      canAppend = true;
      while ( !testGameOver)
      {
         System.out.println( "Please use unused letter from the English Alphabet.\n Used letters are: " + hangman.getUsedLetters());
         letter = scan.nextLine();
         //Just get the first letter of every input
         letterChar = letter.charAt(0);
         
         returnedInteger = hangman.tryThis(letterChar);
         
         //For the first letter entered, append it to usedLetters
         if ( hangman.returnUsedLetters().length() == 0)
         {
            hangman.returnUsedLetters().append( letterChar);
            canAppend = false;
         }
         
         //For every input after first letter, check if it has been entered before
         for ( int i = 0; i < hangman.returnUsedLetters().length(); i++)
         {
            //If the letter has been entered before, canAppend is false so the letter isn't appended again
            if ( hangman.returnUsedLetters().charAt(i) == letterChar)
            {
               canAppend = false;
            }
         }
         //If canAppend is true, the entered letter hasn't been entered before and should be appended
         if ( canAppend)
         {
            hangman.returnUsedLetters().append( letterChar);
         }
         //canAppend should be set to true so if it isn't set to false in the for loop above, it should append the entered letter to the end of the StringBuffer usedLetters
         canAppend = true;
         
         if ( returnedInteger == 0) {  //  IF tryThis() METHOD RETURNS 0, THEN IT MEANS THERE IS NO LETTER IN THE WORD MATCHES WITH THE LETTER USER ENTERED
            System.out.println( "The letter " + letterChar + " is not in this word.");
            System.out.println( hangman.getKnownSoFar( hangman.returnSecretWord(), letter));  
         }
         
         else if ( returnedInteger == -1 ) {  //  IF tryThis() METHOD RETURNS -1, THEN IT MEANS USER ENTERED AN INVALID LETTER
            System.out.println( "Error, you have entered an invalid letter.");
         }
         
         else if ( returnedInteger == -2 ){   //  IF tryThis() METHOD RETURNS -2, THEN IT MEANS USER ENTERED A LETTER THAT HAS ALREADY BEEN ENTERED
            System.out.println( "Error, you have already tried this letter.");
         } 
         
         else if ( returnedInteger == -3 ){   //  IF tryThis() METHOD RETURNS -3, THEN IT MEANS GAME IS OVER
            System.out.println( "The game is over!");
         }
         
         else {
            System.out.println( hangman.getKnownSoFar( hangman.returnSecretWord(), letter));  
         }  
         
         testGameOver = hangman.isGameOver();  //  WE ASSUME THAT THE BOOLEAN RETURN VALUE OF isGameOver() CHANGES WHEN USER ENTERS DIFFERENT LETTERS
         //  IF ALL THE LETTERS ARE REVEALED OR MAX INCORRECT TRIES GOT REACHED, THE METHOD WILL RETURN TRUE.
         //  THE LINE CHECKS AT THE END OF EACH LOOP WHETHER GAME ENDED OR NOT.
      }
      
      if ( hangman.hasLost())
         System.out.println( "You lose!" );
      else
         System.out.println( "You win!" );
   } 
}