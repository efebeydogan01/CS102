package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.*;

/**
 * A class that draws gallows
 * @author Efe Beydo?an
 * @version 15.04.2020
 */
public class GallowsHangmanView extends JPanel implements IHangmanView
{
   // properties
   HangmanModel hm;
   private Timer t;
   private boolean timerStart;
   
   // constructors
   
   public GallowsHangmanView( HangmanModel hm)
   {
      this.hm = hm;
      setBackground( Color.CYAN);
      timerStart = true;
      t = new Timer( 300, new ActionListener() {
         public void actionPerformed( ActionEvent e)
         {
            if ( hm.isGameOver() && hm.hasLost())
            {
               repaint();
            }
         }
      });
      t.start();
   }
   
   // methods
   
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      g.setColor( Color.BLACK);
      // Draw the gallow
      g.fillRect( 25, 200, 100, 10);
      g.fillRect( 40, 50, 5, 150);
      g.fillRect( 45, 50, 50, 5); 
      g.fillRect( 90, 50, 3, 15);
      // Draw the body parts with each mistake made
      if ( hm.getNumOfIncorrectTries() >= 1)
      {
         g.drawOval( 72, 65, 40, 40); // head
         g.drawLine( 80, 95, 105, 95); // mouth
         g.drawArc( 80, 83, 25, 25, 0, 180); // mouth
         g.drawOval( 80, 70, 10, 10); // right eye
         g.drawOval( 95, 70, 10, 10); // left eye
      }
      if ( hm.getNumOfIncorrectTries() >= 2)
      {
         g.drawLine( 92, 105, 92, 155); // body
      }
      if ( hm.getNumOfIncorrectTries() >= 3)
      {
         g.drawLine( 92, 110, 72, 140); // right arm
      }
      if ( hm.getNumOfIncorrectTries() >= 4)
      {
         g.drawLine( 92, 110, 112, 140); // left arm
      }
      if ( hm.getNumOfIncorrectTries() >= 5)
      {
         g.drawLine( 92, 155, 72, 175); // right leg
      }
      if ( hm.getNumOfIncorrectTries() >= 6)
      {
         g.drawLine( 92, 155, 112, 175); // left leg
      }
      
      // change the font and color
      g.setFont( new Font("Impact", Font.BOLD, 15));
      g.drawString( hm.getKnownSoFar(), 25, 250);
      
      // change the font and color
      g.setColor( Color.BLUE);
      g.setFont( new Font("Comic Sans", Font.ITALIC, 15));
      g.drawString( hm.getUsedLetters(), 25, 275);
      
      
      
      g.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
      g.setColor( Color.RED);
      if ( hm.isGameOver() && hm.hasLost()) 
      {
         g.drawString( "You lost!", 70, 190);
      }
      else if ( hm.isGameOver() && !hm.hasLost())
      {
         g.drawString( "You won!" , 70, 190);
      }
       
      // play the animation when the game is over
      if ( hm.isGameOver() && hm.hasLost())
      {
         // hide the arms and legs
         g.setColor( getBackground());
         g.drawLine( 92, 110, 112, 140); // left arm
         g.drawLine( 92, 110, 72, 140); // right arm
         g.drawLine( 92, 155, 72, 175); // right leg
         g.drawLine( 92, 155, 112, 175); // leg leg
         
         // draw the legs in a different position
         g.setColor( Color.BLACK);
         g.drawLine( 92, 155, 82, 175); // right leg
         g.drawLine( 92, 155, 102, 175); // left leg
         
         
         if ( timerStart)
         {
            // draw the arms in a different position
            g.setColor( Color.BLACK);
            g.drawLine( 92, 110, 82, 140); // right arm
            g.drawLine( 92, 110, 102, 140); // left arm
            
            // make the characters blink his eyes
            wink( g);
            timerStart = false;
         }
         else
         {
            // make the character open his eyes
            openEye( g);
            // draw the arms in a different position to seem as if they are being waved
            g.setColor( Color.BLACK);
            g.drawLine( 92, 110, 72, 120); // right arm
            g.drawLine( 92, 110, 112, 120); // left arm
            timerStart = true;
         }
      }
   }
   public void wink( Graphics g)
   {
      // hide the eyes
      g.setColor( getBackground());
      g.drawOval( 95, 70, 10, 10); // left eye
      g.drawOval( 80, 70, 10, 10); // right eye
      // draw lines to make the eyes seem as if they are closed
      g.setColor( Color.BLACK);
      g.drawLine( 95, 75, 105, 75); // left eye
      g.drawLine( 80, 75, 90, 75); // right eye
   }
   
   public void openEye( Graphics g)
   {
      // hide the closed eyes
      g.setColor( getBackground());
      g.drawLine( 95, 75, 105, 75);
      g.drawLine( 80, 75, 90, 75);
      // draw ovals for eyes
      g.setColor( Color.BLACK);
      g.drawOval( 95, 70, 10, 10);
      g.drawOval( 80, 70, 10, 10);
   }
   
   @Override
   public void updateView( Hangman hm)
   {
      hm = this.hm;
      repaint();
   }
}