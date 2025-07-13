package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ClimbingStairs70Test {
  Map<Integer, Integer> cache = new HashMap<>();

  public int climbStairs(int n) {
    cache.clear();
    return traverse(0, n);
  }

  int traverse(int stair, int target) {
    if (stair == target) {
      return 1;
    } else if (stair > target) {
      return 0;
    }
    if (cache.containsKey(stair)) {
      return cache.get(stair);
    }

    cache.put(stair, traverse(stair + 1, target) + traverse(stair + 2, target));

    return cache.get(stair);
  }

  @Test
  void test() {
    assertEquals(2, climbStairs(2));
    assertEquals(3, climbStairs(3));
    assertEquals(8, climbStairs(5));
  }
}
