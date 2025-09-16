package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringWithoutRepeatingCharacters3Test {
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.isEmpty()) {
        return 0;
      }
      if (s.length() == 1) {
        return 1;
      }

      int max = 1;
      var map = new HashMap<Character, Integer>();
      map.put(s.charAt(0), 1);

      int left = 0;
      int right = left + 1;

      while (right < s.length()) {
        if (map.getOrDefault(s.charAt(right), 0) == 0) {
          map.put(s.charAt(right), 1);
          max = Math.max(max, right - left + 1);
          right++;
        } else {
          map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
          left++;
        }
      }

      return max;
    }
  }

  @Test
  void test() {
    assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
  }
}
