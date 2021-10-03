package balloonsGame;

import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import shapes.*;

/**
 * A Balloon game class
 * @author Efe Beydoðan
 * @version 05.04.2020
 */

public class BalloonsGamePanel extends JPanel
{
   // properties
   private ShapeContainer balloons;
   private Timer timer;
   public static final int WIDTH = 800;
   public static final int HEIGHT= 600;
   private int points;
   private JLabel pointLabel;
   private JOptionPane gameOver;
   private double elapsedTime;
   public static final int TIMER_TIME = 100;
   public static final int GAME_TIME = 15000;
   public static final int NO_OF_BALLOONS = 25;
   private JLabel timeLabel;

   // constructors
   
   public BalloonsGamePanel()
   {
      // Set up the Balloons game panel
      setPreferredSize( new Dimension( WIDTH, HEIGHT));
      addMouseListener( new MyMouseListener());
      setBackground( Color.CYAN);
      pointLabel = new JLabel();
      timeLabel = new JLabel();
      add( pointLabel);
      add( timeLabel);
      
      setEverything();
      
   }
   
   // methods
   
   public void setEverything()
   {
      // There are 0 points when the game begins
      points = 0;
      // No time has passed when the game first begins
      elapsedTime = 0;
      // Create a container to hold the balloons
      balloons = new ShapeContainer();
      // Set the label to show the points
      pointLabel.setText( "Points: " + points);
      // Set the time label
      timeLabel.setText( "Elapsed time: " + elapsedTime);
      // Set the timer with a specified interval and add an ActionListener
      timer = new Timer( TIMER_TIME, new TimerListener());
      // Start the timer
      timer.start();
      
      // Add the predetermined number of balloons to the container
      for ( int i = 0; i < NO_OF_BALLOONS; i++)
      {
         Balloon tmp;
         tmp = new Balloon();
         // Find random values for the x and y coordinates of the center of the balloon
         tmp.setLocation( (int) ( Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
         // Add the balloons to the container
         balloons.add( tmp);
      }
      
   }
   
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent( g);
      
      Iterator iterator = balloons.iterator();
      // While there is a balloon in the container, draw the balloon
      while (iterator.hasNext()) 
      {
         ((Drawable)(iterator.next())).draw(g);
      }
   }
   
   class TimerListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         // Add the predetermined interval to elapsed time
         elapsedTime += TIMER_TIME;
         timeLabel.setText( "Elapsed time: " + elapsedTime / 1000);
         
         // If more time has passed than the game time then stop the game
         if ( elapsedTime >= GAME_TIME)
         {
            // Stop the timer
            timer.stop();
            // Create the JOptionPane to ask the user whether they want to play again or not
            int playAgain;
            playAgain  = JOptionPane.showConfirmDialog( BalloonsGamePanel.this, "Play again? ", "Game is over!", 0);
            // If the user wants to play again restart the game
            if ( playAgain == 0) 
            {
               setEverything();
            }
         }
         
         // If there are less than 15 balloons, add another balloon
         if ( balloons.size() <= 15)
         {
            {
               Balloon tmp;
               tmp = new Balloon();
               tmp.setLocation( (int) ( Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
               balloons.add( tmp);
            }
         }
         // Remove the selected balloons
         balloons.removeSelected();
            
         // Grow the balloons
         Iterator iterator = balloons.iterator();
         while (iterator.hasNext()) 
         {
            ((Balloon)iterator.next()).grow();
         }
         repaint();
      }
   }
   
   class MyMouseListener extends MouseAdapter
   {
      @Override
      public void mousePressed( MouseEvent e)
      {
         int selected;
         selected = balloons.selectAllAt( e.getX(), e.getY());
         // balloons.removeSelected();
         if ( selected >= 2)
         {
            points += selected;
            pointLabel.setText( "Points: " + points);
         }
      }
   }
}

