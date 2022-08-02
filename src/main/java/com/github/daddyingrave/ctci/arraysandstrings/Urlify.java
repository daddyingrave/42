package com.github.daddyingrave.ctci.arraysandstrings;

public class Urlify {
  public char[] urlEncode(char[] string, int stringLength) {
    int lastSpace = string.length - 1;
    int lastSpot = stringLength - 1;
    
    for (int i = stringLength - 1; i > 0; i--) {
      if (string[i] != ' ') {
        int[] newPoints = moveWord(string, lastSpot, lastSpace);
        lastSpot = newPoints[0];
        lastSpace = newPoints[1];
      }
    }
    
    return string;
  }
  
  private int[] moveWord(char[] string, int lastSpot, int lastSpace) {
    int start = lastSpot;
    while (start > 0 && string[start] != ' ') {
      string[lastSpace--] = string[start];
      start--;
    }

    if (start > 0) {
      string[lastSpace--] = '0';
      string[lastSpace--] = '2';
      string[lastSpace] = '%';
    }
    
    return new int[]{start - 1, lastSpace - 1} ;
  }
}
