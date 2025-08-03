package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestRepeatingCharacterReplacement424Test {
  // A A B A B B A   k = 1
  //   L
  //         R
  // A: 2
  // B: 2
  public int characterReplacement(String s, int k) {
    int result = 0; // 4
    int left = 0; // 0
    int right = 0; // 4
    int maxFrequency = 0;
    int[] counts = new int[26];


    while (right < s.length()) {
      char currentChar = s.charAt(right);
      counts[currentChar - 65]++;
      maxFrequency = Math.max(maxFrequency, counts[currentChar - 65]);

      while ((right - left + 1) - maxFrequency > k) {
        counts[s.charAt(left) - 65]--;
        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(4, characterReplacement("ABAB", 2));
    assertEquals(4, characterReplacement("AABABBA", 1));
    assertEquals(5, characterReplacement("AABABBB", 1));
    assertEquals(3, characterReplacement("AAAB", 0));
    assertEquals(2, characterReplacement("ABAA", 0));
  }
}
