package me.sheimi.kwic;

import java.util.*;

public class Outputer extends Filter {

  public Outputer(Pipe input) {
    super(input, null);
  }

  public void onReceive(String line) {
    System.out.println(line);
  }
}
