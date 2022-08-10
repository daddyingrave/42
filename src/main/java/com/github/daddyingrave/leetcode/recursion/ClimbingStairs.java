package com.github.daddyingrave.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
  Map<Integer, Integer> cache = new HashMap<>();

  public int climbStairs(int n) {
    return rec(0, n);
  }

  private int rec(int i, int n) {
    if (i > n) {
      return 0;
    }

    if (i == n) {
      return 1;
    }

    if (cache.containsKey(i)) {
      return cache.get(i);
    }

    int stair = rec(i + 1, n) + rec(i + 2, n);
    cache.put(i, stair);

    return cache.get(i);
  }
}
