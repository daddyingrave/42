package com.github.daddyingrave.leetcode.strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    var charLocations = new HashMap<Character, Integer>();

    int maxLength = 0;
    int left = 0;
    int right = 1;

    charLocations.put(s.charAt(left), left);

    while (right < s.length()) {
      if (charLocations.containsKey(s.charAt(right))) {
        left = Math.max(charLocations.get(s.charAt(right)) + 1, left);
        charLocations.put(s.charAt(right), right);
      }

      charLocations.put(s.charAt(right), right);

      right++;
      maxLength = Math.max(maxLength, right - left);

    }

    return s.length() == 1 ? 1 : maxLength;
  }
}
