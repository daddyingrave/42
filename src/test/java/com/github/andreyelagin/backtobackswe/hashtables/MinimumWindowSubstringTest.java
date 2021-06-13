package com.github.andreyelagin.backtobackswe.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

  MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
  
  @Test
  void minWindow() {
    assertEquals("abc", windowSubstring.minWindow("ahelloabgchabc", "cab"));
    assertEquals("affle", windowSubstring.minWindow("donutsandwafflemakemehungry", "flea"));
  }
}