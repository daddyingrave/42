package com.github.andreyelagin.ctci.arraysandstrings;

public class CheckPermutation {
  public boolean permutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int[] letterCount = new int[128];
    for (int i = 0; i < s1.length(); i++) {
      letterCount[s1.charAt(i)]++;
    }

    for (int i = 0; i < s2.length(); i++) {
      letterCount[s2.charAt(i)]--;
    }

    for (int count : letterCount) {
      if (count != 0) {
        return false;
      }
    }
    
    return true;
  }
}
