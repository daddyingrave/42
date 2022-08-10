package com.github.daddyingrave.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

  ClimbingStairs climbingStairs = new ClimbingStairs();

  @Test
  void climbStairs() {
    int expected = 3;
    int actual = climbingStairs.climbStairs(3);

    assertEquals(expected, actual);
  }

  @Test
  void climbStairs2() {
    int expected = 2;
    int actual = climbingStairs.climbStairs(2);

    assertEquals(expected, actual);
  }
}