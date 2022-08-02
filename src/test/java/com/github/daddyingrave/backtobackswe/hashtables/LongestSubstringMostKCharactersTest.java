package com.github.daddyingrave.backtobackswe.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringMostKCharactersTest {

  LongestSubstringMostKCharacters longest = new LongestSubstringMostKCharacters();
  
  @Test
  void longestSubstringWithAtMostKDistinctCharacters() {
    assertEquals(
        4,
        longest.longestSubstringWithAtMostKDistinctCharacters("coffee", 2)
    );
    
  }
}