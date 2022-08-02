package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotBoundedInCircleTest {

  RobotBoundedInCircle solution = new RobotBoundedInCircle();
  
  @Test
  void isRobotBounded() {
    assertTrue(solution.isRobotBounded("GGLLGG"));
    assertTrue(solution.isRobotBounded("GL"));
    assertFalse(solution.isRobotBounded("GG"));
  }
}