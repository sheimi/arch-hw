package me.sheimi.kwic;

public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    Pipe p1 = new Pipe();
    Pipe p2 = new Pipe();
    Pipe p3 = new Pipe();
    Inputer input = new Inputer(p1);
    CircularShifter shifter = new CircularShifter(p1, p2);
    Alphabetizer alph = new Alphabetizer(p2, p3);
    Outputer out = new Outputer(p3);
    input.push(args[0]);
  }
}
