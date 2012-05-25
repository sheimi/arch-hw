package me.sheimi.kwic;

import java.util.*;
import me.sheimi.kwic.event.EventManager;

public class TextLine {
  private static TextLine instance;
  private Queue<String> lineCache = new LinkedList<String>();
  private EventManager manager = EventManager.getInstance(); 
  private TextLine(){}

  public static TextLine getInstance() {
    if (instance == null) {
      instance = new TextLine();
    }
    return instance;
  }

  public void insert(String line) {
    lineCache.offer(line);
    manager.trigger(EventManager.INSERT_TO_TEXTLINE_EVENT);
  }

  public String get() {
    return lineCache.poll();
  }

}
