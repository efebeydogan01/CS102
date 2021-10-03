import cs102.ds.List;

/**
 * A class to test the List class
 * @author Efe Beydoðan
 * @version 10.05.2020
 */


public class ListTest {
   
   public static List createFrom( String[] testData) {
      List list;
      list = new List();
      for ( int i = 0; i < testData.length; i++) {
         list.addToTail( testData[i]);
      }
      return list;
   }
   
   public static List createFrom( String testData) {
      List list;
      list = new List();
      for ( int i = 0; i < testData.length(); i++) {
         list.addToTail( String.valueOf( testData.charAt( i)));
      }
      return list;
   }
   
   public static void main( String[] args) {
      
      
      
      
   }
   
   
   
   
}