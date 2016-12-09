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
    //next to NPC name
    private String health;
    private int hp;
    private String attack;
    private int atk;
    private String defence;
    private int def;
    private boolean ally;
    //under NPCname and stats
    private String description;
    //under description
    private Hashtable <String, String> options;
    //---
    private ArrayList<Item> inventory;
    
    
    /**
     * Constructor for objects of class NPC
     * accesses file for NPCs
     * 
     * @param  s  where the method will read the information it needs to fill & complete
     * the NPC
     */
     NPC(Scanner s) throws NoNPCException,
    Dungeon.IllegalDungeonFormatException {
        options = new Hashtable<String, String>();
        String alli;
        String opts;
        String NPCstats = s.nextLine();
        String stats[] = NPCstats.split(" ");
        NPCname = stats[0];
        if (NPCname.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoNPCException();
        }
        health  = stats[1];
        attack  = stats[2];
        defence = stats[3];
        alli    = stats[4];
        this.NPCname = NPCname;

        if(alli.equals("true")){ally = true;}
        else{ally = false;}
        int hp = Integer.valueOf(health);
        int atk = Integer.valueOf(attack);
        int def = Integer.valueOf(defence);
        description = s.nextLine();
        String decr="";
        while(!description.contains(":")){
            decr += description+"\n";
            description = s.nextLine();
        }
        description=decr;
        //getting options
        opts = s.nextLine();
        String[] optionParts;
        String option;
        while (!opts.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (opts.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" +
                    Dungeon.SECOND_LEVEL_DELIM + "' after option.");
            }
            optionParts = opts.split(":");
            option = optionParts[0];
            options.put(optionParts[0],optionParts[1]);

            opts = s.nextLine();
        }
    }
    
    /**
     * Makes sure the NPC goes by the specified name (could have other borking aliases)
     * 
     * @param  name  that is being checked for the NPC
     * @return  true  if the NPC does go by "name" else, it will return false
     */
    boolean goesBy(String name){return this.NPCname.equals(name);}
    String getTalk(){//in progress
        return options.get("talkto");
    }
    String getPet(){
        return options.get("pet");
    }
    String getAttack(){
        return options.get("attack");
    }
    
    
    /**
     * gets name of NPC
     * 
     * @return  String  of the NPC's name
     */
    String getNPCname(){return NPCname;}
    int getHP(){return this.hp;}

    String getNPCStats(){return(this.getNPCname() + ": "+ this.hp + this.atk + this.def);}
    String getOptions(String borks){return options.get(borks);}
    /**
     * gets the dialog of the NPC from the hashtable
     * 
     * @param  borks  refers to the specified dialog it finds in the hashtable
     * the values of an NPC's borks is read from a file (and "put" in the hashtable)
     * @return  String  of the borks our NPC will give, in other words, the NPC's dialog
     */
    /**public String getDialog(String borks){return dialog.get(borks);}
    the way dialog was going to work (this implementation) is too complicated to finish in time
    so I simplified it
    public void setDialog(String desc){
        int temp = desc.indexOf(":");
        String action = desc.substring(0,temp);
        String phrase = desc.substring(temp+1);
        dialog.put(action, phrase);**/
        
    
    
    public String takeHit(int damage){
        if (damage > def){
            this.hp = this.hp - (damage - def);
            return this.NPCname+" took damage. Their health is now "+this.hp+".\n";
        }
        else 
            this.hp = this.hp - (damage / 2);
            return this.NPCname+"'s defense was so strong they took half damage. Their health is now "+this.health+".\n";
                    
    }
    
    public String die(){
        this.hp = 0;
        return this.NPCname+" has died\n";
    }
    
    public String dropInventory(){
        for (Item item : inventory) {
            String name = item.toString();
            System.out.println(this.NPCname+" has dropped "+item.goesBy(name)+"\n");
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
