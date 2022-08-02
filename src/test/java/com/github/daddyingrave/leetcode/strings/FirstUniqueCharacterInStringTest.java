package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterInStringTest {

  FirstUniqueCharacterInString inString = new FirstUniqueCharacterInString();
  
  @Test
  void firstUniqChar() {
    assertEquals(0, inString.firstUniqChar("leetcode"));
    assertEquals(2, inString.firstUniqChar("loveleetcode"));
    assertEquals(-1, inString.firstUniqChar("aabb"));
  }
}