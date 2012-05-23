package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Inputer {

  private BlackBroad bb;
  private String filename;

  public Inputer(String filename, BlackBroad bb) {
    this.bb = bb;
    this.filename = filename;
  }

  public void start() {
    List<String> store = bb.getOLine();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while (true) {
        line =  reader.readLine();
        if (line != null) {
          store.add(line);
        } else {
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
    bb.updateOLine();
  }
}
