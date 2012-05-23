package me.sheimi.kwic.event;

import java.util.*;

public class EventManager {

  public static final String INSERT_TO_TEXTLINE_EVENT = "insertToLine";
  public static final String INSERT_TO_TEXTLINES_EVENT = "insertToLines";
  public static final String SORT_DONE = "sortDone";
  
  private HashMap<String, LinkedList<EventListener>> map = new HashMap<String, LinkedList<EventListener>>();
  private static EventManager instance;
  private EventManager() {}
  
  public static EventManager getInstance() {
    if (instance == null) {
      instance = new EventManager();
    }
    return instance;
  }

  public void addListener(String event, EventListener listener) {
    if (map.containsKey(event)) {
      LinkedList<EventListener> list = map.get(event);
      list.add(listener);
    } else {
      LinkedList<EventListener> list = new LinkedList<EventListener>();
      list.add(listener);
      map.put(event, list);
    }
  }

  public void removeListener(String event, EventListener listener) {
    if (map.containsKey(event)) {
      LinkedList<EventListener> list = map.get(event);
      list.remove(listener);
    }
  }

  public void trigger(String event) {
    if (map.containsKey(event)) {
      LinkedList<EventListener> list = map.get(event);
      for (EventListener listener : list) {
        listener.run();
      } 
    }
  }

}
