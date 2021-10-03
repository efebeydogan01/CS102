package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.Hangman;
import cs102.hangman.IHangmanView;

/**
 * A class for a button to restart a game
 * @author Efe Beydoðan
 * @version 15.04.2020
 */
public class NewGameButtonControl extends JButton implements IHangmanView
{
   // properties
   Hangman hm;
   
   // constructors
   
   public NewGameButtonControl( Hangman hm)
   {
      this.hm = hm;
      this.setText( "New Game");
      addActionListener( new ButtonListener());
      setEnabled( false);
   }
   
   
   
   // methods
   
   @Override
   public void updateView( Hangman hm)
   {
      // show the button when the game is over
      if ( hm.isGameOver())
      {
         setEnabled( true);
      }
   }
   
   class ButtonListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         setEnabled( false);
         hm.initNewGame();
      }
   }
   
}