package me.sheimi.kwic;

import me.sheimi.kwic.event.EventListener;
import me.sheimi.kwic.event.EventManager;
import java.util.*;

public class Alphabetizer implements EventListener {

  private TextLines textLines = TextLines.getInstance();
  private EventManager manager = EventManager.getInstance();

  public void run() {
    List<String> lines = textLines.getLines();
    Collections.sort(lines);
    manager.trigger(manager.SORT_DONE);
  }

}
