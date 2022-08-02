package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

  ReverseString reverseString = new ReverseString();

  @Test
  void reverseString() {
    char[] str = new char[]{'h', 'e', 'l', 'l', 'o'};
    reverseString.reverseString(str);
    assertArrayEquals(
        new char[]{'o', 'l', 'l', 'e', 'h'},
        str
    );

    char[] str2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
    reverseString.reverseString(str2);
    assertArrayEquals(
        new char[]{'h','a','n','n','a','H'},
        str2
    );
  }
}