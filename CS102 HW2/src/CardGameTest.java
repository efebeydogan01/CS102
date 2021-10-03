import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Efe Beydoðan
// date: 27.02.2020
public class CardGameTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      System.out.println( "Start of CardGameTest\n");
      
      // CONSTANTS
      
      // VARIABLES
      Card       c;
      Cards      cards;
      ScoreCard  scores;
      Player     p;
      CardGame   game;
      Player     p2;
      Player     p3;
      Player     p4;
      // PROGRAM CODE
      
      // test Card class
      c = new Card( 1);
      System.out.println( c);
      System.out.println();
      
      // test Cards class
      cards = new Cards( true);
      cards.addTopCard( c);
      cards.testOnlyPrint();  // remove method after testing!
      
      // test ScoreCard class
      scores = new ScoreCard( 4);
      scores.update( 3, 1);
      scores.update( 1, 2);
      System.out.println( "\n" + scores );
      
      for ( int x : scores.getWinners())
      {
         System.out.println( x);
      }
      
      // test Player class
      p = new Player( "Efe");
      System.out.println( "getName(): " + p.getName());
      p.add( c);
      System.out.println( p.playCard());
      
      // test CardGame class too?
      p2 = new Player( "Arda");
      p3 = new Player( "Emir");
      p4 = new Player( "David");
      game = new CardGame( p, p2, p3, p4);
      //System.out.println( "playTurn( p): " + game.playTurn(p));
      System.out.println( "isTurnOf( p): " + game.isTurnOf( p));
      System.out.println( "isGameOver(): " + game.isGameOver());
      System.out.println( "getScore( 0): " + game.getScore( 0));
      System.out.println( "getName( 2): " + game.getName( 2));
      System.out.println( "getRoundNo(): " + game.getRoundNo());
      System.out.println( "getTurnOfPlayer(): " + game.getTurnOfPlayerNo());
      
      // Once you have all the bits working, complete the MyCardGame program
      // that provides a menu allowing any of the players to play their card,
      // an option to see the score card, and one to quit the game at any time.
      // When the game is over it should print out the winners.
      
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      System.out.println( game.playTurn( p4));
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      System.out.println( game.playTurn( p4));
      
      System.out.println( game.showScoreCard());
      
      
      
      System.out.println( "\nEnd of CardGameTest\n" );
   }
   
} // end of class CardGameTest
