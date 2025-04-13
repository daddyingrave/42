package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseString344Test {

  @Test
  void reverseString() {
    var problem = new ReverseString344();
    var actual = new char[]{'h', 'e', 'l', 'l', 'o'};
    var expected = new char[]{'o', 'l', 'l', 'e', 'h'};
    problem.reverseString(actual);
    assertArrayEquals(expected, actual);
  }
}
