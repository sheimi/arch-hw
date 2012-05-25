package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class CircularShifter {

  ArrayList<String> shifted;

  public CircularShifter(InputStore store) {
    shifted = new ArrayList<String>();
    for (int i = 0; i < store.size(); i++) {
      String line = store.getLine(i);
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
  }

  public String getLine(int i) {
    return shifted.get(i);
  }

  public int size() {
    return shifted.size();
  }
  
}
