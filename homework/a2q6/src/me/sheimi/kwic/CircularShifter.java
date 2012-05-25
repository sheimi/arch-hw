package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class CircularShifter extends Knowledge {

  public CircularShifter(BlackBroad bb) {
    super(bb);
  }
  
  public void update() {
    String line = bb.getInTextLine();
    bb.updateShiftedTextLine(line);
    if (line == null)
      return;
    boolean blank = false;
    for (int j = 0; j < line.length(); j++) {
      if (blank && line.charAt(j) != ' ') {
        String s = line.substring(j) + ' ' + line.substring(0, j - 1);
        blank = false;
        bb.updateShiftedTextLine(s);
      }
      if (line.charAt(j) == ' ' && !blank) {
        blank = true;
      }
    }
  }
}
