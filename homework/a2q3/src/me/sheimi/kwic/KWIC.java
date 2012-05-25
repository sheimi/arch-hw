package me.sheimi.kwic;

import me.sheimi.kwic.event.EventManager;

public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    EventManager manager = EventManager.getInstance();
    manager.addListener(manager.INSERT_TO_TEXTLINE_EVENT, new CircularShifter());
    manager.addListener(manager.INSERT_TO_TEXTLINES_EVENT, new Alphabetizer());
    manager.addListener(manager.SORT_DONE, new Outputer());
    Inputer in = new Inputer(args[0]); 
  }
}
