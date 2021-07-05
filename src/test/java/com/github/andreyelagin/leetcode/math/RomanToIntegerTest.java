package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

  RomanToInteger romanToInteger = new RomanToInteger();
  
  @Test
  void romanToInt() {
    assertEquals(3, romanToInteger.romanToInt("III"));
    assertEquals(4, romanToInteger.romanToInt("IV"));
    assertEquals(58, romanToInteger.romanToInt("LVIII"));
    assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
  }
}