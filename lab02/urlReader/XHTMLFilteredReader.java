package urlReader;

import java.util.*;
import cs1.SimpleURLReader;

/**
 * A class that extends HTMLFilteredReader
 * @author Efe Beydo?an
 * @version 01.03.2020
 */
public class XHTMLFilteredReader extends HTMLFilteredReader
{
   // properties
   
   // constructors
   
   public XHTMLFilteredReader( String url)
   {
      super( url);
   }
   
   // methods
   
   /**
    * A method that gets the links from an HTML file
    * @return the links
    */
   public ArrayList<String> getLinks()
   {
      ArrayList<String> links;
      String unfiltered;
      int index;
      final int LINK_START_INDEX = 6;
      
      links = new ArrayList<String>();
      unfiltered = super.getUnfilteredPageContents();
      index = unfiltered.indexOf( "href");
      
      while ( index != -1)
      {
         links.add( unfiltered.substring( index + LINK_START_INDEX, unfiltered.indexOf( "\"", index + LINK_START_INDEX)));
         index = unfiltered.indexOf( "href", index + LINK_START_INDEX);
      }
      return links;
   }
   /**
    * Alternative getLinks method
    * @return links
    */
   public ArrayList<String> getLinksAlternative()
   {
      ArrayList<String> links;
      ArrayList<Integer> indexes;
      String unfiltered;
      int index;
      final int LINK_START_INDEX = 6;
      
      links = new ArrayList<String>();
      indexes = new ArrayList<Integer>();
      unfiltered = super.getUnfilteredPageContents();
      for ( int i = 0; i < unfiltered.length() - 3; i++)
      {
         if ( unfiltered.charAt( i) == 'h' && unfiltered.charAt( i+1) == 'r' && unfiltered.charAt( i+2) == 'e' && unfiltered.charAt( i+3) == 'f')
         {
            indexes.add(i);
         }
      }
      
      for ( int i = 0; i < indexes.size(); i++)
      {
         links.add( unfiltered.substring( indexes.get(i) + LINK_START_INDEX, unfiltered.indexOf( "\"", indexes.get(i) + LINK_START_INDEX)));
      }
      return links;
   }
   
   
   
   /**
    * A method that calculates the overhead between filtered and unfiltered page contents
    * @return the overhead
    */
   public String overhead()
   {
      double overhead;
      double htmlSize;
      double noHtmlSize;
      double difference;
      
      
      htmlSize = super.getUnfilteredPageContents().length();
      noHtmlSize = super.getPageContents().length();
      // Find the character difference between the unfiltered and filtered page contents 
      // and divide it by the filtered page contents, then multiply by 100 to find the percentage increase in size
      difference = htmlSize - noHtmlSize;
      
      overhead = ( difference / noHtmlSize) * 100;
      
      return overhead + "%";
   }
}