import java.util.*;
import bagInt.IntBag;

public class IntMenu
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      //variables
      IntBag bag;
      int option;
      int capacity;
      int value;
      int location;
      IntBag indexes;
      int testValue;
      
      //program code
      bag = new IntBag();
      testValue = -1;
      value = 0;
      indexes = new IntBag();
      capacity = 0;
      
      do
      {
         //Print this menu until 9 is entered as input
         System.out.println( "========================================================================================================================");
         System.out.println( "1. Create a new empty collection with a specified maximum capacity (any previous values are lost!)");
         System.out.println( "2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)");
         System.out.println( "3. Print the collection of values.");
         System.out.println( "4. Add a value to the collection of values at a specified location");
         System.out.println( "5. Remove the value at a specified location from the collection of values");
         System.out.println( "6. Read a single test value.");
         System.out.println( "7. Compute the set of locations of the test value within the collection");
         System.out.println( "8. Print the set of locations.");
         System.out.println( "9. Quit the program.");
         System.out.println( "Please choose a menu option: ");
         System.out.println( "========================================================================================================================");
         option = scan.nextInt();
         
         //If this option is selected, create an IntBag with specified capacity
         if ( option == 1)
         {
            System.out.println( "Please enter the capacity of the integer bag: ");
            capacity = scan.nextInt();
            bag = new IntBag( capacity);
         }
         if ( option == 2)
         {
            //For the first input, set value to that input if it's an integer
            if ( scan.hasNextInt())
            {
               value = scan.nextInt();
            }
            //If the first input is a positive integer, add it to the IntBag and keep asking for input until a negative integer is entered and add them to the bag
            while ( value >= 0)
            {
               bag.add( value);
               if (scan.hasNextInt())
               {
                  value = scan.nextInt();
               }
            }
         }
         //Print the contents of the bag if this is selected
         if ( option == 3)
         {
            System.out.println( bag);
         }
         //If this is selected add the desired integer to the desired index
         if ( option == 4)
         {
            if ( bag.size() == capacity)
            {
               System.out.println( "You can't add more elements!");
            }
            else
            {
            System.out.println( "Please enter the value you want to add: ");
            value = scan.nextInt();
            System.out.println( "Please enter the index: ");
            location = scan.nextInt();
            bag.add( value, location);
            }
         }
         //Remove the element at the given index
         if ( option == 5)
         {
            System.out.println( "Please enter the index of the element you want to remove: ");
            location = scan.nextInt();
            bag.remove( location);
         }
         //Ask the user for a test value
         if ( option == 6)
         {
            System.out.println( "Please enter a test value: ");
            testValue = scan.nextInt();
         }
         //Find all the indexes of the given test value in option 6
         if ( option == 7)
         {
            if ( testValue == -1)
            {
               System.out.println( "Enter a test value by selecting 6 first!");
            }
            else
            {
            indexes = bag.findAll( testValue);
            }
         }
         //Print all the indexes of the given test value in option 6
         if ( option == 8)
         {
            if ( testValue == -1)
            {
               System.out.println( "Enter a test value by selecting 6 first!");
            }
            else
            {
            System.out.println( "All the indexes of " + testValue + " are " + indexes);
            }
         }
         //Quit the program if this is selected
         if ( option == 9)
         {
            option = option;
         }
      } while ( option != 9);
      
      System.out.println( "You quit");
   }
}