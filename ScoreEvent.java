import java.util.*;
/**
 * ScoreEvent keeps track of and adds to the player's score
 *
 * @author Rose Connolly
 * @version 1.0
 */
public class ScoreEvent
{
    private int scoreNum;
    /**
     * Constructor for objects of class ScoreEvent
     * 
     * @param  num  is the amount being rewarded and added to the overall score
     */
    public ScoreEvent(int num) //this num needs to be sent in via a scanner somewhere
    {
        scoreNum += num;
    }

    /**
     * this method gives the user a visual on their current score
     * 
     * @return the current score in a string
     */
    String execute(){return "Score:  " + scoreNum;}
}
