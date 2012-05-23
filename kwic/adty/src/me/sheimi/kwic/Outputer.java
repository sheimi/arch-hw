package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Outputer {

  public void print(Alphabetizer alph) {
    for (int i = 0; i < alph.size(); i++) {
      System.out.println(alph.getLine(i));
    }
  }

}
