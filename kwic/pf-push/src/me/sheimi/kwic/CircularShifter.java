package me.sheimi.kwic;

public class CircularShifter extends Filter {

  public CircularShifter(TextLinePipe input, TextLinePipe output) {
    super(input, output);
  }

  public void onReceive(String line) {
    if (line == null) {
      output.close();
      return;
    }
    output.push(line);
    boolean blank = false;
    for (int j = 0; j < line.length(); j++) {
      if (blank && line.charAt(j) != ' ') {
        String s = line.substring(j) + ' ' + line.substring(0, j - 1);
        blank = false;
        output.push(s);
      }
      if (line.charAt(j) == ' ' && !blank) {
        blank = true;
      }
    }
  }

}
