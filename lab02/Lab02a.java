import java.util.*;
import cs1.SimpleURLReader;
import urlReader.*;
   
/**
 * A program that tests classes
 * @author Efe Beydo?an
 * @version 01.03.2020
 */
public class Lab02a
{
   public static void main( String[] args)
   {
      SimpleURLReader url = new SimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt");
      MySimpleURLReader reader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt");
      HTMLFilteredReader filtered = new HTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/housman.htm");
      XHTMLFilteredReader links = new XHTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/index.html");
      
      // constants
      
      // variables
      
      // program code
      
      // PART A
      System.out.println( "PART A");
      // Print page contents
      System.out.println( "Page contents using SimpleURLReader: \n" +  url.getPageContents());
      
      // Get line count
      System.out.println( "Line count: \n" + url.getLineCount() + "\n");
      
      // PART B
      System.out.println( "PART B");
      // getURL() method
      System.out.println( "getUrl() method using MySimpleURLReader: \n" + reader.getURL());
      
      // getName() method
      System.out.println( "getName(): \n" + reader.getName());
      System.out.println();
      
      // Page contents using MySimpleURLReader
      System.out.println( "getPageContents without bug: \n\n" + reader.getPageContents());
      
      // PART C
      System.out.println( "PART C");
      System.out.println();
      System.out.println( "filtered: " + filtered.getPageContents());
      System.out.println(); 
      
      // PART D
      System.out.println( "PART D");
      System.out.println( "Links: " + links.getLinks());
      
      System.out.println( "Overhead: " + links.overhead());
      
      System.out.println( "getLinks() alternative: " + links.getLinksAlternative());
      
      //links = (XHTMLFilteredReader) filtered;
      //System.out.println( "Links: " + links.getLinks());
      
      //System.out.println( links.getURL());
      
      
      
   }
}