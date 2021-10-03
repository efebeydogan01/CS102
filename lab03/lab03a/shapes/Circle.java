package shapes;

import java.util.*;

/**
 * A circle class
 * @author Efe Beydoðan
 * @version 08.03.2020
 */
public class Circle extends Shape implements Selectable
{
   // properties
   private int radius;
   private boolean selected;
   
   // constructors
   public Circle( int radius)
   {
      this.radius = radius;
      selected = false;
   }
   // methods
   
   /**
    * A method that gets area
    * @return the area
    */
   public double getArea()
   {
      double area;
      area = Math.PI * radius * radius;
      area = area * 100;
      area = Math.round( area);
      area = area / 100;   
      return area;
   }
   
   /**
    * To string method
    * @return toString
    */
   public String toString()
   {
      return "The circle with center at (" + this.getX() + "," + this.getY() + ") has radius " + radius + " and area " + this.getArea() + " selected: " + this.getSelected();
   }
   
   /**
    * Shows if it is selected
    * @return selected or not
    */
   public boolean getSelected()
   {
      return selected;
   }
   
   /**
    * A method that toggles selected
    * @param b sets the selected value
    */
   public void setSelected( boolean b)
   {
      selected = b;
   }
   
   /**
    * A method that says whether a point is contained in the shape or not
    * @param x x component
    * @param y y component
    * @return if the point is contained or not
    */
   public Shape contains( int x, int y)
   {
      Shape circle;
      double distance;
      
      distance = Math.sqrt( ((this.getX() - x) * (this.getX() - x)) + ((this.getY() - y) * (this.getY() - y)));
      
      if ( distance <= radius)
      {
         return this;
      }
      else
      {
         return null;
      }
   }
}