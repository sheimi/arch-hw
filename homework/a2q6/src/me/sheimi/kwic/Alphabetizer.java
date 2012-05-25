package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Alphabetizer extends Knowledge {

  public Alphabetizer(BlackBroad bb) {
    super(bb);
  }

  public void update() {
    String s = bb.getShiftedTextLine();
    if (s == null) {
      bb.updateSortedTextLines();
      return;
    }
    List<String> ss = bb.getSortedTextLines();
    for (int i = 0; i < ss.size(); i++) {
      String c = ss.get(i);
      if (c.compareTo(s) > 0) {
        ss.add(i, s);
        s = null;
        break;
      }
    }
    if (s != null) {
      ss.add(s);
    }
  }

}
