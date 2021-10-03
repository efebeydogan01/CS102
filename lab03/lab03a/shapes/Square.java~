package shapes;

import java.util.*;

/**
 * A square class
 * @author Efe Beydoðan
 * @version 08.03.2020
 */
public class Square extends Rectangle implements Selectable
{
   // properties
   private int side;
   private boolean selected;
   
   // constructors 
   public Square( int side)
   {
      super( side,side);
      this.side = side;
      selected = false;
   }
   
   // methods
   
   /**
    * To string method
    * @return toString
    */
   public String toString()
   {
      return "The square with center at (" + this.getX() + "," + this.getY() + ") has sides " + side + " and area " + this.getArea() + " selected: " + this.getSelected();
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
   public boolean contains( int x, int y)
   {
      double halfDiagonal;
      double distance;
      
      distance = Math.sqrt( ((this.getX()) * (this.getX())) + ((this.getY()) * (this.getY())));
      
      halfDiagonal = Math.sqrt( ((side / 2) * (side / 2)) + ((side / 2) * ( side / 2)));
      
      return distance <= halfDiagonal;
   }
}