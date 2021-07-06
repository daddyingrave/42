package com.github.andreyelagin.leetcode.strings;

import java.util.HashMap;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    
    var sCount = new HashMap<Character, Integer>();
    var tCount = new HashMap<Character, Integer>();
    
    for (int i = 0; i < s.length(); i++) {
      sCount.compute(s.charAt(i), (kek, val) -> val == null ? 1 : val + 1);
      tCount.compute(t.charAt(i), (kek, val) -> val == null ? 1 : val + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      Integer sNum = sCount.get(ch);
      Integer tNum = tCount.get(ch);
      if (sNum == null || tNum == null) {
        return false;
      } else if (!sNum.equals(tNum)) {
        return false;
      }
    }
    
    return true;
  }
}
