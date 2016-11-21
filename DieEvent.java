
/**
 * Subclass of Event that ends the game if health reaches 0.
 * 
 * @author Matt Rychlik
 * @version 11/06/2016
 */
public class DieEvent extends Event
{
    
    
    /**
     * Constructor for objects of class DieEvent
     */
    public DieEvent(){}

    /**
     * Kills player and ends game
     */
    String execute(){
     GameState.instance().setHealth(0);
     return " You are died :("
    }

}
