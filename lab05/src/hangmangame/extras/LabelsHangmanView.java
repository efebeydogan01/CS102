package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.*;

/**
 * A class that shows information about the game
 * @author Efe Beydoðan
 * @version 15.04.2020
 */
public class LabelsHangmanView extends JPanel implements IHangmanView
{
   // properties
//   private JLabel correctTries;
//   private JLabel knownSoFar;
//   private JLabel usedLetters;
//   private JLabel lost;
   private Hangman hm;
   
   // constructors 
   
   public LabelsHangmanView( Hangman hm)
   {
      this.hm = hm;
//      correctTries = new JLabel();
//      knownSoFar = new JLabel();
//      usedLetters = new JLabel();
//      lost = new JLabel();
//      
//      add( correctTries);
//      add( knownSoFar);
//      add( usedLetters);
//      add( lost);
//      
//      setLayout( new GridLayout( 4,1));
      setPreferredSize( new Dimension( 200,300));
      setBackground( Color.GREEN);
   }
   
   
   // methods
   
   public void updateView( Hangman hm)
   {
      repaint();
   }
   
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent( g);
      g.setFont(new Font("TimesRoman", Font.BOLD, 15));
      g.setColor( Color.BLACK);
      g.drawString( hm.getNumOfIncorrectTries() + "", 70, 70);
      g.drawString( hm.getKnownSoFar() + "", 70, 90);
      g.drawString( hm.getUsedLetters(), 70, 110);
      g.drawString( "Lost: " + hm.hasLost(), 70, 130);
   }
}