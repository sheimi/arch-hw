package me.sheimi.kwic;
public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    BlackBroad bb = new BlackBroad();
    Inputer input = new Inputer(args[0], bb);
    CircularShifter shifter = new CircularShifter(bb);
    Alphabetizer alph = new Alphabetizer(bb);
    Outputer output = new Outputer(bb);
    Control ctr = new Control(input, shifter, alph, output);
    bb.setCtr(ctr);
    ctr.start();
  }
}
