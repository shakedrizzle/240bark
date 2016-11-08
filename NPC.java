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
    /**
     * Constructor for objects of class NPC
     * accesses file for NPCs
     * 
     * @param  s  where the method will read the information it needs to fill & complete
     * the NPC
     */
    NPC(Scanner s) throws NoNPCException,
    Dungeon.IllegalDungeonFormatException {}
    
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
}
