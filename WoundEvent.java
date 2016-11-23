
/**
 * This subclass of event takes away health points from player.
 * 
 * @author Matt Rychlik
 * @version 11/06/2016
 */
public class WoundEvent extends Event
{
    private int woundAmount;

    /**
     * Constructor for objects of class WoundEvent
     */
    public WoundEvent(int woundAmount){
    this.woundAmount = woundAmount;
    }

    /**
     * Takes away a given amount of health points from player.
     */
    String execute(){
     GameState.instance().setHealth(GameState.instance().getHealth()-woundAmount);
     return "Your health is up to " + GameState.instance().getHealth();
     }
    }
