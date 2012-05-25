package me.sheimi.kwic;

import java.util.*;

public class Outputer extends Filter {

  public Outputer(TextLinePipe input) {
    super(input, null);
  }

  public String onRequest() {
    while (true) {
      String line = input.pull();
      if (line == null)
        break;
      System.out.println(line);
    }
    return null;
  }
}
