package me.sheimi.kwic;

import java.util.*;

public class BlackBroad {

  private List<String> o_line = new ArrayList<String>();
  private List<String> s_line = new ArrayList<String>();
  private List<String> a_line = new ArrayList<String>();

  public Control ctr;

  public void setCtr(Control ctr) {
    this.ctr = ctr;
  }

  public void updateOLine() {
    ctr.updateOLineDone();
  }

  public List<String> getOLine() {
    return o_line;
  }

  public void updateSLine() {
    ctr.updateSLineDone();
  }

  public List<String> getSLine() {
    return s_line;
  }

  public void updateALine() {
    ctr.updateALineDone();
  }

  public List<String> getALine() {
    return a_line;
  }

}
