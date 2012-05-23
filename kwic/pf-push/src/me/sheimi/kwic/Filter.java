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

  public void push(String line) {
    onReceive(line);
  }

  abstract protected void onReceive(String line); 
  
}
