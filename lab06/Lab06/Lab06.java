import java.util.*;

/**
 * Lab06 class
 * @author Efe Beydo?an
 * @version 25.04.2020
 */
public class Lab06
{
   /**
    * A recursive method that finds the number of occurences of the letter e in a string
    * @param index the starting index
    * @param x the string
    * @return the number of occurences of e
    */
   public static int eOccurence( int index, String x)
   {
      // When index is smaller than the length of the string call the method continuously
      if ( index < x.length())
      {
         int count;
         count = eOccurence( index + 1, x);
         
         // If the character is e than increment count
         if ( x.charAt( index) == 'e' || x.charAt( index) == 'E')
         {
            count++;
         }
         return count;
      }
      else
      {
         // When the index is equal to the length of the string create a variable
         int i;
         i = 0;
         return i;
      }
   }
   
   /**
    * A recursive method that converts a decimal number to binary
    * @param decimal the decimal number to be converted to binary
    */
   public static void toBinary( int decimal)
   {
      if ( decimal > 0)
      {
         // Start from the most significant digit and write the number in binary form
         toBinary( decimal / 2);
         System.out.print( decimal % 2);
      }
   }
   
   /**
    * A recursive method that returns if strings are in lexigrophical order or not
    * @param stringArray an Arraylist of strings
    * @param index the start index
    * @return whether the strings are in lexigrophical order or not
    */
   public static boolean inOrder( ArrayList<String> stringArray, int index)
   {
      // If an invalid index is entered return false
      if ( index < 0)
      {
         return false;
      }
      // When the index is equal to zero return true because for only one element the strings must be ordered
      else if ( index == 0)
      {
         return true;
      }
      else
      {
         // Make the method call itself and when index reaches 0, it will return true
         // then it will compare every string with the next string in the array
         // and return whether they're alphabetically ordered or not
         return inOrder( stringArray, index - 1) && stringArray.get( index).compareTo( stringArray.get( index - 1)) >= 0;  
      }
   }
   
   /**
    * A method that prints all n digit numbers that meet certain criteria
    * @param n the number of digits
    */
   public static void digitNums( int n)
   {
      // Print all the n digit numbers
      printNums( (int) Math.pow( 10, n - 1), (int) Math.pow( 10, n) - 1); 
   }
   
   // HELPER METHODS
   
   /**
    * A recursive method that checks if a numbers digits are in order
    * @param n the number to be checked
    * @return if the digits are in increasing order or not
    */
   public static boolean digitsIncrease( int n)
   {
      // When the division is zero return true
      if ( n / 10 == 0)
      {
         return true;
      }
      else
      {
         // Check every digit to see if they are in increasing order from the most significant to least significant digit
         return ( n % 10 ) > ( ( n / 10) % 10) && digitsIncrease( n / 10);
      }
   }
   
   /**
    * A method that checks if a numbers digits are in increasing order and the number is even
    * @param n the number to be checked
    * @return if the number meets the criteria
    */
   public static boolean meetsCriteria( int n)
   {
      return digitsIncrease( n) && ( n % 2 == 0);
   }
   
   /**
    * A recursive method that prints numbers that meet the criteria
    * @param num the current number
    * @param lastNum the last number to be checked
    */
   public static void printNums( int num, int lastNum)
   {
      // Stop if the smaller number exceeds the bigger number
      if ( num > lastNum)
      {
         return;
      }
      // If the number meets the criteria print it
      else if ( meetsCriteria( num))
      {
         System.out.println( num);
      }
      // Only check even numbers
      printNums( num + 2, lastNum);
   }
   
   
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      // constants
      
      // variables
      String x;
      int decimal;
      ArrayList<String> ordered;
      ArrayList<String> notOrdered;
      final int digit = 5;
      
      // program code
      x = "Efe";
      System.out.print( "Number of occurences of e in " + x + ": " );
      System.out.println( eOccurence( 0, x));
      
      System.out.println();
      
      System.out.println( "Decimal to binary: ");
      System.out.println( "Enter a decimal number: ");
      decimal = scan.nextInt();
      System.out.print( decimal + " to binary is: ");
      toBinary( decimal);
      
      System.out.println();
      System.out.println();
      
      ordered = new ArrayList<String>();
      ordered.add( "A");
      ordered.add( "B");
      ordered.add( "C");
      ordered.add( "D");
      System.out.println( ordered + " is ordered: " + inOrder( ordered, 3));
      
      notOrdered = new ArrayList<String>();
      notOrdered.add( "A");
      notOrdered.add( "B");
      notOrdered.add( "D");
      notOrdered.add( "C");
      System.out.println( notOrdered + " is ordered: " + inOrder( notOrdered, 3));
      
      System.out.println();
      
      System.out.println( "All " + digit + " digit numbers that meet the criteria: ");
      digitNums( digit);
   }
}