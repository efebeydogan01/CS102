import java.util.*;
import bagInt.IntBag;

public class PrimeNum
{
   public static void main( String[] args)
   {
      //variables
      IntBag prime;
      int test;
      //program code
      prime = new IntBag();
      
      prime.add( 2);
      
      //Set test to 3 because we will check values after 3
      test = 3;
      //Stop when the size reaches 100 because the array can hold 100 elements
      while ( prime.size() < 100)
      {
         //Check with every prime number in the array bag
         for ( int i = 0; i < prime.size(); i++)
         {
            if ( test % prime.get(i) == 0)
            {
               //Add the 2 to the test value since a prime bigger than 2 must be an odd integer
               test = test + 2;
               //This way it checks all the values in the array
               i = -1;
            }
         }
         prime.add( test);
         test = test + 2;
      }
      System.out.println( prime);
   }
}