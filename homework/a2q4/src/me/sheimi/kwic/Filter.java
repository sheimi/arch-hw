package me.sheimi.kwic;

abstract public class Filter {

  protected TextLinePipe input;
  protected TextLinePipe output;

  public Filter(TextLinePipe input, TextLinePipe output) {
    this.input = input;
    this.output = output;
    if (input != null)
      input.setOut(this);
    if (output != null)
      output.setIn(this);
  } 

  public String pull() {
    return onRequest();
  }

  abstract protected String onRequest(); 
  
}
