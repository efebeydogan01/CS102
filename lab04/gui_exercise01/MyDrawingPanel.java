import java.awt.*;
import javax.swing.*;

/**
 * Drawing panel
 * @author Efe Beydoðan
 * @version 29.03.2020
 */
public class MyDrawingPanel extends Panel
{
   // properties

   
   // constructors
   public MyDrawingPanel()
   {
      setPreferredSize( new Dimension(300, 250));
      setBackground( Color.YELLOW);
   }
   
   public MyDrawingPanel( int width, int height)
   {
      setPreferredSize( new Dimension(width, height));
   }
   
   // methods
   public void changeColor( Color color)
   {
      this.setBackground( color);
   }
   
   @Override
   public void paint( Graphics g)
   {
      g.drawString( "OP", 50, 50);
      g.drawRect( 100, 100, 40, 30);
      g.drawOval( 150,150, 40,40);
      g.drawLine( 100,100,150,150);
   }
}