package me.sheimi.kwic;

import me.sheimi.kwic.event.EventListener;
import java.util.*;

public class Alphabetizer implements EventListener {

  private TextLines textLines = TextLines.getInstance();

  public void run() {
    List<String> lines = textLines.getLines();
    String s = null;
    if (lines.size() != 1) {
      s = lines.remove(lines.size() - 1);
      for (int i = 0; i < lines.size(); i++) {
        String tmp = lines.get(i);
        if (tmp.compareTo(s) > 0) {
          lines.add(i, s);
          s = null;
          break;
        }
      }
      if (s != null) {
        lines.add(s);
      }
    }
  }

}
