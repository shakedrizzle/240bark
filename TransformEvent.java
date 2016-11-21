
/**
 * This subclass of event takes one item and exchange it with another item.
 * 
 * @author Freda Osei
 * @version Nov 6, 2016
 */
public class TransformEvent extends Event
{
   String newItem;
   String item;
   /**
    * Constructor for objects of class TransformEvent
    */
   TransformEvent(String newitem, String item){
   this.item = item;
   this.newItem = newItem;
   }
   
   
   void execute(){
      GameState.instance().addToInventory(GameState.instance().getDungeon().getItem(newItem));
      return EventFactory.instance().parse("Disappear("+originalItem+")").execute();
   
   
   }
}
