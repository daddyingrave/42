package com.github.daddyingrave.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

  LongestSubstringWithoutRepeatingCharacters substring =
      new LongestSubstringWithoutRepeatingCharacters();
  
  @Test
  void longestUniqueCharacterSubstring() {
    assertEquals(5, substring.longestUniqueCharacterSubstring("ABCABADEC"));
  }
}