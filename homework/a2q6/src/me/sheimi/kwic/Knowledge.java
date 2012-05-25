package me.sheimi.kwic;

public abstract class Knowledge {

  protected BlackBroad bb;

  public Knowledge(BlackBroad bb) {
    this.bb = bb;
  }
  
  public abstract void update();

}
