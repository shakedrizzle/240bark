
/**
 * This subclass of event takes one item and exchange it with another item.
 * 
 * @author Freda Osei
 * @version Nov 6, 2016
 */
public class TransformEvent extends Event
{
   String newItem;
   Item item;
   /**
    * Constructor for objects of class TransformEvent
    */
   TransformEvent(Item aname, String bname){}
   
   /**
    * Removes an item from the dungeon and replaces it with a new item. 
    * On cases where there is no item in the room, nothing should be transformed or returned.
    */
   void execute(){}
}
