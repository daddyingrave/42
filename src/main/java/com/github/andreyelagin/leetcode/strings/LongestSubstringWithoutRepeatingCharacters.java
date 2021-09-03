package com.github.andreyelagin.leetcode.strings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    
    var set = new HashSet<Character>();
    
    int maxLength = 0;
    int left = 0;
    int right = 1;

    set.add(s.charAt(left));
    
    while (right < s.length()) {
      while (!set.add(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }
      right++;
      maxLength = Math.max(maxLength, right - left);
    }

    return s.length() == 1 ? 1 : maxLength;
  }
}
