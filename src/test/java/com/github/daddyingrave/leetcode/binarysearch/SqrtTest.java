package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

  @Test
  void mySqrt() {
    var problem = new Sqrt();

    assertEquals(2, problem.mySqrt(8));
    assertEquals(46339, problem.mySqrt(2147395599));
  }
}