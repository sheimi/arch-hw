package me.sheimi.kwic;

import java.io.*;

public class Inputer extends Filter {

  BufferedReader reader;

  public Inputer(String filename, Pipe output) {
    super(null, output);
    try {
      reader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException exc) {
      System.err.println("File Not Found");
      System.exit(1);
    }
  }

  protected String onRequest() {
    String line = null;
    try {
      line =  reader.readLine();
    } catch (IOException exc) {
      System.err.println("IO Error");
      System.exit(1);
    }
    return line;
  }
}
