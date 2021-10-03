package bagInt;
import java.util.Iterator;


/**
 * An IntBag class
 * @author Efe Beydoðan
 * @version 15.02.2019
 */

public class IntBag
{
   //properties
   int[] bag;
   int valid;
   
   //constructors
   public IntBag()   
   {
      bag = new int[100];
      valid = 0;
   }
   
   public IntBag( int desiredElements)
   {
      bag = new int[desiredElements];
      valid = 0;
   }
   
   //methods
   
   /**
    * A method that adds a desired int value to the end of the array
    * @param addInt the int that is added to the array
    */
   public void add( int addInt)
   {
      if ( valid >= bag.length)
      {
         System.out.println( "Array doesn't have more room!");
      }
      else
      {
         bag[valid] = addInt;
         valid++;
      }
   }
   
   /**
    * A method that adds an int value to a specific index 
    * @param addInt the integer that is added to the array
    * @param index the index that the integer is added to
    */
   public void add( int addInt, int index)
   {
      if ( valid - 1 < index)
      {
         System.out.println( "Index is not within bounds!");
      }
      else
      {
         valid++;
         for ( int i = valid; i > index; i--)
         {
            bag[i] = bag[i-1];
         }
         bag[index] = addInt;
      }
   }
   
   /**
    * A method that removes the element at a specified index
    * @param index the index of the element that is removed
    */
   public void remove( int index)
   {
      for ( int i = index;  i < valid; i++)
      {
         bag[i] = bag[i+1];
      }
      valid--;
   }
   
   /**
    * A method that shows if an element is contained in the array
    * @param the value that is searched in the array
    * @return whether the array contains an element or not
    */
   public boolean contains( int value)
   {
      for ( int i = 0; i < valid; i++)
      {
         if ( bag[i] == value)
         {
            return true;
         }
      }
      return false;
   }
   
   /**
    * A method that returns bag array as a string
    * @return the bag array as a string
    */
   public String toString()
   {
      String arrayString;
      arrayString = "Elements: ";
      for ( int i = 0; i < valid; i++)
      {
         arrayString = arrayString + bag[i] + " ";
      }
      return arrayString;
   }
   
   /**
    * A method that shows the amount of relevant integers in the bag
    * @return the valid elements
    */
   public int size()
   {
      return valid;
   }
   
   /**
    * A method that gets the element at a specified index
    * @param the index of the desired element
    * @return the element at the specified index
    */
   public int get( int index)
   {
      return bag[index];
   }
   
   public IntBag findAll( int num)
   {
      IntBag index;
      index = new IntBag();
      
      for ( int i = 0; i < valid; i++)
      {
         if ( bag[i] == num)
         {
            index.add( i);
         }
      }
      return index;
   }
   
   public Iterator iterator()
   {
      return new IntBagIterator( this);
   }
   
   
   // Inner class 
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
}
