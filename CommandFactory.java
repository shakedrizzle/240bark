
 

import java.util.List;
import java.util.Arrays;

public class CommandFactory {

    private static CommandFactory theInstance;
    public static List<String> MOVEMENT_COMMANDS = 
        Arrays.asList("n","w","e","s","u","d" );

    public static synchronized CommandFactory instance() {
        if (theInstance == null) {
            theInstance = new CommandFactory();
        }
        return theInstance;
    }

    private CommandFactory() {
    }

    public Command parse(String command) {
        String parts[] = command.split(" ");
        String verb = parts[0];
        String noun = parts.length >= 2 ? parts[1] : "";
        if (verb.equals("save")) {
            return new SaveCommand(noun);
        }
        if (verb.equals("score")) {
            return new ScoreCommand();
        }
        if (verb.equals("take")) {
            return new TakeCommand(noun);
        }
        if (verb.equals("drop")) {
            return new DropCommand(noun);
        }
        if (verb.equals("punch") || verb.equals("Punch")) {
            if (noun.equals("")){
                System.out.println("You must pick a target to attack.");
                System.out.println("The NPCs in this room are: "+GameState.instance().getAdventurersCurrentRoom().getNPC());
                return new UnknownCommand(command);
            }      
            return new CombatCommand(50, noun);
        }
        if (verb.equals("kick") || verb.equals("Kick")) {
            if (noun.equals("")){
                System.out.println("You must pick a target to attack.");
                System.out.println("The NPCs in this room are: "+GameState.instance().getAdventurersCurrentRoom().getNPC());
                return new UnknownCommand(command);
            }      
            return new CombatCommand(100, noun);
        }
        if (verb.equals("i") || verb.equals("inventory")) {
            return new InventoryCommand();
        }
        if (MOVEMENT_COMMANDS.contains(verb)) {
            return new MovementCommand(verb);
        }
      if (parts.length == 2) {
            if (verb.equals("teleport")){
                return new TeleportCommand(noun);}
                else{
            return new ItemSpecificCommand(verb, noun);}
        }
        if(verb.equals("h") || verb.equals("health")){
            return new HealthCommand();
        }
        if (verb.equals("talkTo") || verb.equals("pet") || verb.equals("attack")){
            return new NPCspecificOptions(verb);
        }
        return new UnknownCommand(command);
    }
}
