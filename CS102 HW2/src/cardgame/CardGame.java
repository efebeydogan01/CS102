package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Efe Beydoðan
// date: 27.02.2020
public class CardGame
{
   // properties
   Cards             fullPack;
   ArrayList<Player> players;
   ScoreCard         scoreCard;
   Cards[]           cardsOnTable;
   int               roundNo;
   int               turnOfPlayer;
   
   // constructors
   public CardGame( Player p1, Player p2, Player p3, Player p4)
   {
      fullPack = new Cards( true);
      
      players = new ArrayList<Player>();
      players.add( p1);
      players.add( p2);
      players.add( p3);
      players.add( p4);
      
      // Deal the cards
      for ( int i = 0; i < 13; i++)
      {
         for ( int k = 0; k < players.size(); k++)
         {
            players.get(k).add( fullPack.getTopCard());
         }
      }
      scoreCard = new ScoreCard( players.size());
      cardsOnTable = new Cards[players.size()];
      //Create empty Cards for every player
      for (int i = 0; i < cardsOnTable.length; i++)
      {
         cardsOnTable[i] = new Cards(false);
      }
      roundNo = 0;
      turnOfPlayer = 0;
   }
   
   // methods
   public boolean playTurn( Player p)
   {
      Card c;
      // If the game is over or the turn doesn't belong to player p then return false
      if ( isGameOver() || !isTurnOf( p))
      {
         return false;
      }
      
      c = p.playCard();
      // Play the top card on p's hand
      cardsOnTable[turnOfPlayer].addTopCard( c);
      System.out.println( p.getName() + " has played " + c);
      
      // If everyone hasn't played, increase turn
      if ( turnOfPlayer < 3)
      {
         turnOfPlayer++;
         return true;
      }
      // If everyone has played, update scores
      else
      {
         updateScores();
         
         if ( !isGameOver())
         {
            turnOfPlayer = 0;
            roundNo++;
         }
         return true;
      }
   }
   
   public boolean isTurnOf( Player p)
   {
      int index;
      
      index = 0;
      
      for ( int i = 0; i < 4; i++)
      {
         if ( players.get(i).getName().equals( p.getName()))
         {
            index = i;
         }
      }
      return index == turnOfPlayer;
   }
   
   public boolean isGameOver()
   {
      return roundNo >= 13;
   }
   
   public int getScore( int playerNumber)
   {
      return scoreCard.getScore( playerNumber);
   }
   
   public String getName( int playerNumber)
   {
      return players.get( playerNumber).getName();
   }
   
   public int getRoundNo()
   {
      return roundNo;
   }
   
   public int getTurnOfPlayerNo()
   {
      return turnOfPlayer;
   }
   
   public Player[] getWinners()
   {
      int[] winners;
      Player[] winnerPlayers;
      
      // Get winner indexes
      winners = scoreCard.getWinners();
      winnerPlayers = new Player[ winners.length];
      
      // Get the winning players using indexes
      for ( int i = 0; i < winners.length; i++)
      {
         winnerPlayers[i] = players.get( winners[i]);
      }
      return winnerPlayers;
   }
   
   public String showScoreCard()
   {
      return scoreCard.toString();
   }
   
   private void updateScores()
   {
      Card maxCard;
      
      //Set the highest card to be the first card in deck
      maxCard = new Card( 0);
      
      // Check all the cards to find the one with maximum value
      for ( int i = 0; i < players.size(); i++)
      {
         // If the player played the card with a higher number, then the new maxCard is that value
         if ( cardsOnTable[i].cards[cardsOnTable[i].valid - 1].getFaceValue() >= maxCard.getFaceValue())
            maxCard = cardsOnTable[i].cards[ cardsOnTable[i].valid - 1];
      }
      
      // Add 1 to the scores of every player who played the card with the highest number
      for ( int i = 0; i < players.size(); i++)
      {
         // If a player played a card with the same value as the maxCard, update their score
         if ( cardsOnTable[i].cards[cardsOnTable[i].valid - 1].getFaceValue() == maxCard.getFaceValue())
         {
            scoreCard.update( i, 1);
         }
      }
   }
}