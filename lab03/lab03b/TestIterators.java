import java.util.Iterator;
import bagInt.IntBag;
import bagInt.IntBagIterator;
import bagInt.IntIterator;

public class TestIterators
{
   public static void main( String[] args)
   {
      
      // variables
      IntBag bag;
      
      // program code
      bag = new IntBag();
      
      bag.add( 1);
      bag.add( 2);
      bag.add( 3);
      bag.add( 4);
      bag.add( 5);
      
      
      Iterator i, j;
      
      i = new IntBagIterator( bag);
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
         //j = new IntBagIterator( bag);
         j = bag.iterator();
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
}


