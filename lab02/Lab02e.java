import java.util.*;
import urlReader.*;

/**
 * A program that presents the user with a menu and lets them view poems without HTML code
 * @author Efe Beydoðan
 * @version 01.03.2020
 */
public class Lab02e
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      // constants
      
      // variables
      String option;
      int poem;
      ArrayList<MySimpleURLReader> collection;
      String url;
      MySimpleURLReader simple;
      HTMLFilteredReader html;
      
      
      // program code
      
      collection = new ArrayList<MySimpleURLReader>();
      
      do
      {
         System.out.println( "=========================================================");
         System.out.println( "Press 1 to enter the url of the poem to add to collection");
         System.out.println( "Press 2 to list all poems in the collection");
         System.out.println( "Press 3 to quit");
         System.out.println( "=========================================================");
         
         System.out.println( "Make a selection: ");
         option = scan.next();
         
         if ( option.equals( "1"))
         {
            // Ask for and get the URL from the user
            System.out.println( "Enter the URL: ");
            url = scan.next();
            
            
            // If there is "txt" string, add it as a txt file
            if ( url.indexOf( "txt") >= 0)
            {
               simple = new MySimpleURLReader( url);
               collection.add( simple);
            }
            // Else if there is "htm" string, add it as html
            else if ( url.indexOf( "htm") >= 0)
            {
               html = new HTMLFilteredReader( url);
               collection.add( html);
            }
            // If the user doesn't enter a valid URL, give a warning
            else
            {
               System.out.println( "Enter a valid URL!");
            }
         }
         
         else if  ( option.equals( "2"))
         {
            // If there are no poems in the collection then show a warning to the user
            if ( collection.size() == 0)
            {
               System.out.println( "There are no poems in the collection!");
            }
            else
            {
               do
               {
                  // Print all the poems' indexes and names
                  for ( int i = 0; i < collection.size(); i++)
                  {
                     System.out.println( "Index no: " + i + " Name: " + collection.get( i).getName());
                  }
                  // Ask for and get an index number from the user
                  System.out.println( "Please select a poem by entering the index number or enter \"last index + 1\" to exit: ");
                  poem = scan.nextInt();
                  
                  // If the entered index isn't equal to the final index + 1 and it's a valid index, show the poem
                  if ( poem != collection.size() && poem < collection.size())
                  {
                     System.out.println( "The selected poem: \n");
                     System.out.println( collection.get( poem).getPageContents());
                  }
                  // If the entered index exceeds collection.size() then give a warning
                  else if ( poem > collection.size())
                  {
                     System.out.println( "Enter a valid index to view a poem or enter last index + 1 to exit!");
                  }
                  
               } while ( poem != collection.size()); // Exit the loop when user enters collection.size()
            }
         }
         
         // If user doesn't select 1,2 or 3 give a warning
         else if ( !option.equals( "3"))
         {
            System.out.println( "Invalid selection!");
         }
         
      } while ( !option.equals( "3")); // Exit when the user enters 3
      
      System.out.println( "You quit");
   }
}