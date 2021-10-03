package shapes;

import java.util.*;

/**
 * A class that contains shapes
 * @author Efe Beydoðan
 * @version 05.04.2020
 */
public class ShapeContainer implements Iterable
{
   // properties
   private ArrayList<Shape> shapes;
   
   // constructors
   public ShapeContainer()
   {
      shapes = new ArrayList<Shape>();
   }
   
   // methods
   
   /**
    * A method that adds a shape to the ArrayList
    * @param s the shape to be added
    */
   public void add(Shape s)
   {
      shapes.add( s);
   }
   
   /**
    * A method that gets the total area of all the shapes
    * @return the total area of the shapes
    */
   public double getArea()
   {
      double totalArea;
      totalArea = 0;
      for ( Shape s : shapes)
      {
         totalArea = totalArea + s.getArea();
      }
      return totalArea;
   }
   
   /**
    * toString method
    * @return string
    */
   public String toString()
   {
      String string;
      string = "";
      for ( Shape s : shapes)
      {
         string = string + s.toString() + "\n";
      }
      return string;
   }
   
   /**
    * A method that returns the size of the ArrayList
    * @return the size of the ArrayList
    */
   public int getSize()
   {
      return shapes.size();
   }
   
   /**
    * A method that finds a shape which contains a specified point
    * @param x the x component
    * @param y the y component
    * @return the shape or null if it doesn't exist
    */
   public Shape findShape( int x, int y)
   {
      for ( Shape s : shapes)
      {
         if ( s.contains( x, y) != null)
         {
            s.setSelected( !s.getSelected());
            return s;
         }
      }
      return null;
   }
   
   /**
    * A method that removes a shape if it is selected
    */
   public void removeSelected()
   {
      for ( int i = 0; i < shapes.size(); i++)
      {
         if ( shapes.get(i).getSelected())
         {
            shapes.remove(i);
         }
      }
   }
   
   /**
    * A method that returns the last shape in the container or null if there are no objects
    * @return the last shape in the container
    */
   public Shape lastShape()
   {
      if ( shapes.size() == 0)
      {
         System.out.println( "No shapes in the container!");
         return null;
      }
      else
      {
         return shapes.get( shapes.size() - 1);
      }
   }
   
   /**
    * A method that returns the number of shapes in the ArrayList
    * @return the size of the array
    */
   public int size()
   {
      return shapes.size();
   }
   
   /**
    * A method that returns the number of shapes that contain a certain point
    * @param x the x component
    * @param y the y component
    * @return the number of shapes
    */
   public int selectAllAt( int x, int y)
   {
      int number;
      number = 0;
      
      for ( int i = 0; i < shapes.size(); i++)
      {
         if ( shapes.get(i).contains( x, y) != null)
         {
            number++;
            shapes.get(i).setSelected( true);
         }
      }
      return number;
   }

   public Iterator iterator()
   {
      return this.shapes.iterator();
   }
}