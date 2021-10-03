package cardgame;

/**
 * Card - a single playing card
 * @author Efe Beydoðan
 * @version 27.01.2020
 */
public class Card
{
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NOOFCARDSINSUIT = 13;
    
    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    // methods
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    public boolean equals( Card c)
    {
        return this.cardNo == c.cardNo;
    }
    
    public int compareTo( Card c)
    {
        if ( this.getFaceValue() > c.getFaceValue())
        {
           return 1;
        }
        else if ( this.getFaceValue() == c.getFaceValue())
        {
           return 0;
        }
        else
        {
           return -1;
        }
    }
}