package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrappingRainWater42Test {
  public int trap(int[] height) {
    int[] maxLeft = new int[height.length];
    maxLeft[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
    }
    int[] maxRight = new int[height.length];
    maxRight[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      maxRight[i] = Math.max(height[i], maxRight[i + 1]);
    }

    int volume = 0;
    for (int i = 0; i < height.length; i++) {
      int curVolume = Math.min(maxLeft[i], maxRight[i]) - height[i];
      if (curVolume > 0) {
        volume += curVolume;
      }
    }

    return volume;
  }

  @Test
  void test() {
    assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    assertEquals(9, trap(new int[]{4, 2, 0, 3, 2, 5}));
  }
}
