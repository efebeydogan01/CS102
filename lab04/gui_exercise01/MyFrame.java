import javax.swing.*;
import java.awt.*;
/**
 *  
 * @author Efe Beydoðan
 * @version 29.03.2020
 */ 
public class MyFrame extends JFrame
{
   // properties

   // constructors
   public MyFrame()
   {
      JButton b;
      JPanel  p;
      MyDrawingPanel mdp;
      
      // f.setSize( 400, 300);
      // setBounds( 350, 250, 400, 300);
      setLayout( new BorderLayout() ); // Default for frame is border layout
      
      p = new MyPanel();
      mdp = new MyDrawingPanel( 300, 300);
      mdp.changeColor( Color.BLUE);
      add( new MyPanel(), BorderLayout.NORTH );
      add( new MyPanel(), BorderLayout.SOUTH );
      add( new MyDrawingPanel(), BorderLayout.EAST);
      add( mdp, BorderLayout.CENTER);
//      p.add( new Label( "Welcome to ZOOM") );
//      
//      b = new Button( "OK");
//      p.add( b);
//      p.add( new Button( "Good luck with Maths! ") );
//      
//      p.add( new TextField( 25) );
      
      // add( p, BorderLayout.CENTER );
      
      pack();
      setVisible( true );      
   }

   // methods
     
}