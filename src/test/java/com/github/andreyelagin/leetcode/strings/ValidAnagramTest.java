package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

  ValidAnagram validAnagram = new ValidAnagram();
  
  @Test
  void isAnagram() {
    assertTrue(validAnagram.isAnagram("nagaram", "anagram"));
    assertFalse(validAnagram.isAnagram("rat", "car"));
    assertFalse(validAnagram.isAnagram("aa", "bb"));
  }
}