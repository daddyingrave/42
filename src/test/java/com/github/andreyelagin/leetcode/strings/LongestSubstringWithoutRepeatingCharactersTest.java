package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

  LongestSubstringWithoutRepeatingCharacters task = new LongestSubstringWithoutRepeatingCharacters();
  
  @Test
  void lengthOfLongestSubstring() {
    assertEquals(3, task.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, task.lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, task.lengthOfLongestSubstring("pwwkew"));
    assertEquals(0, task.lengthOfLongestSubstring(""));
    assertEquals(1, task.lengthOfLongestSubstring(" "));
    assertEquals(2, task.lengthOfLongestSubstring("abba"
    ));
  }
}