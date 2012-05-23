package me.sheimi.kwic;

import java.util.*;
import java.io.*;

public class KWIC {

  private ArrayList<String> textLines;
  private int[][] shiftedLineIndexes;
  private int[][] sortedLineIndexes;

  private void input(String filename) {
    textLines = new ArrayList<String>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while (true) {
        line =  reader.readLine();
        if (line != null) {
          textLines.add(line);
        } else {
          break;
        }
      }
    } catch (FileNotFoundException exc) {
      System.err.println("File Not Found");
      System.exit(1);
    } catch (IOException exc) {
      System.err.println("IO Error");
      System.exit(1);
    }
  }

  private void circularShift() {
    ArrayList<Integer> wi = new ArrayList<Integer>();
    ArrayList<Integer> li = new ArrayList<Integer>();
    for (int i = 0; i < textLines.size(); i++) {
      String line = textLines.get(i);
      boolean blank = true;
      for (int j = 0; j < line.length(); j++) {
        if (blank && line.charAt(j) != ' ') {
          wi.add(new Integer(j));
          li.add(new Integer(i));
          blank = false;
        }
        if (line.charAt(j) == ' ' && !blank) {
          blank = true;
        }
      }
    }
    shiftedLineIndexes = new int[wi.size()][2];
    for (int i = 0; i < wi.size(); i++) {
      shiftedLineIndexes[i][0] = li.get(i);
      shiftedLineIndexes[i][1] = wi.get(i);
    }
  }

  private void alphabetizer() {
    sortedLineIndexes = shiftedLineIndexes.clone();
    Arrays.sort(sortedLineIndexes, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        String as = textLines.get(a[0]);
        String asn = as.substring(a[1]) + ' ' + as.substring(0, a[1]);
        String bs = textLines.get(b[0]);
        String bsn = bs.substring(b[1]) + ' ' + bs.substring(0, b[1]);
        return asn.compareTo(bsn);
      }
    });
  }

  private void output() {
    for (int i = 0; i < sortedLineIndexes.length; i++) {
      String s = textLines.get(sortedLineIndexes[i][0]); 
      if (sortedLineIndexes[i][1] != 0) {
        String sn = s.substring(sortedLineIndexes[i][1]) + ' ' + s.substring(0, sortedLineIndexes[i][1] - 1);
        System.out.println(sn);
      } else {
        System.out.println(s);
      }
    }
  }

  public static void main(String [] args) {
    if (args.length != 1) {
      System.err.println("KWIC Usage: java -jar kwic.jar file_name");
      System.exit(1);
    }
    KWIC kwic = new KWIC();
    kwic.input(args[0]);
    kwic.circularShift();
    kwic.alphabetizer();
    kwic.output();
  }
}
