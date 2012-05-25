package me.sheimi.kwic;
public class KWIC {
  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    Control ctr = new Control();
    BlackBroad bb = new BlackBroad(ctr);
    Inputer i = new Inputer(args[0], bb);
    Outputer o = new Outputer(bb);
    Alphabetizer a = new Alphabetizer(bb);
    CircularShifter c = new CircularShifter(bb);
    ctr.setInterest(Control.inTextLine, c);
    ctr.setInterest(Control.shiftedTextLine, a);
    ctr.setInterest(Control.sortedTextLines, o);
    i.update();
  }
}
