package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Inputer extends Knowledge {

  private String filename;

  public Inputer(String filename, BlackBroad bb) {
    super(bb);
    this.filename = filename;
  }

  public void update() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while (true) {
        line =  reader.readLine();
        bb.updateInTextLine(line);
        if (line == null) {
          break;
        }
      }
    } catch (FileNotFoundException exc) {
      System.err.println("File Not Found");
      System.exit(1);
    } catch (IOException exc) {
      System.err.println("IO Error");
      System.exit(1);
    }
  }
}
