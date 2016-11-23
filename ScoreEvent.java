import java.util.*;
/**
 * ScoreEvent keeps track of and adds to the player's score
 *
 * @author Rose Connolly
 * @version 1.1
 */
public class ScoreEvent extends Event
{
    private int num;
    /**
     * Constructor for objects of class ScoreEvent
     * 
     * @param  num  is the amount being rewarded and added to the overall score
     */
    public ScoreEvent(int num) //this num needs to be sent in via a scanner somewhere
    {
        this.num = num;
        GameState.instance().addScore(num);
    }

    /**
     * this method gives the user a visual on their current score
     * 
     * @return the current score in a string
     */
    String execute(){
    return "You earned: " + num + "Current Score: " + GameState.instance().getScore());
    }
}
