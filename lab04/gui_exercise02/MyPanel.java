import java.awt.*;
import java.awt.event.*;

/**
 *  
 * @author Efe Beydo?an
 * @version 30.03.2020
 */ 
public class MyPanel extends Panel implements ActionListener
{
   // properties
   Label     label;
   TextField tf;
   Panel     p;
   Button    b;
   boolean press;

   // constructors
   public MyPanel()
   {
      press = true;
      // setPreferredSize( new Dimension( 100, 100) );
      setSize( 200, 200);
      setLayout( new FlowLayout() );
      
      label = new Label( "Welcome to ZOOM");
      add( label);
      
      // add( new Button( "Good luck with Maths! ") );

      b = new Button( "OK");
      b.setPreferredSize( new Dimension(40,40));
      add( b);
      
//      b.addActionListener( this );
//      b.addActionListener( new MyActionListener() );
      b.addActionListener( new MyOtherActionListener() );
//      
//      b.addActionListener( new ActionListener() {
//         public void actionPerformed(ActionEvent e)
//         {
//            System.out.println( "Button pressed! ~ AL-Annon" );
//         }
//      });      
//      b.addActionListener( 
//          e -> System.out.println( "Button pressed! ~ LAMBDA" ) );
      
      tf = new TextField( 25);
      add( tf );      
      tf.addActionListener( this);
      tf.addActionListener( new MyOtherTFActionListener());
      
      p = new Panel();
      p.setBackground( Color.cyan);
      p.setPreferredSize( new Dimension( 200, 150) );
      add(p);
   }

   // methods
   public void actionPerformed(ActionEvent e)
   {
      if ( e.getSource() != tf ) 
         System.out.println( "Button pressed!" );
      else
         System.out.println( "TF pressed!" );
      
      label.setText( tf.getText() );
   }
   
   // named inner class
   class MyOtherActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         System.out.println( "Button pressed");
         if ( press)
         {
            b.setLabel( "OK");
         }
         else
         {
            b.setLabel( "Maybe");
         }
         press = !press;
      }
   }
   
   // named inner class
   class MyActionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.out.println( "Button pressed! ~ ALNIC" );
         
         // right way is to override paint
         
         // wrong way to do it
         Graphics g;
         g = p.getGraphics();
         g.drawString( "OK?", 100, 50);
      }
   }
   
   // named inner class
   class MyOtherTFActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         System.out.println( "TextField enter key pressed");
         System.out.println( tf.getText());
         label.setText(tf.getText());
      }
      
   }
     
}