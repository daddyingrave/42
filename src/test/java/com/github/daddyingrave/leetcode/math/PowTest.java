package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {

  Pow solution = new Pow();

  @Test
  void myPow() {
    assertEquals(1024, solution.myPow(2, 10));
    assertEquals(9.26100, Double.parseDouble(new DecimalFormat(".#####").format(solution.myPow(2.10000, 3))));
    assertEquals(0.25000, Double.parseDouble(new DecimalFormat(".#####").format(solution.myPow(2.00000, -2))));
  }
}