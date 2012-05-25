package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class InputStore {

  private ArrayList<String> store;

  public InputStore(String filename) {
    store = new ArrayList<String>();
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
  }

  public String getLine(int line) {
    return store.get(line);
  }

  public int size() {
    return store.size();
  }

}
