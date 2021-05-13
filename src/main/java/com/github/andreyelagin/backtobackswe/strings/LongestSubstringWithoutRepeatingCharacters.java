package com.github.andreyelagin.backtobackswe.strings;

import java.util.HashSet;

// https://backtobackswe.com/platform/content/longest-substring-without-repeating-characters
public class LongestSubstringWithoutRepeatingCharacters {
  public int longestUniqueCharacterSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    
    int left = 0;
    int right = 1;
    int max = 1;

    var set = new HashSet<Character>();
    set.add(s.charAt(0));
    
    while (left < s.length() && right < s.length()) {
      if (left == right) {
        right++;
      }
      var rightAdded = set.add(s.charAt(right));
      if (rightAdded) {
        right++;
        max = Math.max(max, set.size());
      } else {
        set.remove(s.charAt(left++));
      }
    }
    
    return max;
  }
  // A B C A B A D E C
  // left 0, right 2, max 2, [A, B]
  // left 0, right 3, max 3, [A, B, C]
  // left 1, right 3, max 3, [B, C]
  // left 1, right 4, max 3, [B, C, A]
  // left 2, right 4, max 3, [C, A]
  // left 3, right 4, max 3, [C]
  // left 3, right 5, max 3, [C, B]
  // left 3, right 6, max 3, [C, B, A]
}
