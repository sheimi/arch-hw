package me.sheimi.kwic;

import java.util.*;
import me.sheimi.kwic.event.EventManager;

public class TextLines {
  private static TextLines instance;
  private List<String> lines = new ArrayList<String>();
  private EventManager manager = EventManager.getInstance(); 
  private TextLines(){}

  public static TextLines getInstance() {
    if (instance == null) {
      instance = new TextLines();
    }
    return instance;
  }

  public void insert(String line) {
    lines.add(line);
  }

  public void insertDone() {
    manager.trigger(manager.INSERT_TO_TEXTLINES_EVENT);
  }

  public List<String> getLines() {
    return lines;
  }
}
