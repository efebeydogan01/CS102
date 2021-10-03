import java.awt.*;
import javax.swing.*;
import java.util.*;
import balloonsGame.*;

/**
 * A Balloons frame
 * @author Efe Beydoðan
 * @version 05.04.2020
 */
public class Lab04b
{
   public static void main( String[] args)
   {
      // variables
      JFrame balloons;
      BalloonsGamePanel game;
      
      // program code
      balloons = new JFrame( "Balloons");
      game = new BalloonsGamePanel();
      
      balloons.add( game);
      balloons.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      balloons.pack();
      balloons.setVisible(true);
   }
}