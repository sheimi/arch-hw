package me.sheimi.kwic;

import java.io.*;
import me.sheimi.kwic.event.EventManager;

public class Inputer {

  private TextLine textLine = TextLine.getInstance();
  private EventManager manager = EventManager.getInstance(); 

  public Inputer(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while (true) {
        line =  reader.readLine();
        if (line != null) {
          textLine.insert(line);
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
    manager.trigger(manager.INSERT_TO_TEXTLINES_EVENT);
  }
}
