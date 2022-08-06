package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

  FibonacciNumber fibonacciNumber = new FibonacciNumber();

  @Test
  void fib() {
    int expected = 3;
    int actual = fibonacciNumber.fib(4);

    assertEquals(expected, actual);
  }

  @Test
  void fib1() {
    int expected = 1;
    int actual = fibonacciNumber.fib(1);

    assertEquals(expected, actual);
  }

  @Test
  void fib3() {
    int expected = 0;
    int actual = fibonacciNumber.fib(0);

    assertEquals(expected, actual);
  }
}