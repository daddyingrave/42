package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

  IntegerToRoman integerToRoman = new IntegerToRoman();
  
  @Test
  void intToRoman() {
    assertEquals("III", integerToRoman.intToRoman(3));
    assertEquals("IV", integerToRoman.intToRoman(4));
    assertEquals("IX", integerToRoman.intToRoman(9));
    assertEquals("LVIII", integerToRoman.intToRoman(58));
    assertEquals("MCMXCIV", integerToRoman.intToRoman(1994));
  }
}