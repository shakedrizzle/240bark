import java.util.*;
/**
 * Subclass of Command that changes the current room of the GameState
 * 
 * @author Rose 
 * @version 1.1
 */
public class TeleportCommand extends Command
{
    private Room place;
    boolean tripped=false;
    /**
     * Constructor for objects of class TeleportEvent
     * @param  name  of the room desired
     */
    TeleportCommand(String name){
        if ( GameState.instance().getDungeon().getHashtable().containsKey(name)){
            place = GameState.instance().getDungeon().getRoom(name);
        }
        else{     
            tripped = true;
        }
    }

    /**
     * Changes the current room to another room.
     * 
     */
    String execute(){//change adventerers current room to the room that is being teleported too
        //set adventures current room to place
        if(GameState.instance().getTele()&&!tripped){
            GameState.instance().setAdventurersCurrentRoom(place);
            String desc = place.describe();
            return desc;
        }
        else if(tripped){return "that is not a real room dog breath";}
        else{
            return "you do not hold the item needed for this event";
        }
    }
}
