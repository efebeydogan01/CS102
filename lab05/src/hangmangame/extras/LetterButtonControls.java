package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.Hangman;

/**
 * LetterButtonControls - keyboard for MVC demo of Hangman, but general purpose.
 *
 * @author David
 * @version 1.00
 */
public class LetterButtonControls extends JPanel {

   // properties
   Hangman hm;
   
   // constructors
   public LetterButtonControls(String letters, Hangman hm) {
      this(letters, 13, 2, hm);
   }

   public LetterButtonControls(String letters, int rows, int cols, Hangman hm) {
      this.hm = hm;
      setBorder(new TitledBorder("Choose a letter..."));
      setLayout(new GridLayout(rows, cols));
      setPreferredSize( new Dimension( 115,200));

      for (int i = 0; i < letters.length(); i++) {
         JButton b = new JButton("" + letters.charAt(i));
         b.setMargin(new Insets(1, 2, 1, 2));
         add(b);
      }
      
      this.addActionListener( new HangmanLetterButtonsController( hm));
   }
   
   // methods

   public void addActionListener(ActionListener l) {
      Component[] buttons = getComponents();
      for (Component b : buttons) {
         ((JButton) b).addActionListener(l);
      }
   }

   public void setEnabledAll(boolean state) {
      for (Component c : getComponents()) {
         ((JButton) c).setEnabled(state);
      }
   }

   public void setDisabled(String letters) {
      letters = letters.toUpperCase();    // bug fix! ?think about this!
      for (Component c : getComponents()) {
         char ch = ((JButton) c).getText().charAt(0);
         ch = Character.toUpperCase(ch);  // bug fix!
         if (letters.indexOf(ch) >= 0) {
            ((JButton) c).setEnabled(false);
         }
      }
   }
}
