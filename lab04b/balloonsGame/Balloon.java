package balloonsGame;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import shapes.*;

/**
 * A balloon class
 * @author Efe Beydoðan
 * @version 05.04.2020
 */
public class Balloon extends Circle implements Drawable
{
   // properties
   public static final int RADIUS = 25;
   public static final int GROWTH = 1;
   public static final int MAX_RADIUS = 150;
   private int radiusBalloon;
   private Color color;
   
   // constructors
   public Balloon()
   {
      super( RADIUS);                                           
      radiusBalloon = RADIUS;
      // Create a random color for every balloon
      color = new Color( (int) ( Math.random() * 255), (int) ( Math.random() * 255), (int) ( Math.random() * 255), 255);
   }
   // methods
   
   /**
    * A method to draw a circle
    * @param g the Graphics object
    */
   public void draw( Graphics g)
   {
      g.setColor( color);
      // Subtract the radius of the balloon from the x and y coordinates to draw a circle with center at getX() and getY()
      // Multiply the radius by 2 to get the diameter
      g.fillOval( getX() - radiusBalloon, getY() - radiusBalloon , 2*radiusBalloon, 2*radiusBalloon);
   }
   
   /**
    * A method to grow the balloons
    */
   public void grow()
   {
      // Add a certain value to the radius of the balloon to grow it
      radiusBalloon += GROWTH;
      // If the radius exceeds a certain value, make the radius 0 to "pop" the balloon
      if ( radiusBalloon >= MAX_RADIUS)
      {
         // this.setSelected( true);
         radiusBalloon = 0;
         setLocation( (int) ( Math.random() * BalloonsGamePanel.WIDTH), (int) (Math.random() * BalloonsGamePanel.HEIGHT));
      }
   }
   
   @Override
   public Balloon contains( int x, int y)
   {
      double distance;
      
      // Find the distance between the desired point and the center of the circle
      distance = Math.sqrt( ((getX() - x) * (getX() - x)) + ((getY() - y) * (getY() - y)));
      
      // If the distance between the point and the center is smaller than the radius, then the circle contains the point
      if ( distance <= radiusBalloon)
      {
         return this;
      }
      // Else the point is not inside the circle
      else
      {
         return null;
      }
   }
}