
/**
 * Prints out the current score
 * 
 * @author Rose Connolly 
 * @version 1.0
 */
public class ScoreCommand extends Command
{
   public String execute() {
    return "Score: " + GameState.instance().getScore();
    }
}
