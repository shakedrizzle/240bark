/**
 * An abstract class that has subclasses to execute different commands based on user input
 * 
 * @author Brandan Herlinger
 * @verzion 11/8/2016
 */
public abstract class Command {

    /**
     *Abstract method that could return a String for each class that extends Command
     * 
     * @return returns a string depending on which class extends Command 
     */
    abstract String execute();
}
