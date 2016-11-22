
/**
 * Prints out the current score
 * 
 * @author Rose Connolly 
 * @version 1.0
 */
public class ScoreCommand extends Command
{
   public String execute() {
        //return "Score: " + GameState.instance().getScore();
        int score = GameState.instance().getScore();
        String s1 = "You have accumulated " + score + " points. ";
        if(score>=70){
            return (s1 + "You are an expert adventure!!");
        }else if(score>=60){
            return (s1 + "You are actually doing pretty good!");
        }else if(score>=50){
            return(s1 + "Congrats you are average.");
        }else if(score>=30){
            return(s1 + "It doesn't get any easier from here");
        }else if(score>=20){
            return(s1 + "You are starting to get the hang of this.");
        }else if(score>=0){
            return(s1 + "You are the worst adventurer ever...");
        }
        else{
            return null;
        } 
    }
}
