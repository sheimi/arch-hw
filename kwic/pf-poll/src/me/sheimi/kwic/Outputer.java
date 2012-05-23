package me.sheimi.kwic;

import java.util.*;

public class Outputer extends Filter {

  public Outputer(Pipe input) {
    super(input, null);
  }

  public String onRequest() {
    while (true) {
      String line = input.poll();
      if (line == null)
        break;
      System.out.println(line);
    }
    return null;
  }
}
