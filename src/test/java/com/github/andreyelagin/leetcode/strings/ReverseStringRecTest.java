package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringRecTest {
  private ReverseStringRec reverseStringRec = new ReverseStringRec();

  @Test
  void test1() {
    var given = new char[]{'h', 'e', 'l', 'l', 'o'};
    var expected = new char[]{'o', 'l', 'l', 'e', 'h'};

    reverseStringRec.reverseString(given);

    assertArrayEquals(expected, given);
  }

  @Test
  void test2() {
    var given = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
    var expected = new char[]{'h', 'a', 'n', 'n', 'a', 'H'};

    reverseStringRec.reverseString(given);

    assertArrayEquals(expected, given);
  }
}