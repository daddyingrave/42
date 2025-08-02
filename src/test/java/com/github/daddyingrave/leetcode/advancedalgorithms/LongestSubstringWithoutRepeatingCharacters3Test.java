package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringWithoutRepeatingCharacters3Test {
  // a b c a b c b b
  //         ^
  public int lengthOfLongestSubstring(String s) {
    int result = 0; // 3
    var set = new HashSet<Character>(); // c a b
    int left = 0; // 2
    int right = 0; // 4

    while (right < s.length()) {
      char curChar = s.charAt(right);
      while (set.contains(curChar)) {
        set.remove(s.charAt(left++));
      }

      set.add(curChar);
      result = Math.max(result, set.size());
      right++;
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, lengthOfLongestSubstring("pwwkew"));
  }
}
