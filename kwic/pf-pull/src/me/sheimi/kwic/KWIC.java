package me.sheimi.kwic;

public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    TextLinePipe p1 = new TextLinePipe();
    TextLinePipe p2 = new TextLinePipe();
    TextLinePipe p3 = new TextLinePipe();
    Inputer input = new Inputer(args[0], p1);
    CircularShifter shifter = new CircularShifter(p1, p2);
    Alphabetizer alph = new Alphabetizer(p2, p3);
    Outputer out = new Outputer(p3);
    out.pull();
  }
}
