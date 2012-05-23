package me.sheimi.kwic;

abstract public class Filter {

  protected Pipe input;
  protected Pipe output;

  public Filter(Pipe input, Pipe output) {
    this.input = input;
    this.output = output;
    if (input != null)
      input.setOut(this);
    if (output != null)
      output.setIn(this);
  } 

  public String poll() {
    return onRequest();
  }

  abstract protected String onRequest(); 
  
}
