package me.sheimi.kwic;

import java.util.*;

public class Alphabetizer extends Filter {

  Queue<String> list; 

  public Alphabetizer(Pipe input, Pipe output) {
    super(input, output);
  }

  public String onRequest() {
    if (list == null) {
      list = new LinkedList<String>();
      while (true) {
        String line = input.poll();
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
