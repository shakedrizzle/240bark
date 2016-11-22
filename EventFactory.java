import java.util.*;
/**
 * Class EventFactory keeps track of counters specific to an event and calls events when certain
 * criteria are met with those counters.
 * 
 * @author Rose Connolly
 * @version 1.0
 */
public class EventFactory
{
    public static EventFactory theInstance;
    /**
     * method that creates an EventFactory if none exists  
     * 
     * @return  EventFactory  whether it be a new factory or a new one
     */
    public static synchronized EventFactory instance(){
        if (theInstance == null) {
            theInstance = new EventFactory();
        }
        return theInstance;
    }

    /**
     * this method looks for specific cues and calls the events that get cued
     * this is the method that "throws the bone" if you will, to the other Event classes
     * 
     * @param event & name for the specific Event
     * @return the Event that is called
     */
    public Event parse(String event, Item name){
        if(event.contains("Die")){return new DieEvent();}
        if(event.contains("Disappear")){return new DisappearEvent();}
        if(event.contains("Win")){return new WinEvent();}
        if(event.contains("Score")){return new ScoreEvent(num);}
        return new UnknownEvent();
    }
	    
}
