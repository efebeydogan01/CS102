import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PotLuckClass
{
   // properties
   private JFrame frame;
   private JPanel buttonsGrid;
   private JPanel bar;
   private JLabel label;
   private JFrame winFrame;
   private JLabel winLabel;
   private JButton closeButton;
   private int prize;
   private int attempt;
   private int temp;
   private boolean gameOver;
   private JButton[] buttons;
   private JButton resetButton;
   private final int ROW = 5;
   private final int COLUMN = 5;
   private final int NUMBER_OF_BUTTONS = ROW * COLUMN;
   
   // constructors
   public PotLuckClass()
   {
      setEverything();
      
      // Initialize the frame
      frame = new JFrame( "PotLuck");
      
      frame.setLayout( new BorderLayout());
      
      frame.add( bar, BorderLayout.NORTH);
      
      frame.add( buttonsGrid, BorderLayout.CENTER);
      
      frame.setPreferredSize( new Dimension( 500,500));
      
      frame.pack();
      
      frame.setLocationRelativeTo( null);
      
      frame.setVisible( true);
   }
   
   // methods
   
   public void setEverything()
   {
      // there are no attempts at the beginning
      attempt = 0;
      
      // gameOver is false at first
      gameOver = false;
      
      // choose a random button to hide the prize
      prize = (int) (Math.random() * 25) + 1;
      
      // create a 5x5 button grid 
      buttonsGrid = new JPanel();
      buttonsGrid.setLayout( new GridLayout( ROW, COLUMN));
      
      // create an array to hold the buttons
      buttons = new JButton[NUMBER_OF_BUTTONS];
      
      // set the label and add it to the status bar
      label = new JLabel( "Number of attempts: " + attempt);
      bar = new JPanel();
      resetButton = new JButton( "Reset");
      resetButton.addActionListener( new ResetAction());
      bar.add( resetButton);
      bar.add( label);
      
      // initialize close button
      closeButton = new JButton( "Exit");
      closeButton.addActionListener( new CloseAction());
      bar.add( closeButton);
      
      
      // initialize every button and ActionListener to them
      for ( int i = 0; i < buttons.length; i++)
      {
         buttons[i] = new JButton( i + 1 + "");
         
         buttons[i].addActionListener( new GridButtons());
         buttonsGrid.add( buttons[i]);
      }
   }
   
   public class GridButtons implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         // If the game is over then keep the pop up window
         if ( gameOver)
         {
            winLabel.setText( "You got it in " + attempt + " attempts!");
         }
         // Else if the chosen button is not the one hiding the prize, update the number of attempts and hide the button
         else if ( !((JButton)e.getSource()).getText().equals( "" + prize))
         {
            attempt++;
            label.setText( "Number of attempts: " + attempt);
            ((JButton)e.getSource()).setEnabled( false);
         }
         // Else update gameOver to be true and show the number of attempts it took to find the correct button in a pop up frame
         else
         {
            ((JButton)e.getSource()).setEnabled( false);
            attempt++;
            gameOver = true;
            // Update the label on the game window progress bar
            label.setText( "Number of attempts: " + attempt);
            // Create a new pop up window
            winFrame = new JFrame( "You've won!");
            winLabel = new JLabel();
            winLabel.setText( "You got it in " + attempt + " attempts!");
            winFrame.add( winLabel);
            winFrame.setPreferredSize( new Dimension( 300,100));
            winFrame.pack();
            winFrame.setLocationRelativeTo( null);
            winFrame.setVisible( true);
         }
      }
   }
   
   public class ResetAction implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         // If game is over close the popup window when clicked
         if ( gameOver)
         {
            winFrame.dispose();
         }
         
         // make the panels invisible
         buttonsGrid.setVisible( false);
         bar.setVisible( false);
         
         // use the method to set everything
         setEverything();
         
         frame.add( bar, BorderLayout.NORTH);
         
         frame.add( buttonsGrid, BorderLayout.CENTER);
      }
   }
   
   public class CloseAction implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         frame.dispose();
         if ( gameOver)
         {
            winFrame.dispose();
         }
      }
   }
}

