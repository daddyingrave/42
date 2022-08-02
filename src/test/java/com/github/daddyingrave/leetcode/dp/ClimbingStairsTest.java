package com.github.daddyingrave.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

  ClimbingStairs climbingStairs = new ClimbingStairs();
  
  @Test
  void climbStairs() {
    assertEquals(2, climbingStairs.climbStairs(2));
    assertEquals(3, climbingStairs.climbStairs(3));
  }
}