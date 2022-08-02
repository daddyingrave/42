package com.github.daddyingrave.backtobackswe.strings;

import java.util.*;

public class WordSubsets {
  public List<String> wordSubsets(List<String> A, List<String> B) {
    int[] bLetters = new int[26];
    for (String s : B) {
      int[] curBLetters = countLetters(s);
      for (int i = 0; i < 26; i++) {
        bLetters[i] = Math.max(bLetters[i], curBLetters[i]);
      }
    }

    var result = new ArrayList<String>();

    for (String s : A) {
      int[] aLetters = countLetters(s);
      boolean universal = true;
      for (int i = 0; i < 26; i++) {
        if (aLetters[i] < bLetters[i]) {
          universal = false;
          break;
        }
      }
      if (universal) {
        result.add(s);
      }
    }
    
    return result;
  }
  
  private int[] countLetters(String s) {
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[Character.toLowerCase(s.charAt(i)) - 'a']++;
    }
    return count;
  }
}
