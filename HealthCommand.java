/**
 * Subclass of Command that handles all health related commands by user
 * 
 * @author Brandan Herlinger
 * @version 11/8/2016
 */
public class HealthCommand extends Command{
    
    /**
     * Creates a health instance
     */
    HealthCommand(){}
    
    /**
     * Prints to the user what their current health is at
     * 
     * @return string depending on current health
     */
    String execute(){
       int health = GameState.instance().getHealth();
        if(health>=75){
            return ("You are in good health with lots of energy!");
        }else if(health>=50){
            return ("You are not very strong, its probably one of those days");
        }else if(health>=25){
            return("I suggest you think of plan B because you are almost out of health!");
        }else if(health>=10){
            return("Dudeeee, act on plan B!, you are about to faint");
        }else if(health>=5){
            return("You've got one drip on blood in you, you are lucky to be standing");
        }else if(health>=0){
            return("Adios amigo/amiga, you are dying!");
        }
        else{
             System.exit(0);
            }
        return null;
    } 
}
