package com.github.daddyingrave.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
  Map<Integer, Integer> cache = new HashMap<>();

  public int fib(int n) {
    if (n == 2 || n == 1) {
      return 1;
    }

    if (n <= 0) {
      return 0;
    }

    if (!cache.containsKey(n)) {
      cache.put(n, fib(n - 1) + fib(n - 2));
    }
    return cache.get(n);
  }
}
