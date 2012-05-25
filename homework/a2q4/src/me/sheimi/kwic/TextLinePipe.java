package me.sheimi.kwic;

import java.io.*;
import java.util.*;

public class TextLinePipe {

  private Filter in;
  private Filter out;
  
  public TextLinePipe() {
  }

  public void setIn(Filter in) {
    this.in = in;
  }

  public void setOut(Filter out) {
    this.out = out;
  }

  public String pull() {
    return in.pull();
  }
}
