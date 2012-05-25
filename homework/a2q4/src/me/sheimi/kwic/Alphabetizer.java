package me.sheimi.kwic;

import java.util.*;

public class Alphabetizer extends Filter {

  Queue<String> list; 

  public Alphabetizer(TextLinePipe input, TextLinePipe output) {
    super(input, output);
  }

  public String onRequest() {
    if (list == null) {
      list = new LinkedList<String>();
      while (true) {
        String line = input.pull();
        if (line == null)
          break;
        list.offer(line); 
      }
      Collections.sort((LinkedList<String>)list);
    }
    if (list.isEmpty()) {
      return null;
    }
    return list.poll();
  }
}
