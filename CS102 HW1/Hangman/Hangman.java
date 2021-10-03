import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hangman class
 * @author Efe Beydoðan and a lot of other students from Section 3
 * @version 16.02.2020
 */
public class Hangman{
   
   //properties
   private StringBuffer secretWord;
   private StringBuffer allLetters;
   private StringBuffer usedLetters;
   private StringBuffer knownSoFar;
   private StringBuffer enteredLetter;
   private int numberOfIncorrectTries;
   private int maxAllowedIncorrectTries; 
   
   public  Hangman(){
      allLetters = new StringBuffer( 26);
      
      for ( char letter = 'a'; letter <= 'z'; letter++)
      {
         allLetters.append( letter);
         
      }
      
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      usedLetters = new StringBuffer();
      secretWord = new StringBuffer( chooseSecretWord());
      knownSoFar = new StringBuffer( secretWord.length());
      
      for ( int i = 0; i < secretWord.length(); i++)
      {
         knownSoFar.append( "*");
      }
   }
   /*
    * This is a method that return all letters
    * @return allLetters
    * 
    */
   public StringBuffer getAllLetters(){
      return allLetters;
   }
   /*
    * This is a method that return all used letters
    * @return usedletters
    * 
    */
   public StringBuffer getUsedLetters(){
      return usedLetters;
   }
   
   /*
    * This is a method that return number of ýncorrect tries
    * @return numberOfIncorrectTries
    * 
    */
   public int getNumOfIncorrectTries(){
      return numberOfIncorrectTries;
   }
   
   /*
    * This is a method that return max allowed ýncorrect tries
    * @return maxAllowedIncorrectTries
    * 
    */
   public int getMaxAllowedIncorrectTries(){
      return maxAllowedIncorrectTries;
   }
   /*
    * This is a method that return letters known so far
    * @return knownSoFar
    * 
    */
   public StringBuffer getKnownSoFar(StringBuffer secretWord, String enteredLetter){
      for(int i = 0; i < secretWord.length(); i++){
         if(secretWord.charAt(i) == enteredLetter.charAt(0)){
            knownSoFar.deleteCharAt(i);
            knownSoFar.insert(i, enteredLetter);
         }
      }
      return knownSoFar;
   }
   
   /**
    * simply looks for the guessed letter in the secret word
    * @param the letter that the player guesses
    * @return 
    */
   public int tryThis( char letter )
   {
      //variablesada
      boolean existsInAllLetters;
      boolean existsInUsedLetters;
      int occurrence;
      
      //program code
      existsInAllLetters = false;
      existsInUsedLetters = false;
      occurrence = 0;
      
      //checks whether the game is over
      if ( isGameOver() )
         return -3;
      
      //checks whether the letter exists in english alphabet
      for (int n = 0; n < allLetters.length(); n++)
      {
         if ( letter == allLetters.charAt(n))
            existsInAllLetters = true;
      }
      if ( !existsInAllLetters )
         return -1;
      
      //checks whether the letter has been already used
      for ( int n = 0; n < usedLetters.length(); n++ )
      {
         if ( letter == usedLetters.charAt(n) )
            existsInUsedLetters = true;
      }
      if ( existsInUsedLetters )
         return -2;
      
      //counts the number of the occurrences of the letter in the secret word
      for ( int n = 0; n < secretWord.length(); n++ )
      {
         if ( letter == secretWord.charAt(n) )
            occurrence++;
      }
      
      //if it is an incorrect try increases the number of incorrrect tries
      if ( occurrence == 0 )
         numberOfIncorrectTries++;
      
      //returns the number of occurrences
      return occurrence;
   }
   
   
   /*
    * This is a method that return false if game is over
    * @return false
    * 
    */
   public boolean isGameOver(){
      String knownSoFarString;
      String secretWordString;
      knownSoFarString = knownSoFar.toString();
      secretWordString = secretWord.toString();
      if(numberOfIncorrectTries >= maxAllowedIncorrectTries || knownSoFarString.equals( secretWordString)){
         return true;
      }
      return false;
   }
   
   /*
    * This is a method that return false if game is lost
    * @return false
    * 
    */
   public boolean hasLost(){
      return numberOfIncorrectTries == maxAllowedIncorrectTries;
      
   }
   
   /**
    * choose secret word from fixed array
    * @return StrignBuffer choosen randomly from list
    */
   public StringBuffer chooseSecretWord( int a)
   {
      
      StringBuffer[] words;
      StringBuffer word;
      int number;
      
      words = new StringBuffer[5];
      
      words[0] = new StringBuffer( "sudden" );
      words[1] = new StringBuffer(  "table");
      words[2] = new StringBuffer( "value");
      words[3] = new StringBuffer( "right");
      words[4] = new StringBuffer( "human");
      
      number= (int) ( Math.random() * words.length );
      
      word= words[ number ];
      
      return word;
   }
   
   /**
    * choose secret word from a text
    * @return StringBuffer choosen randomly fom text
    */
   public StringBuffer chooseSecretWord()
   {
      ArrayList<String> list;
      String words;
      StringBuffer word;
      
      list = new ArrayList<String>();
      
      File testFile = new File("words.txt");
      
      // try/catch is used to prevent exception errors during compile
      try 
      {
         Scanner scan = new Scanner( testFile );
         
         while ( scan.hasNext() )
         {
            words = scan.next();
            list.add( words );
         }
      } catch ( FileNotFoundException e )
      {
         e.printStackTrace();
      }
      
      word = new StringBuffer ( list.get( (int) (Math.random() * list.size() ) ) );
      
      return word;
   }
   
   /**
    * A method that returns secretWord
    * @return secretWord
    */
   public StringBuffer returnSecretWord()
   {
      return secretWord;
   }
   
   /**
    * A method that returns usedLetters
    * @return usedLetters
    */
   public StringBuffer returnUsedLetters()
   {
      return usedLetters;
   }
}
