package shapes;

import java.util.*;

/**
 * A rectangle class
 * @author Efe Beydoðan
 * @version 08.03.2020
 */
public class Rectangle extends Shape implements Selectable
{
   // properties
   private int width;
   private int length;
   private boolean selected;
   
   // constructors
   public Rectangle( int width, int length)
   {
      this.width = width;
      this.length = length;
      selected = false;
   }
   
   // methods
   
   /**
    * A method that gets area
    * @return the area
    */
   public double getArea()
   {
      return width*length;
   }
   
   /**
    * To string method
    * @return toString
    */
   public String toString()
   {
      return "The rectangle with center at (" + this.getX() + "," + this.getY() + ") has sides " + width + " and " + length + " and area " + this.getArea() + " selected: " + this.getSelected();
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
      double halfDiagonal;
      double distance;
      
      distance = Math.sqrt( ((this.getX() - x) * (this.getX() - x)) + ((this.getY() - y) * (this.getY() - y)));
      
      halfDiagonal = Math.sqrt( ((width / 2) * (width / 2)) + ((length / 2) * ( length / 2)));
      
      if ( distance <= halfDiagonal)
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
}