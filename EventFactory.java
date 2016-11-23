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
    private Hashtable<String,String> events;
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
	String first = "";
	events = name.getEventCommands();
	if (!events.isEmpty()) {
            String Everbs = events.get(event);
            String[] Enouns = Everbs.split(",");
            for(String word:Enouns){
                int firstbananna = word.indexOf("(");
                int lastbananna = word.indexOf(")");
		 if(word.contains("(")){
                    first = word.substring(0,firstbananna);
                }else
                first=word;
	    
        if(event.contains("Die")){return new DieEvent();}
        if(event.contains("Disappear")){return new DisappearEvent();}
        if(event.contains("Win")){return new WinEvent();}
        if(event.contains("Score")){return new ScoreEvent(Integer.valueOf(word.substring(firstbananna,lastbananna)));}
	if(event.contains("Wound")){return new WoundEvent(Integer.valueOf(word.substring(firstbananna,lastbananna)));}
	    }
	}
        return new UnknownEvent();
	        
    }
	    
}
