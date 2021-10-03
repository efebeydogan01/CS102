package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import cs102.hangman.Hangman;

public class TextFieldControlPanel extends JPanel
{
   // properties
   Hangman hangman;
   JTextField textField;
   
   
   // constructors
   public TextFieldControlPanel( Hangman hangman)
   {
      this.hangman = hangman;
      textField = new JTextField( 10);
      textField.addActionListener( new TextFieldListener());
      add( textField);
   }
   
   
   // methods
   
   class TextFieldListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         String text;
         // Get the text from the TextField
         text = textField.getText();
         // If game isn't over try all the letters
         if ( !hangman.isGameOver())
         {
            for ( int i = 0; i < text.length(); i++)
            {
               hangman.tryThis( text.charAt( i));
            }
            // Set the text to empty string
            textField.setText( "");
         }
      }
   }
   
   
   
}
   