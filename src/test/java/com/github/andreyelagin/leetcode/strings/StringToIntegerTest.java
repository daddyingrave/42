package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

  StringToInteger solution = new StringToInteger();
  
  @Test
  void myAtoi() {
    assertEquals(42, solution.myAtoi("42"));
    assertEquals(-42, solution.myAtoi("   -42"));
    assertEquals(4193, solution.myAtoi("4193 with words"));
    assertEquals(0, solution.myAtoi("words and 987"));
    assertEquals(-2147483648, solution.myAtoi("-91283472332"));
    assertEquals(0, solution.myAtoi("-"));
    assertEquals(1, solution.myAtoi("+1"));
    assertEquals(12345678, solution.myAtoi("  0000000000012345678"));
    assertEquals(0, solution.myAtoi("    0000000000000   "));
    assertEquals(-1, solution.myAtoi("-000000000000001"));
    assertEquals(0, solution.myAtoi("+"));
    assertEquals(0, solution.myAtoi(" "));
    assertEquals(2147483647, solution.myAtoi("    10522545459"));
    assertEquals(4500, solution.myAtoi("     +004500"));
  }
}