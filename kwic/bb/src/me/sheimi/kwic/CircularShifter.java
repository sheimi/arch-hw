package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class CircularShifter {

  BlackBroad bb;
  
  public CircularShifter(BlackBroad bb) {
    this.bb = bb;
  }
  
  public void start() {
    List<String> oline = bb.getOLine();
    List<String> shifted = bb.getSLine();
    for (String line : oline) {
      shifted.add(line);
      boolean blank = false;
      for (int j = 0; j < line.length(); j++) {
        if (blank && line.charAt(j) != ' ') {
          String s = line.substring(j) + ' ' + line.substring(0, j - 1);
          blank = false;
          shifted.add(s);
        }
        if (line.charAt(j) == ' ' && !blank) {
          blank = true;
        }
      }
    }
    bb.updateSLine();
  }
}
