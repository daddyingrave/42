package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumWindowSubstring76Test {
  class Solution {
    public String minWindow(String s, String t) {
      var countsT = new HashMap<Character, Integer>();
      var window = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
        countsT.merge(t.charAt(i), 1, Integer::sum);
      }

      int minLeft = 0;
      int minRight = Integer.MAX_VALUE - 1;
      int have = 0;
      int need = countsT.size();

      int left = 0;
      int right = 0;
      while (right < s.length()) {
        char cur = s.charAt(right);
        window.merge(cur, 1, Integer::sum);

        if (countsT.containsKey(cur) && window.get(cur).equals(countsT.get(cur))) {
          have++;
        }

        while (need == have) {
          if (right - left + 1 < minRight - minLeft + 1) {
            minRight = right;
            minLeft = left;
          }

          char curLeft = s.charAt(left);
          window.put(curLeft, window.get(curLeft) - 1);
          if (countsT.containsKey(curLeft) && window.get(curLeft) < countsT.get(curLeft)) {
            have--;
          }

          left++;
        }

        right++;
      }

      return minRight == Integer.MAX_VALUE - 1 ? "" : s.substring(minLeft, minRight + 1);
    }
  }

  @Test
  void test() {
    assertEquals("BANC", new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }
}
