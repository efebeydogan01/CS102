import java.util.*;

/**
 * Recursion exercises
 * @author Efe Beydo?an
 * @version 25.04.2020
 */
public class Exercise01 
{
   /**
    * A recursive method that prints an array
    * @param i the starting index
    * @param j the ending index
    * @param arr the array
    */
   public static void printForward( int i, int j, int[] arr)
   {
      if ( i >= j)
      {
         System.out.println( arr[j]);
         return;
      }
      else
      {
         System.out.println( arr[i]);
         i++;
         printForward( i, j, arr);
      }
   }
   
   /**
    * A recursive method that prints an array in reverse
    * @param i the ending index
    * @param j the starting index
    * @param arr the array
    */
   public static void printReverse( int i, int j, int[] arr)
   {
      if ( j <= i)
      {
         System.out.println( arr[i]);
         return;
      }
      else
      {
         System.out.println( arr[j]);
         j--;
         printReverse( i, j, arr);
      }
   }
   
   /**
    * A recursive method that returns power
    * @param x the number that will be raised to a power
    * @param y the power
    * @return x to the power y
    */
   public static double power( double x, int y)
   {
      if ( y < 0)
      {
         return 1/x * power( 1/x, -y - 1);
      }
      if ( y == 0)
      {
         return 1;
      }
      else
      {
         return x * power( x, y - 1);
      }
   }
   
   /**
    * A recursive method that returns the max element in an array
    * @param n the indexes of the values to be compared
    * @param arr the array
    * @return the max element
    */
   public static int max( int n, int[] arr)
   {
      if ( n == 0)
      {
         return arr[0];
      }
      else
      {
         return Math.max( arr[n], max( n - 1, arr));
      }
   }
   
   /**
    * A recursive method that adds all the elements to an ArrayList
    * @param s the starting index
    * @param e the ending index
    * @param arr the array
    * @return an ArrayList containing all the elements
    */
   public static ArrayList<Integer> addList( int s, int e, int[] arr)
   {
      if ( s <= e)
      {
         ArrayList<Integer> list;
         list = addList( s, e - 1, arr);
         list.add( arr[e]);
         return list;
      }
      else
      {
         return new ArrayList<Integer>();
      }
   }
   
   /**
    * A recursive method that finds the first instance of an element in an array
    * @param x the array
    * @param target the target value
    * @param n the starting index
    * @return the first index the target value is found
    */
   public static int firstInstance( int[] x, int target, int n)
   {
      if ( n > x.length - 1)
      {
         return -1;
      }
      else
      {
         if ( x[n] == target)
         {
            return n;
         }
         return firstInstance( x, target, n + 1);
      }
   }
   
   /**
    * A recursive method that finds the last instance of an element in an array
    * @param x the array
    * @param target the target value
    * @param n the starting index
    * @return the last instance of the value
    */
   public static int lastInstance( int[] x, int target, int n)
   {
      if ( n < 0)
      {
         return -1;
      }
      else
      {
         if ( x[n] == target)
         {
            return n;
         }
         return lastInstance( x, target, n - 1);
      }
   }
   
   /**
    * A recursive method that finds all the instances of a target value in an array
    * @param x the array
    * @param target the target value
    * @param n the starting index
    * @return an ArrayList that contains all the instances
    */
   public static ArrayList<Integer> allInstances( int[] x, int target, int n)
   {
      if ( 0 <= n)
      {
         ArrayList<Integer> instances;
         instances = allInstances( x, target, n - 1);
         
         if ( x[n] == target)
         {
            instances.add( n);
         }
         
         return instances;
      }
      else
      {
         return new ArrayList<Integer>();
      }
   }
   
   
   
   public static void main( String[] args)
   {
      // constants
      final int FIRST = 2;
      final int LAST = 3;
      
      // variables
      int[] arr = {3,4,7,3,2};
      
      // program code
      
      System.out.println( "printForward:");
      printForward( 0, arr.length - 1, arr);
      
      System.out.println( "printReverse:");
      printReverse( 0, arr.length - 1, arr);
      
      System.out.println( "power: ");
      System.out.println( power( 3, -4));
      
      System.out.println( "max: ");
      System.out.println( max( 2, arr));
      
      System.out.println( "addList:");
      System.out.println( addList( 0, arr.length - 1, arr));
      
      System.out.println( "firstInstance of " + FIRST + ": ");
      System.out.println( firstInstance( arr, FIRST, 0));
      
      System.out.println( "lastInstance of " + LAST + ": ");
      System.out.println( lastInstance( arr, LAST, arr.length - 1));
      
      System.out.println( "allInstances: ");
      System.out.println( allInstances( arr, 3, arr.length - 1));
   }
}