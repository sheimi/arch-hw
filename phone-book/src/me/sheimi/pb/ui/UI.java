package me.sheimi.pb.ui;

import java.io.*;

public abstract class UI {
  public abstract void display();

  protected String getInputLine() {
    BufferedReader bir = new BufferedReader(new InputStreamReader(System.in));
    String s = null;
    try {
      s = bir.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return s;
  }

  protected void hint(String h, int indent, boolean newline) {
    repeat(" ", indent, false);
    System.out.print(h);
    if (newline) {
      System.out.println();
    }
  }

  protected void hint(String h, boolean newline) {
    hint(h, 0, newline);
  }

  protected void hint(String h, int indent) {
    hint(h, indent, true);
  }

  protected void hint(String h) {
    hint(h, true);
  }

  protected String hintInput(String h) {
    hint(h, true);
    return getInputLine();
  }

  protected void repeat(String s, int num, boolean newline) {
    for (int i = 0; i < num; i++) {
      System.out.print(s);
    }
    if (newline) {
      System.out.println();
    }
  }
  
  protected void seperator() {
    repeat("-", 50, true);
  }

}
