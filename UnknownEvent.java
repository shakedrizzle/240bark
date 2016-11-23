
/**
 * incase something goes wrong
 * to avoid null pointer exceptions
 * 
 * @author Rose 
 * @version 1.0
 */
public class UnknownEvent extends Event
{
    void execute() {
        System.out.print( "Bork");
    }
}
