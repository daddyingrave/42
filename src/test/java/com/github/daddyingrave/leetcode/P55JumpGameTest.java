package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P55JumpGameTest {

  @Test
  void canJump() {
    var problem = new P55JumpGame();

    assertTrue(problem.canJump(new int[]{2, 3, 1, 1, 4}));
  }

  @Test
  void canJump2() {
    var problem = new P55JumpGame();

    assertFalse(problem.canJump(new int[]{3, 2, 1, 0, 4}));
  }

  @Test
  void canJump3() {
    var problem = new P55JumpGame();

    assertTrue(problem.canJump(new int[]{0}));
  }
}