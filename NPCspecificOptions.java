
/**
 * Write a description of class NPCspecificOptions here.
 * 
 * @author Rose
 * @version 1
 */
class NPCspecificOptions extends Command
{
    String option;
    String message;
    NPC dog;
    NPCspecificOptions(String option){
        this.option = option;
        if(GameState.instance().getAdventurersCurrentRoom().getNPC()!=null){
            dog = GameState.instance().getAdventurersCurrentRoom().getNPC();//addtoGITHUB
            if(option.equals("talkTo")){
                message = dog.getTalk();
            }
            
            if(option.equals("pet")){
                message = dog.getPet();
            }
            
            if(option.equals("attack")){
                message = dog.getAttack();
            }
        }
        else{message="no one showed up";}
    }
    

    String execute(){
        return message;
    }
}
