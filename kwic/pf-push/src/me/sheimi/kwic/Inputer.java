package me.sheimi.kwic;

import java.io.*;

public class Inputer extends Filter {

  public Inputer(Pipe output) {
    super(null, output);
  }

  protected void onReceive(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while (true) {
        line =  reader.readLine();
        if (line != null) {
          output.push(line);
        } else {
          output.close();
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
