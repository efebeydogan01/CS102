import java.util.*;
import urlReader.*;

/**
 * A program to calculate currencies
 * @author Efe Beydoðan
 * @version 04.03.2020
 */

public class CurrencyCalculator
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      XHTMLFilteredReader currencyReader;
      String currencies;
      String input;
      int index;
      
      
      
      // program code
      
      currencyReader = new XHTMLFilteredReader( "https://www.tcmb.gov.tr/kurlar/today.xml");
      input = "";
      currencies = currencyReader.getPageContents();
      index = 0;
      
      do
      {
         // Present the user with the selections and ask for and get a selection
         System.out.println( "Please select a currency or write Quit to exit: ");
         System.out.println( "US DOLLAR, AUSTRALIAN DOLLAR, DANISH KRONE, EURO, POUND STERLING, SWISS FRANK \n");
         System.out.println( "SWEDISH KRONA, CANADIAN DOLLAR, KUWAITI DINAR, NORWEGIAN KRONE, SAUDI RIYAL, JAPENESE YEN \n");
         System.out.println( "BULGARIAN LEV, NEW LEU, RUSSIAN ROUBLE, IRANIAN RIAL, CHINESE RENMINBI, PAKISTANI RUPEE, QATARI RIAL");
         input = scan.nextLine();
         input = input.toUpperCase();
         
         // If index isn't "Quit" then continue
         if ( !input.equals( "Quit"))
         {
            index = currencies.indexOf( input);
            // If the entered string isn't found give a warning
            if ( index == -1)
            {
               System.out.println( "Doesn't exist!");
            }
            else
            {
               // If the input is EURO then get it's currency values
               if ( input.equals( "EURO"))
               {
                  System.out.println( input + " is" + currencies.substring( index + 14 , index + 20 ) + " Turkish liras \n"); 
               }
               
               // If the input is not EURO then get the currency values
               else
               {
                  System.out.println( input + " is" + currencies.substring( index + (input.length() - 1) + 4 , index + (input.length() - 1) + 9) + " Turkish liras \n");
               }
            }
         }
         
      } while ( !input.equals( "Quit"));
      
      
      
   }
   
}