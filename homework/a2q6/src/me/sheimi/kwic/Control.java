package me.sheimi.kwic;

import java.util.*;

public class Control {

  public final static int inTextLine = 0;
  public final static int shiftedTextLine = 1;
  public final static int sortedTextLines = 2;

  private Knowledge[] klgs = new Knowledge[3];

  public void setInterest(int interest, Knowledge k) {
    klgs[interest] = k;
  }

  public void updateInterest(int interest) {
    klgs[interest].update();
  }

}
