package bagInt;

import java.util.Iterator;

public class IntBagIterator implements Iterator
{
   // properties
   private IntBag aBag;
   private int index;
   
   // constructors 
   public IntBagIterator( IntBag aBag)
   {
      this.aBag = aBag;
      index = 0;
   }
   
   // methods
   
   public Integer next()
   {
      if ( hasNext())
      {
         index++;
         return aBag.get(index - 1);
      }
      else
      {
         return null;
      }
   }
   
   public boolean hasNext()
   {
      return index < aBag.size();
   }
}