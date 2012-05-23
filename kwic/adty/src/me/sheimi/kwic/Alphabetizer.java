package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class Alphabetizer {
  
  ArrayList<String> store;

  public Alphabetizer(CircularShifter shifter) {
    store = new ArrayList<String>();
    for (int i = 0; i < shifter.size(); i++) {
      store.add(shifter.getLine(i));
    }
    Collections.sort(store);
  }

  public int size() {
    return store.size();
  } 

  public String getLine(int i) {
    return store.get(i);
  }
}
