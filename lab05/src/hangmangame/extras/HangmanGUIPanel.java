package hangmangame.extras;

import cs102.hangman.HangmanModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author david
 */
public class HangmanGUIPanel extends JPanel {

   HangmanModel hm;
   private JPanel tfcp;
   private NewGameButtonControl newGame;
   private LabelsHangmanView labels;
   private GallowsHangmanView gallows;
   private HangmanLetterButtonControls letterButtons;
   
   public HangmanGUIPanel( HangmanModel hm) {
      this.hm = hm;
      setPreferredSize( new Dimension( 500, 350) );
      setLayout( new BorderLayout() );
      setBackground(Color.YELLOW);

      // add controls and views here...
      // Add the text field
      tfcp = new TextFieldControlPanel( hm);
      this.add( tfcp, BorderLayout.NORTH);
      
      // add a new game button to start a new game
      newGame = new NewGameButtonControl( this.hm);
      hm.addView( newGame);
      add( newGame, BorderLayout.SOUTH);
      
      // add labels to show the progress of the game
      labels = new LabelsHangmanView( hm);
      hm.addView( labels);
      this.add( labels, BorderLayout.WEST);
      
      // add gallows 
      gallows = new GallowsHangmanView( this.hm);
      hm.addView( gallows);
      this.add( gallows, BorderLayout.CENTER);
      
      // add letter buttons
      letterButtons = new HangmanLetterButtonControls( hm.getAllLetters(), hm);
      hm.addView( letterButtons);
      this.add( letterButtons, BorderLayout.EAST);     
   }   
}
