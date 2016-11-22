
/**
 * This subclass of event ends the game. Triggered if the final boss is defeated.
 * 
 * @author Matt Rychlik
 * @version 11/06/2016
 */
public class WinEvent extends Event
{
    private boolean won;

    /**
     * Constructor for objects of class WinEvent
     */
    public WinEvent(){}

    /**
     * If the final boss is defeated, the player wins the game.
     */
   String execute(){
     System.out.println("You find yourself victorious.  you have the sudden urge to howl");
     System.out.println("you give into your instincts and howl, all of a sudden you feel it");
     System.out.println("your bones cracking and changing under your skin, you fall to the ground");
     System.out.println("you try to stand, but you realize you can no longer stand on two feet");
     System.out.println("you look around your vision is blurred, everything that you knew has changed");
     System.out.println("everything, looks, smells, tastes, and now even feels different.");
     System.out.println("your eyes start to focus as you look at your hands in disbelief");
     System.out.println("...they are not hands ... they are paws");
     GameState.instance().getScore();
     return "bork, bork, bark";
   }
}
