package me.sheimi.kwic;

import java.util.*;

public class Alphabetizer extends Filter {

  private List<String> list = new ArrayList<String>();

  public Alphabetizer(Pipe input, Pipe output) {
    super(input, output);
  }

  public void onReceive(String line) {
    if (line == null) {
      Collections.sort(list);
      for (String s: list) {
        output.push(s);
      }
    } else {
      list.add(line);
    }
  }

}
