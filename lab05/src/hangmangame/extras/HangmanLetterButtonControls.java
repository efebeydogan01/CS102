package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.*;

/**
 * A class that controls letter buttons
 * @author Efe Beydo?an
 * @version 15.04.2020
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{
   // properties
   
   // constructors
   public HangmanLetterButtonControls( String letters, Hangman hm)
   {
      this( letters, 13, 2, hm);
   }
   
   public HangmanLetterButtonControls( String letters, int rows, int cols, Hangman hm)
   {
      super( letters, rows, cols, hm);
   }
   
   // methods
   
   @Override
   public void updateView( Hangman hm)
   {
      // Show the buttons and hide ones that have been used
      super.setEnabledAll( true);
      super.setDisabled( hm.getUsedLetters());
   }
}