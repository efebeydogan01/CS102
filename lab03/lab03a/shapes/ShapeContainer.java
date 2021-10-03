package shapes;

import java.util.*;

/**
 * A class that contains shapes
 * @author Efe Beydoðan
 * @version 08.03.2020
 */
public class ShapeContainer
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
      Selectable selectable;
      for ( int i = 0; i < shapes.size(); i++)
      {
         selectable = (Selectable) shapes.get(i);
         if ( selectable.contains( x, y) != null)
         {
            return (Shape) selectable;
         }
      }
      return null;
   }
   
   /**
    * A method that removes a shape if it is selected
    */
   public void removeSelected()
   {
      Selectable x;
      for ( int i = 0; i < shapes.size(); i++)
      {
         x = (Selectable) shapes.get(i);
         if ( x.getSelected())
         {
            shapes.remove(i);
            i--;
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
   
   
   
}