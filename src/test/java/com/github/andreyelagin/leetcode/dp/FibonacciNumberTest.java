package com.github.andreyelagin.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

  FibonacciNumber solution = new FibonacciNumber();
  
  @Test
  void fib() {
    assertEquals(0, solution.fib(0));
    assertEquals(1, solution.fib(2));
    assertEquals(2, solution.fib(3));
    assertEquals(3, solution.fib(4));
  }
}