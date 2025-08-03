package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWater11Test {
  // 0  1  2  3  4  5  6  7  8
  // 1, 8, 6, 2, 5, 4, 8, 3, 7
  //       L
  //                   R
  // maxVolume: 49
  public int maxArea(int[] height) {
    int maxVolume = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int curVolume = (right - left) * Math.min(height[left], height[right]);
      maxVolume = Math.max(maxVolume, curVolume);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxVolume;
  }

  @Test
  void test() {
    assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, maxArea(new int[]{1, 1}));
  }
}
