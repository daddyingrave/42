package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

public class PermutationinString567Test {
  class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) {
        return false;
      }

      var s1Counts = new int[26];
      var s2Counts = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        s1Counts[s1.charAt(i) - 'a']++;
        s2Counts[s2.charAt(i) - 'a']++;
      }

      int matches = 0;
      for (int i = 0; i < 26; i++) {
        if (s1Counts[i] == s2Counts[i]) {
          matches++;
        }
      }

      int left = 0;
      for (int right = s1.length(); right < s2.length(); right++) {
        if (matches == 26) {
          return true;
        }

        int index = s2.charAt(right) - 'a';
        s2Counts[index]++;
        if (s1Counts[index] == s2Counts[index]) {
          matches++;
        } else if (s1Counts[index] + 1 == s2Counts[index]) {
          matches--;
        }

        index = s2.charAt(left) - 'a';
        s2Counts[index]--;
        if (s1Counts[index] == s2Counts[index]) {
          matches++;
        } else if (s1Counts[index] - 1 == s2Counts[index]) {
          matches--;
        }

        left++;
      }


      return matches == 26;
    }
  }

  @Test
  void test() {

  }
}
