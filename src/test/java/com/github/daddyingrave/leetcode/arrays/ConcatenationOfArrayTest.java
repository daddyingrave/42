package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConcatenationOfArrayTest {

  @Test
  void getConcatenation() {
    var problem = new ConcatenationOfArray();
    assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, problem.getConcatenation(new int[]{1, 2, 1}));
    assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1}, problem.getConcatenation(new int[]{1, 2, 1, 1, 2, 1}));
  }
}
