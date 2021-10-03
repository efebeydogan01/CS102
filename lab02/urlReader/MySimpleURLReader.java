package urlReader;

import java.util.*;
import cs1.SimpleURLReader;

/**
 * A simple class that reads URLs
 * @author Efe Beydoðan
 * @version 01.03.2020
 */
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   private String url;
   
   // constructors 
   public MySimpleURLReader( String url)
   {
      super( url);
      this.url = url;
   }
   
   // methods 
   
   /**
    * A method that returns the URL of a page
    * @return the URL
    */
   public String getURL()
   {
      return url;
   }
   
   /**
    * A method that gets the name of a file from its URL
    * @return the name of the file
    */
   public String getName()
   {
      int index;
      String name;
      
      index = 0;
      // Find the index of the last / 
      for ( int i = url.length() - 1; i >= 0; i--)
      {
         if ( url.charAt(i) == '/')
         {
            index = i;
            i = 0;
         }
      }
      
      // Get the name using substring from the index of the last / to the end of the URL
      name = url.substring( index + 1, url.length());
      return name;
   }
   
   /**
    * A method that overrides getPageContents() from the super class to fix a bug
    * @return the page contents without bug
    */
   @Override
   public String getPageContents()
   {
      // Fix the bug by starting the URL from the 4th index
      return super.getPageContents().substring( 4, super.getPageContents().length());
   }
   
   
   
   
   
   
   
   
   
   
}