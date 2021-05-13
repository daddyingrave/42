package com.github.andreyelagin.backtobackswe.strings;

import java.util.HashSet;

// https://backtobackswe.com/platform/content/longest-substring-without-repeating-characters
public class LongestSubstringWithoutRepeatingCharacters {
  public int longestUniqueCharacterSubstring(String s) {
    int left = 0;
    int right = 0;
    int max = 0;
    int[] matches = new int[128];

    while (right < s.length()) {
      left = Math.max(left, matches[s.charAt(right)]);
      matches[s.charAt(right)] = right + 1;
      max = Math.max(right - left + 1, max);
      right++;
    }

    return max;
  }
  // A B C A B A D E C
  // left 0, right 0, max 0, []
  // left 0, right 1, max 1, [A -> 1]
  // left 0, right 2, max 2, [A -> 1, B - 2]

  public int longestUniqueCharacterSubstringMy(String s) {
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
}
