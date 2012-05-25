package me.sheimi.kwic;

import java.util.*;

public class BlackBroad {

  private String inTextLine = "";
  private String shiftedTextLine = "";
  private List<String> sortedTextLines = new ArrayList<String>();

  public Control ctr;

  public BlackBroad(Control ctr) {
    this.ctr = ctr;
  }

  public String getInTextLine() {
    return inTextLine;
  }

  public String getShiftedTextLine() {
    return shiftedTextLine;
  }

  public List<String> getSortedTextLines() {
    return sortedTextLines; 
  } 

  public void updateInTextLine(String in) {
    this.inTextLine = in;
    ctr.updateInterest(Control.inTextLine);
  }

  public void updateShiftedTextLine(String s) {
    this.shiftedTextLine = s;
    ctr.updateInterest(Control.shiftedTextLine);
  }

  public void updateSortedTextLines() {
    ctr.updateInterest(Control.sortedTextLines);
  }

}
