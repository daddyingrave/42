package com.github.andreyelagin.ctci.arraysandstrings;

public class IsUnique {
  public boolean allUnique(String str) {
    if (str.length() > 128) {
      return false;
    }
    
    boolean[] alphabet = new boolean[128];

    for (int i = 0; i < str.length(); i++) {
      int cur = (int) str.charAt(i);
      if (alphabet[cur]) {
        return false;
      } else {
        alphabet[cur] = true;
      }
    }
    
    return true;
  }
}
