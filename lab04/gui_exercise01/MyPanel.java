import javax.swing.*;
import java.awt.*;

/**
 *  
 * @author Efe Beydoðan
 * @version 29.03.2020
 */ 
public class MyPanel extends JPanel
{
   // properties

   // constructors
   public MyPanel()
   {
      JButton b;
      // setPreferredSize( new Dimension( 100, 100) );
      setSize( 200, 200);
      setLayout( new GridLayout( 2, 3) ); // Default for JPanel is flow layout
      
      add( new JLabel( "Welcome to ZOOM") );
      
      b = new JButton( "OK");
      add( b);
      add( new JButton( "Good luck with Maths! ") );
      
      add( new JTextField( 25) );      
   }

   // methods
     
}