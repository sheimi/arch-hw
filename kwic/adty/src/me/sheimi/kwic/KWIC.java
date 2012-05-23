package me.sheimi.kwic;
public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    InputStore input = new InputStore(args[0]);
    CircularShifter shifter = new CircularShifter(input);
    Alphabetizer alph = new Alphabetizer(shifter);
    Outputer o = new Outputer();
    o.print(alph);
  }
}
