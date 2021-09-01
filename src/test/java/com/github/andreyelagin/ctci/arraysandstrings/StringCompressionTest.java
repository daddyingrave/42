package com.github.andreyelagin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

  StringCompression compression = new StringCompression();
  
  @Test
  void compress() {
    assertEquals("a2b1c5a3", compression.compress("aabcccccaaa"));
    assertEquals("abc", compression.compress("abc"));
  }
}