package com.github.andreyelagin.ctci.arraysandstrings;

import java.util.HashMap;

public class PalindromePermutation {
  public boolean isPalindromePermutation(String str) {
    var dict = new HashMap<Character, Integer>();
    int lettersCount = 0;
    
    for (int i = 0; i < str.length(); i++) {
      var key = Character.toLowerCase(str.charAt(i));
      if (!Character.isLetter(key)) {
        continue;
      }
      lettersCount++;
      dict.compute(key, (k, v) -> v == null ? 1 : ++v);
    }
    
    if (lettersCount % 2 == 0) {
      return dict.values().stream().allMatch(v -> v % 2 == 0);
    } else {
      int ones = 0;
      for (Integer count : dict.values()) {
        if (count == 1) {
          if (ones > 0) {
            return false;
          } else {
            ones++;
          }
        } else if (count % 2 != 0) {
          return false;
        }
      }
    }
    
    return true;
  }
}
