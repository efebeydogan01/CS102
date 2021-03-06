package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Efe Beydo?an
// date: 27.02.2020
public class Cards
{
   final int NOOFCARDSINFULLPACK = 52;
   
   // properties
   Card[] cards;
   int    valid;  // number of cards currently in collection
   
   // constructors
   public Cards( boolean fullPack)
   {
      cards = new Card[ NOOFCARDSINFULLPACK ];
      valid = 0;
      
      if ( fullPack)
         createFullPackOfCards();
   }
   
   // methods
   public Card getTopCard()
   {
      Card tmp;
      
      if ( valid <= 0)
         return null;
      else
      {
         valid--;
         tmp = cards[valid];
         cards[valid] = null;
         return tmp;
      }
   }
   
   public boolean addTopCard( Card c)
   {
      if ( valid < cards.length)
      {
         cards[valid] = c;   // should this be cloned?
         valid++;
         return true;
      }
      return false;
   }
   
   private void createFullPackOfCards()
   {
      for ( int i = 0; i < NOOFCARDSINFULLPACK; i++)
      {
         addTopCard( new Card(i));
      }
      shuffle();
   }
   
   public void shuffle()
   {
      Card temp;
      int randomIndex;
      
      randomIndex = (int) ( Math.random() * valid);
      
      // Swap the places of cards
      for ( int i = 0; i < valid; i++)
      {
         temp = cards[randomIndex];
         cards[randomIndex] = cards[i];
         cards[i] = temp;
         randomIndex = (int) ( Math.random() * valid);
      }
   }
   
   
   // For testOnly... remove from production version!
   public void testOnlyPrint()
   {
      for ( int i =0; i < valid; i++)
      {
         System.out.println( cards[i] );
      }
   }
   
} // end class Cards
