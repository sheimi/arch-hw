package me.sheimi.kwic;

public class Control {

  Alphabetizer alph;
  CircularShifter circ;
  Inputer input;
  Outputer output;

  public Control(Inputer input, CircularShifter circ, Alphabetizer alph, Outputer output) {
    this.alph = alph;
    this.circ = circ;
    this.input = input;
    this.output = output;
  }

  public void start() {
    input.start();
  }

  public void updateOLineDone() {
    circ.start();
  }

  public void updateSLineDone() {
    alph.start();
  }

  public void updateALineDone() {
    output.start();
  }

}
