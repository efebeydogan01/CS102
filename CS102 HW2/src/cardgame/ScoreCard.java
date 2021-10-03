package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Efe Beydoðan
// date: 
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners()
    {
        int maxScore;
        int[] winners;
        int length;
        int index;
        
        maxScore = 0;
        length = 0;
        
        // Find the maximum score
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] > maxScore)
           {
              maxScore = scores[i];
           }
        }
        
        // Determine the number of players with the highest score to create winners array
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] == maxScore)
           {
              length++;
           }
        }
        winners = new int[length];
        index = 0;
        // Add the numbers of players with the highest score to the winners array
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] == maxScore)
           {
              winners[index] = i;
              index++;
           }
        }
        return winners;
    }
    
} // end class ScoreCard
