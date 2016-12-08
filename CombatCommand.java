/**
 * Subclass of Command that handles all combat commands by user
 * 
 * @author Brandan Herlinger
 * @version 11/8/2016
 */
public class CombatCommand extends Command{
    int attack;
    String target;

    /**
     * Creates a combat instance
     * 
     * @param attack what move from user is
     * @param target who is being affected
     */
    CombatCommand(int attack, String target){
        this.attack = attack;
        this.target = target;
    
    }
    
    /**
     * Prints to the user what happened in combat
     * 
     * @return string depending on combat move
     */
    String execute()
    {
        NPC target;
        target = GameState.instance().getAdventurersCurrentRoom().getNPC(this.target);
        if (target == null)
            return "There is no"+this.target+" here\n";  
        String fight = target.takeHit(this.attack);
        return fight;
        
        
    }
    
}
