package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrappingRainWater42Test {
  // 0,1,0,2,1,0,1,3,2,1,2,1
  public int trap(int[] height) {
    int[] leftMax = new int[height.length];
    int max = height[0];
    for (int i = 1; i < height.length; i++) {
      max = Math.max(max, height[i - 1]);
      leftMax[i] = max;
    }

    int[] rightMax = new int[height.length];
    max = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      max = Math.max(max, height[i + 1]);
      rightMax[i] = max;
    }

    int result = 0;

    for (int i = 0; i < height.length; i++) {
      result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    assertEquals(9, trap(new int[]{4, 2, 0, 3, 2, 5}));
    assertEquals(1, trap(new int[]{4, 2, 3}));
  }
}
