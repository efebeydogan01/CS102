package urlReader;

import java.util.*;
import cs1.SimpleURLReader;

/**
 * A class that filters HTML code from URLs
 * @author Efe Beydoðan
 * @version 01.03.2020
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   // properties
   
   // constructors
   
   public HTMLFilteredReader( String url)
   {
      super( url);
   }
   
   // methods
   
   /**
    * A method that gets page contents with HTML code
    * @return the page contents with HTML code
    */
   public String getUnfilteredPageContents()
   {
      return super.getPageContents();
   }
   
   /**
    * A method that gets page contents without the HTML code in it
    * @return filtered page contents without the HTML code
    */
   @Override
   public String getPageContents()
   {
      String filtered;
      String unfiltered;
      
      filtered = "";
      unfiltered = super.getPageContents();
      
      for ( int i = 0; i < unfiltered.length() - 2; i++)
      {
         if ( unfiltered.charAt( i) == '>')
         {
            while ( unfiltered.charAt( i+1) != '<')
            {
               filtered += unfiltered.charAt( i+1);
               i++;
            }
         }
      }
      filtered = filtered.replaceAll( "&nbsp" , " ");
      filtered = filtered.replaceAll( "&quot;" , "\"");
      filtered = filtered.replaceAll( "&amp;" , "&");
      return filtered;
   }
}