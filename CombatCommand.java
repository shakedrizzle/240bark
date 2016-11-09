/**
 * Subclass of Command that handles all combat commands by user
 * 
 * @author Brandan Herlinger
 * @version 11/8/2016
 */
public class CombatCommand extends Command{

    /**
     * Creates a combat instance
     * 
     * @param a what move from user is
     * @param b who is being affected
     */
    CombatCommand(String a, String b){}
    
    /**
     * Prints to the user what happened in combat
     * 
     * @return string depending on combat move
     */
    String execute(){return null;}
    
}
