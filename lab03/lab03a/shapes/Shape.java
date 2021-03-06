package shapes;

import java.util.*;

public abstract class Shape implements Locatable
{
   int x = 0;
   int y = 0;
   
   public abstract double getArea();
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public void setLocation( int x, int y)
   {
      this.x = x;
      this.y = y;
   }
}