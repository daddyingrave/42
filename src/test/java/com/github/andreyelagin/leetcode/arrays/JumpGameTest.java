package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

  JumpGame solution = new JumpGame();

  @Test
  void canJump() {
    assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    assertTrue(solution.canJump(new int[]{2, 0}));
    assertTrue(solution.canJump(new int[]{2, 5, 0, 0}));
    assertTrue(solution.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    assertTrue(solution.canJump(new int[]{0}));
    assertTrue(solution.canJump(new int[]{1, 2}));

    assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    assertFalse(solution.canJump(new int[]{0, 2, 1}));
  }
}