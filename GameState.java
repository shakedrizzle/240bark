
 

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GameState {

    public static class IllegalSaveFormatException extends Exception {
        public IllegalSaveFormatException(String e) {
            super(e);
        }
    }

    static String DEFAULT_SAVE_FILE = "bork_save";
    static String SAVE_FILE_EXTENSION = ".sav";
    static String SAVE_FILE_VERSION = "Bork v3.0 save data";

    static String ADVENTURER_MARKER = "Adventurer:";
    static String CURRENT_ROOM_LEADER = "Current room: ";
    static String INVENTORY_LEADER = "Inventory: ";
    static String TOP_LEVEL_DELIM = "===";
    static String SECOND_LEVEL_DELIM = "---";

    private static GameState theInstance;
    private Dungeon dungeon;
    private ArrayList<Item> inventory;
    private ArrayList<String> NPCs;
    private Room adventurersCurrentRoom;
    private boolean hasHunger;
    private boolean canTele;
    private boolean canSwim;
    private int health = 100;
    private int score;
 
    static synchronized GameState instance() {
        if (theInstance == null) {
            theInstance = new GameState();
        }
        return theInstance;
    }

    private GameState() {
        inventory = new ArrayList<Item>();
        NPCs = new ArrayList<String>();
    }

    void restore(String filename) throws FileNotFoundException,
        IllegalSaveFormatException, Dungeon.IllegalDungeonFormatException {

        Scanner s = new Scanner(new FileReader(filename));

        if (!s.nextLine().equals(SAVE_FILE_VERSION)) {
            throw new IllegalSaveFormatException("Save file not compatible.");
        }

        String dungeonFileLine = s.nextLine();

        if (!dungeonFileLine.startsWith(Dungeon.FILENAME_LEADER)) {
            throw new IllegalSaveFormatException("No '" +
                Dungeon.FILENAME_LEADER + 
                "' after version indicator.");
        }

        dungeon = new Dungeon(dungeonFileLine.substring(
            Dungeon.FILENAME_LEADER.length()), false);
        dungeon.restoreState(s);

        s.nextLine();  // Throw away "Adventurer:".
        String currentRoomLine = s.nextLine();
        adventurersCurrentRoom = dungeon.getRoom(
            currentRoomLine.substring(CURRENT_ROOM_LEADER.length()));
        if (s.hasNext()) {
            String inventoryList = s.nextLine().substring(
                INVENTORY_LEADER.length());
            String[] inventoryItems = inventoryList.split(",");
            for (String itemName : inventoryItems) {
                try {
                    addToInventory(dungeon.getItem(itemName));
                } catch (Item.NoItemException e) {
                    throw new IllegalSaveFormatException("No such item '" +
                        itemName + "'");
                }
            }
          
        }
    }

    void store() throws IOException {
        store(DEFAULT_SAVE_FILE);
    }

    void store(String saveName) throws IOException {
        String filename = saveName + SAVE_FILE_EXTENSION;
        PrintWriter w = new PrintWriter(new FileWriter(filename));
        w.println(SAVE_FILE_VERSION);
        dungeon.storeState(w);
        w.println(ADVENTURER_MARKER);
        w.println(CURRENT_ROOM_LEADER + adventurersCurrentRoom.getTitle());
        if (inventory.size() > 0) {
            w.print(INVENTORY_LEADER);
            for (int i=0; i<inventory.size()-1; i++) {
                w.print(inventory.get(i).getPrimaryName() + ",");
            }
            w.println(inventory.get(inventory.size()-1).getPrimaryName());
        }
        w.close();
    }

    void initialize(Dungeon dungeon) {
        this.dungeon = dungeon;
        adventurersCurrentRoom = dungeon.getEntry();
    }

    ArrayList<String> getInventoryNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (Item item : inventory) {
            names.add(item.getPrimaryName());
        }
        return names;
    }

    void addToInventory(Item item) /* throws TooHeavyException */ {
        inventory.add(item);
    if (item.hasTele() ==true){canTele = true;} 
    if (item.hasSwimObj()){canSwim = true;}
    }

    void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    Item getItemInVicinityNamed(String name) throws Item.NoItemException {

        // First, check inventory.
        for (Item item : inventory) {
            if (item.goesBy(name)) {
                return item;
            }
        }

        // Next, check room contents.
        for (Item item : adventurersCurrentRoom.getContents()) {
            if (item.goesBy(name)) {
                return item;
            }
        }

        throw new Item.NoItemException();
    }

    Item getItemFromInventoryNamed(String name) throws Item.NoItemException {

        for (Item item : inventory) {
            if (item.goesBy(name)) {
                return item;
            }
        }
        throw new Item.NoItemException();
    }

    Room getAdventurersCurrentRoom() {
        return adventurersCurrentRoom;
    }

    void setAdventurersCurrentRoom(Room room) {
        adventurersCurrentRoom = room;
      if(room.getHasWater() && canSwim == false){
            setHealth(0);        
        }
    }

    Dungeon getDungeon() {
        return dungeon;
    }
 
    boolean setTele(){
        if(this.instance()== null){
            canTele = false;
        }
        else{
            canTele = canTele;
        }
        return canTele;
    } 

   boolean setSwim(){
        if(this.instance()== null){
            canSwim = false;
        }
        else{
            canSwim = canSwim;
        }
        return canSwim;
    } 
 
    boolean getTele(){
        return canTele;
    } 
    boolean getSwim(){
        return canSwim;
    } 
    /**
     * Gets the current hunger points of adventurer
     * 
     * @return hunger points of user
     */
    int getHunger(){return 0;}
    
    /**
     * Sets the current hunger points of adventurer
     * 
     * @param h what hunger points is being set to 
     */
    void setHunger(int h){}
    
    int getHealth(){
        return health;
    }
    
    void setHealth(int num){
        health = num;
      if(health == 0){this.lost();}
    }
    
    void fixHealth(int num){
        health=health-num;
      if(health == 0){this.lost();}
    }
    void addScore(int num){
        score += num;
    }
    int getScore(){
        System.out.println("Current Score: " + score);
        return score;
    }
    void lost(){//if no one handles events
        System.out.println("Bruff:you have died, you have barked your last bark.");
        System.exit(50);
    }

    void win(){//if no one handles events
     System.out.println("You find yourself victorious.  you have the sudden urge to howl");
     System.out.println("you give into your instincts and howl, all of a sudden you feel it");
     System.out.println("your bones cracking and changing under your skin, you fall to the ground");
     System.out.println("you try to stand, but you realize you can no longer stand on two feet");
     System.out.println("you look around your vision is blurred, everything that you knew has changed");
     System.out.println("everything, looks, smells, tastes, and now even feels different.");
     System.out.println("your eyes start to focus as you look at your hands in disbelief");
     System.out.println("...they are not hands ... they are paws");
     this.getScore();
     System.exit(56);
    }

}
