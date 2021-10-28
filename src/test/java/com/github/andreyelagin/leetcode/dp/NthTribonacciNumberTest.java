package com.github.andreyelagin.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NthTribonacciNumberTest {

  NthTribonacciNumber solution = new NthTribonacciNumber();
  
  @Test
  void tribonacci() {
    assertEquals(0, solution.tribonacci(0));
    assertEquals(4, solution.tribonacci(4));
    assertEquals(2, solution.tribonacci(3));
    assertEquals(1389537, solution.tribonacci(25));
  }
}