package me.sheimi.kwic;

import java.io.*;
import java.util.*;

public class Pipe {

  private Filter in;
  private Filter out;
  
  public Pipe() {
  }

  public void setIn(Filter in) {
    this.in = in;
  }

  public void setOut(Filter out) {
    this.out = out;
  }

  public void push(String line) {
    out.push(line);
  }

  public void close() {
    out.push(null);
  }
}
