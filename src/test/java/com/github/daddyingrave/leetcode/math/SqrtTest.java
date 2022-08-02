package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

  Sqrt solution = new Sqrt();
  
  @Test
  void mySqrt() {
    assertEquals(2, solution.mySqrt(4));
    assertEquals(2, solution.mySqrt(8));
  }
}