
/**
 *A subclass of event that completely gets rid of an item.
 * 
 * @author Freda Osei 
 * @version Nov 6, 2016
 */
public class DisappearEvent extends Event
{
    String disItem;
    /**
     * Constructor for objects of class DisappearEvent.
     */
    DisappearEvent(){
    this.disItem = disItem;
    }
    
    /**
     * Gets rid of an item in the the dungeon completely, in cases where there is no item, no item will dissappear
     */
    String execute(){
    try {
    Item item = GameState.instance().getItemInVicinityNamed(disItem);
    if (GameState.instance().getItemFromInventoryNamed(disItem) != null) {
        GameState.instance().removeFromInventory(item);
        return disItem + "has disappeared.";
        }
    else {
        return "You have no item to get rid of.";
        
    }
    }
    catch (Item.NoItemException e) {return "you felt as if something was going change, but nothing did";}
    }
    
}
