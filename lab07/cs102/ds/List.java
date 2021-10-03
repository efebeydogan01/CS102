package cs102.ds;

/**
 * A simple list class
 * @author Efe Beydoðan
 * @version 10.05.2020
 */

public class List {
   
   // properties
   private Node head;
   
   
   // constructors
   
   public List() {
      head = null;
   }
   
   // methods
   
   /**
    * A method to add a new value to the start of the list
    * @param item the data of the new element that will be added to the list
    */
   public void addToHead( String item) {
      // Create a new node with the given parameter and add it to the start of the list
      head = new Node( item, head);
   }
   
   /**
    * A method to add a new value to the end of the list
    * @param item the data of the new element that will be added to the list
    */
   public void addToTail( String item) {
      
      Node tmp;
      
      tmp = head;
      
      // Do this only if the list is not empty
      if ( !isEmpty()) {
         // Add the element to the end of the list
         tail().next = new Node( item, null);
      }
      // If the list is empty just add the new element to the start of the list
      else {
         addToHead( item);
      }
   }
   
   /**
    * A method that shows if the list is empty or not
    * @return whether the list is empty or not
    */
   public boolean isEmpty() {
      return this.head == null;
   }
   
   /**
    * A method to remove the first element in the list
    * @return the data of the first element
    */
   public String removeFromHead() {
      String tmp;
      // If the list is not empty get the data of the first element and replace the first element
      if ( !isEmpty()) {
         tmp = head.data;
         head = head.next;
         // Return the first element's data
         return tmp;
      }
      // If the list is empty return null
      return null;
   }
   
   /**
    * A method to receive a string at a specified index
    * @param index the index at which the desired string is located
    * @return the string at the index
    */
   public String getData( int index) {
      Node tmp;
      
      // Do this if index is valid and the list isn't empty
      if ( !isEmpty() && index >= 0) {
         tmp = head;
         // Look at all the elements until the index
         for ( int i = 0; i < index; i++) {
            if ( tmp != null) {
               tmp = tmp.next;
            }
            // If any element until the index is null than the end of the list is reached and the element is not in the list
            else {
               return null;
            }
         }
         // Return the element if it is found in the list
         return tmp.data;
      }
      // Return null if the list is empty or the index is not valid
      return null;
   }
   
   /**
    * A method to print all the elements in the list
    */
   public void print() {
      Node tmp;
      
      tmp = head;
      // Print all the elements until the end of the list is reached
      while ( tmp != null) {
         System.out.println( tmp.data);
         tmp = tmp.next;
      }
   }
   
   /**
    * A method to print all the elements in the list in reverse order
    */
   public void printReverse()
   {
      printReverse( tail() );
   }
   
   /**
    * A method to print all the elements in the list in reverse order from a specific node
    * @param lastNode the node to start printing from
    */
   public void printReverse( Node lastNode) {
      if ( lastNode != null) {
         System.out.println( lastNode.data);
         printReverse( previous( lastNode));
      }
   }
   
   /**
    * A method to check if a string is contained in the list
    * @param target the string to be checked
    * @return whether the list contains the element or not
    */
   public boolean contains( String target) {
      Node tmp;
      
      tmp = head;
      
      // Do this until the last element of the list is reached
      while ( tmp != null) {
         // If the element is found in the list return true
         if ( tmp.data.equals( target)) {
            return true;
         }
         // If the element is not present return false
         else {
            tmp = tmp.next;
         }
      }
      // Return false if the list is empty
      return false;
   }
   
   /**
    * A method to check if all the strings in a list are lexigoraphically ordered
    * @return whether the strings are in order or not
    */
   public boolean isOrdered() {
      Node tmp;
      
      tmp = head;
      
      // If the list is not empty
      if ( !isEmpty()) {
         // Compare every string until the last element
         while ( tmp.next != null) {
            if ( tmp.data.compareTo( tmp.next.data) > 0) {
               return false;
            }
            else {
               tmp = tmp.next;
            }
         }
         return true;
      }
      // If the list is empty return true
      return true;
   }
   
   public static List merger( List a, List b)
   {
      List merged;
      merged = new List();
      
      // while the first element isn't null
      while ( a.head != null) {
         // if an element is common for both lists, remove it
         if ( b.remove( a.head.data) != null) {
            a.removeFromHead();
         }
         // else add the first element in list a to the merged list
         else {
            merged.addToTail( a.removeFromHead() );
         }
      }
      // add the lists that contain elements which are not common in both lists
      merged.tail().next = b.head;
      return merged;
   }
   
   
   
   // helper methods
   
   /**
    * A method to get the previous node
    * @param n the node to get the previous of
    * @return the previous node
    */
   private Node previous( Node n) {
      Node tmp;
      
      tmp = head;
      // If the node is the first node in the list or the list is empty return null
      if ( n == head || isEmpty()) {
         return null;
      }
      // Look at every node until the given node is reached
      while ( tmp.next != n) {
         if ( tmp.next == null) {
            return null;
         }
         tmp = tmp.next;
      }
      return tmp;
   }
   
   /**
    * A method to get the last element in the list
    * @return the last node in the list
    */
   private Node tail() {
      Node tmp;
      
      tmp = head;
      // If the list is not empty look at the nodes
      if ( !isEmpty()) {
         // While the last element isn't reached
         while ( tmp.next != null) {
            tmp = tmp.next;
         }
         // Stop when the last element is reached
         return tmp;
      }
      // If the list is empty return null
      else
         return null;
   } 
   
   /**
    * A method to remove a particular element with a given data
    * @param s the string that the element that must be removed contains
    * @return the removed element's data
    */
   private String remove( String s) {
      Node tmp;
      
      tmp = head;
      // If the list is not empty look at the elements
      if ( !isEmpty()) {
         // Stop if the last element is reached and the required element isn't found
         while ( tmp != null) {
            // If the required element is the first in the list than remove it and return its data
            if ( tmp == head) {
               if ( tmp.data.equals( s)) {
                  return removeFromHead();
               }
            }
            // Else if the element isn't the head and another element's data is equal to the one than remove it from the list
            else if ( tmp != head && tmp.data.equals( s)) {
               previous( tmp).next = tmp.next;
               return tmp.data;
            }
            tmp = tmp.next;
         }
      }
      // If the list empty simply return null
      return null;
   }
   /**
    * toString method
    * @return the string representation of the list
    */
   public String toString() {
      String s;
      Node tmp;
      
      s = "[ ";
      tmp = head;
      // If the list is not empty add every element's data to tje string
      if ( !isEmpty()) {
         
         while ( tmp.next != null) {
            s = s + tmp.data + ", ";
            tmp = tmp.next;
         }
      }
      
      s = s + tmp.data;
      
      s = s + " ]";
      
      return s;
   }
   
   
   
   // inner class
   
   private class Node {
      
      // properties
      String data;
      Node next;
      
      // constructors
      public Node( String data, Node next) {
         this.data = data;
         this.next = next;
      }
   }
}