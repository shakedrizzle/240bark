import java.util.*;
/**
 * this class holds: NPCs and what makes up a NPC is fetched from this class
 * 
 * @author Rose Connolly
 * @version 1.0
 */
public class NPC
{
    class NoNPCException extends Exception {}
    private String NPCname;
    private boolean friend;
    private Hashtable <String,String> dialog;
    private int health;
    private int attack;
    private int defense;
    private boolean isAlly;
    private ArrayList<Item> inventory;
    private String desc;
    private String name;
    
    
    /**
     * Constructor for objects of class NPC
     * accesses file for NPCs
     * 
     * @param  s  where the method will read the information it needs to fill & complete
     * the NPC
     */
    NPC(int health, int attack, int defense, boolean isAlly, String desc, String name) throws NoNPCException,
    Dungeon.IllegalDungeonFormatException 
    {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.isAlly = isAlly;
        inventory = new ArrayList<Item>();
        this.desc = desc;
        this.name = name;
        
    
    }
    
    /**
     * Makes sure the NPC goes by the specified name (could have other borking aliases)
     * 
     * @param  name  that is being checked for the NPC
     * @return  true  if the NPC does go by "name" else, it will return false
     */
    boolean goesBy(String name){return this.NPCname.equals(name);}
    
    /**
     * gets name of NPC
     * 
     * @return  String  of the NPC's name
     */
    String getName(){return NPCname;}
 
    /**
     * gets the dialog of the NPC from the hashtable
     * 
     * @param  borks  refers to the specified dialog it finds in the hashtable
     * the values of an NPC's borks is read from a file (and "put" in the hashtable)
     * @return  String  of the borks our NPC will give, in other words, the NPC's dialog
     */
    public String getDialog(String borks){return dialog.get(borks);}
    
    public void setDialog(String desc){
        int temp = desc.indexOf(":");
        String action = desc.substring(0,temp);
        String phrase = desc.substring(temp+1);
        dialog.put(action, phrase);
        
    }
    
    public String takeHit(int damage){
        if (damage > defense){
            this.health = this.health - (damage - defense);
            return this.name+" took damage. Their health is now "+this.health+".\n";
        }
        else 
            this.health = this.health - (damage / 2);
            return this.name+"'s defense was so strong they took half damage. Their health is now "+this.health+".\n";
                    
    }
    
    public String die(){
        this.health = 0;
        return this.name+" has died\n";
    }
    
    public String dropInventory(){
        for (Item item : inventory) {
            String name = item.toString();
            System.out.println(this.name+" has dropped "+item.goesBy(name)+"\n");
            removeFromInventory(item);      
        }
        return "";
    }
    
    public String addToInventory(Item item){
        inventory.add(item);
        return "Added "+item.toString()+"\n";
        
    }
    public String removeFromInventory(Item item){
        inventory.remove(item);
        return "Removed "+item.toString()+"\n";
    }
    
    public String getInventory(){
        for (Item item : inventory) {
            String name = item.toString();
            System.out.println(name);     
        }
        return "";
    }
}
