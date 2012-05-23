package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Alphabetizer {

  BlackBroad bb;
  
  public Alphabetizer(BlackBroad bb) {
    this.bb = bb;
  }

  public void start() {
    List<String> sline = bb.getSLine();
    List<String> aline = bb.getALine();
    for (String line : sline){
      aline.add(line);
    }
    Collections.sort(aline);
    bb.updateALine();
  }

}
