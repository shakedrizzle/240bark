
 

import java.util.Scanner;
import java.util.Hashtable;

public class Item {

    static class NoItemException extends Exception {}

    private String primaryName;
    private int weight;
    private Hashtable<String,String> messages;
    private boolean howToSwim;
    private boolean canTele;

    Item(Scanner s) throws NoItemException,
        Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String,String>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());
        
         //our file accounts for below on google drive
         // it's in comments for Zeitz's bork file (for now)
        //read swim bool
        /*String swim = s.nextLine();
        if(swim.equals("true")){
            howToSwim = true;}
        else {howToSwim = false;}
        //read tele bool
        String tele= s.nextLine();
        if(tele.equals("true")){
            canTele = true;}
        else {canTele = false;} */
         
        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" +
                    Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }
            String[] verbParts = verbLine.split(":");
            messages.put(verbParts[0],verbParts[1]);
            
            verbLine = s.nextLine();
        }
    }
     /**
     * Tells whether the user has swim object or not
     * 
     * @return true or false depending on whether item is in inventory
     */
    boolean hasSwimObj(){return howToSwim;}
    boolean hasTele(){return canTele;}

    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }

    String getPrimaryName() { return primaryName; }

    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }

    public String toString() {
        return primaryName;
    }
}
