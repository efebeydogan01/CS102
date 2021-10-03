package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import cs102.hangman.Hangman;

/**
 * An action listener class for letter buttons
 * @author Efe Beydo�an
 * @version 15.04.2020
 */
public class HangmanLetterButtonsController implements ActionListener
{
   // properties
   Hangman hm;
   
   // constructors
   public HangmanLetterButtonsController( Hangman hm)
   {
      this.hm = hm;
   }
   
   // methods
   
   public void actionPerformed( ActionEvent e)
   {
      if ( !hm.isGameOver())
      {
         // try the button that has been clicked
         hm.tryThis(( (JButton) e.getSource()).getText().charAt(0));
      }
   }
                                         
                                         
}