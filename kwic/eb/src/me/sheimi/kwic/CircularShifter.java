package me.sheimi.kwic;

import me.sheimi.kwic.event.EventListener;

public class CircularShifter implements EventListener {

  private TextLine textLine = TextLine.getInstance();
  private TextLines textLines = TextLines.getInstance();

  public void run() {
    String line = textLine.get();
    textLines.insert(line);
    boolean blank = false;
    for (int j = 0; j < line.length(); j++) {
      if (blank && line.charAt(j) != ' ') {
        String s = line.substring(j) + ' ' + line.substring(0, j - 1);
        blank = false;
        textLines.insert(s);
      }
      if (line.charAt(j) == ' ' && !blank) {
        blank = true;
      }
    }
  }

}
