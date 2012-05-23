package me.sheimi.kwic;

import me.sheimi.kwic.event.EventListener;
import java.util.*;

public class Outputer implements EventListener {

  private TextLines textLines = TextLines.getInstance();
  
  public void run() {
    List<String> lines = textLines.getLines();
    for (String line : lines) {
      System.out.println(line);
    }
  }

}
