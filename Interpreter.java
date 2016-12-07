
 

import java.util.Scanner;


public class Interpreter {

   private static GameState state; 
    public static String USAGE_MSG = "Usage: Interpreter borkFile.bork|saveFile.sav.";
    public static void main(String args[]) {
        String command;
        Scanner commandLine = new Scanner(System.in);
        System.out.println("insert .bork or .sav file:");
        command=commandLine.next();
        try {
            state = GameState.instance();
            if (command.endsWith(".bork")) {
                state.initialize(new Dungeon(command,true));
                System.out.println("\nWelcome to " + 
                    state.getDungeon().getName() + "!");
            } else if (command.endsWith(".sav")) {
                state.restore(command);
                System.out.println("\nWelcome back to " + 
                    state.getDungeon().getName() + "!");
            } else {
                System.err.println(USAGE_MSG);
                System.exit(2);
            }
            System.out.print("\n" + state.getAdventurersCurrentRoom().describe() + "\n");
            command = promptUser(commandLine);
            command = promptUser(commandLine);
            while (!command.equals("q")) {
                System.out.print(CommandFactory.instance().parse(command).execute());
                command = promptUser(commandLine);
             if(state.getAdventurersCurrentRoom()==(state.getDungeon().getEntry()))//player drowns as soon as they move
                try{
                    if(state.getItemFromInventoryNamed("floatDevice")==null ||
                    state.getItemFromInventoryNamed("lifeJacket")== null ||
                    state.getItemFromInventoryNamed("goggles")== null) {
                       
                    }
                }catch (Item.NoItemException e){
                    System.out.print("YOU JUST SADLY DROWNED :( ");
                    String q = "q";
                    command= q;
                }
                    
            }
            System.out.println("Bye!");
        } catch(Exception e) { 
            e.printStackTrace(); 
        }
    }

    private static String promptUser(Scanner commandLine) {
        System.out.print("> ");
        return commandLine.nextLine();
    }

}
