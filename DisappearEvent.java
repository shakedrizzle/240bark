
/**
 *A subclass of event that completely gets rid of an item.
 * 
 * @author Freda Osei 
 * @version Nov 6, 2016
 */
public class DisappearEvent extends Event
{
    Item disItem;
    /**
     * Constructor for objects of class DisappearEvent.
     */
    DisappearEvent(){
    this.disItem = disItem;
    }
    
    /**
     * Gets rid of an item in the the dungeon completely, in cases where there is no item, no item will dissappear
     */
    void execute(){
    Item item = GameState.instance().getItemInVicinityNamed(disItem);
    if (GameState.instance().getItemFromInventoryNamed(disItem) != null) {
        GameState.instance().removeFromInventory(item);
        
        }
    }
    
}
