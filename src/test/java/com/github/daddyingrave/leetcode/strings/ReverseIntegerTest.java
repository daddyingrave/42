package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

  ReverseInteger reverseInteger = new ReverseInteger();
  
  @Test
  void reverse() {
    assertEquals(321, reverseInteger.reverse(123));
    assertEquals(-321, reverseInteger.reverse(-123));
    assertEquals(21, reverseInteger.reverse(120));
    assertEquals(0, reverseInteger.reverse(0));
    assertEquals(0, reverseInteger.reverse(1534236469));
  }
}