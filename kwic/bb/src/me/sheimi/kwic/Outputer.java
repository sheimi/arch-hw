package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Outputer extends Knowledge {

  public Outputer(BlackBroad bb) {
    super(bb);
  }

  public void update() {
    List<String> ss = bb.getSortedTextLines();
    for (String s : ss) {
      System.out.println(s);
    }
  }

}
