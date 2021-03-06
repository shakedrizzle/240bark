
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
   TransformEvent(String newitem, Item item){
   this.item = item;
   this.newItem = newItem;
   }
   
   
  String execute(){
      try { 
      GameState.instance().addToInventory(GameState.instance().getDungeon().getItem(newItem));
      EventFactory.instance().parse("Disappear "+item.getPrimaryName(),item).execute();
      return item + "has trasformed into: " + newItem;
      }
      catch (Item.NoItemException e) {
          return "you could not find it in yourself to perform this action";   
      }
   
   
   }
}
