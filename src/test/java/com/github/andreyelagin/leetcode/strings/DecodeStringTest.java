package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

  DecodeString solution = new DecodeString();
  
  @Test
  void decodeString() {
    assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
    assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
    assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    assertEquals("abccdcdcdxyz", solution.decodeString("abc3[cd]xyz"));
  }
}