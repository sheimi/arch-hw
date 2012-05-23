package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Outputer {

  private BlackBroad bb;

  public Outputer(BlackBroad bb) {
    this.bb = bb;
  }

  public void start() {
    List<String> ss = bb.getALine();
    for (String s : ss) {
      System.out.println(s);
    }
  }

}
