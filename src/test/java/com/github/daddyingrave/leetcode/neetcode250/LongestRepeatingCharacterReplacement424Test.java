package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestRepeatingCharacterReplacement424Test {
  class Solution {
    public int characterReplacement(String s, int k) {
      int[] letters = new int[26];
      int maxFrequency = 0;
      int result = 0;
      int left = 0;
      int right = 0;

      while (right < s.length()) {
        char cur = s.charAt(right);
        letters[cur - 'A']++;
        maxFrequency = Math.max(maxFrequency, letters[cur - 'A']);

        while ((right - left +1) - maxFrequency > k) {
          letters[s.charAt(left) - 'A']--;
          left++;
        }

        result = Math.max(result, right - left + 1);
        right++;
      }

      return result;
    }
  }

  @Test
  void test() {
    assertEquals(4, new Solution().characterReplacement("ABAB", 2));
    assertEquals(4, new Solution().characterReplacement("AABABBA", 1));
  }
}
