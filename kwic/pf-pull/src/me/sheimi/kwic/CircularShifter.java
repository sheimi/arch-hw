package me.sheimi.kwic;

import java.util.*;

public class CircularShifter extends Filter {

  private Queue<String> queue = new LinkedList<String>();

  public CircularShifter(TextLinePipe input, TextLinePipe output) {
    super(input, output);
  }

  public String onRequest() {
    if (queue.isEmpty()) {
      String line = input.pull();
      if (line == null)
        return line;
      boolean blank = false;
      for (int j = 0; j < line.length(); j++) {
        if (blank && line.charAt(j) != ' ') {
          String s = line.substring(j) + ' ' + line.substring(0, j - 1);
          blank = false;
          queue.offer(s);
        }
        if (line.charAt(j) == ' ' && !blank) {
          blank = true;
        }
      }
      return line;
    }
    return queue.poll();
  }
}
