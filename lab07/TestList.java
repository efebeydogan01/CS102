import junit.framework.TestCase;
import cs102.ds.List;

/** A JUnit test case class.
  * Every method starting with the word "test" will be called when running
  * the test with JUnit.
  */
public class TestList extends TestCase {
   
   /** A test method.
     * (Replace "X" with a name describing the test.  You may write as
     * many "testSomething" methods in this class as you wish, and each
     * one will be called when running JUnit over this class.)
     */
   public void testPrint() {
      List list = createFrom( "david");
      System.out.println( list + " print test: ");
      list.print();
      System.out.println();
   }
   
   public void testRemoveFromHead() {
      List list = createFrom( "efk");
      System.out.println( list +  " removeFromHead test: ");
      list.removeFromHead();
      list.print();
      System.out.println();
   }
   
   public void testPrintReverse() {
      List list = createFrom( "cs102");
      System.out.println( list + " printReverse test: ");
      list.printReverse();
      System.out.println();
   }
   
   public void testIsOrdered() {
      System.out.println( "isOrdered test: ");
      List list = createFrom( "ABCDE");
      System.out.println( list + " is ordered: " + list.isOrdered());
      List list2 = createFrom( "EDCBA");
      System.out.println( list2 + " is ordered: " + list2.isOrdered());
      System.out.println();
   }
   
   public void testMerge() {
      System.out.println( "merge test: ");
      List list;
      List list2;
      String[] x = { "asd", "emir", "eren", "efe", "A", "B", "C"};

      list = createFrom( "ABCDEF");
      list2 = createFrom( x);
      System.out.println( "First list: " + list);
      System.out.println( "Second list: " + list2);
      list2 = List.merger( list, list2);
      System.out.println( "Merged list: " + list2);
      System.out.println();
   }
   
   public void testToString() {
      System.out.println( "toString test: ");
      List list;
      
      String[] x = { "asd", "emir", "eren", "efe", "A", "B", "C"};
      list = createFrom( x);
      System.out.println( list.toString());
      System.out.println();
   }
   
   public void testAddToTail() {
      System.out.println( "addToTail test: ");
      List list;
      
      list = createFrom( "ABCDEF");
      System.out.println( "list: " + list); 
      list.addToTail( "G");
      System.out.println( list);
      System.out.println();
   }
   
   public void testAddToHead() {
      List list;
      
      list = createFrom( "ABCDEF");
      System.out.println( list + " addToHead test: ");
      list.addToHead( "G");
      System.out.println( list);
      System.out.println();
   }
   
   public void testIsEmpty() {
      System.out.println( "isEmpty test: ");
      List list1;
      List list2;
      
      list1 = createFrom( "ABCDEF");
      list2 = new List();
      
      System.out.println( list1 + " is empty: " + list1.isEmpty());
      System.out.println( "is empty: " + list2.isEmpty());
      System.out.println();
   }
   
   public void testGetData() {
      List list;
      
      list = createFrom( "ABCDEF");
      
      System.out.println( list + " getData test (index 1) : " + list.getData( 1));
      System.out.println();
   }
   
   public void testContains() {
      List list;
      
      list = createFrom( "ABCDEF");
      System.out.println( "contains test");
      System.out.println( list + " contains A: " + list.contains( "A"));
      System.out.println( list + " contains G: " + list.contains( "G"));
      System.out.println();
   }
   
   
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
