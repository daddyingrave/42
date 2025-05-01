package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWater11Test {
  static class Pair {
    int key;
    int value;
  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = Integer.MIN_VALUE;

    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }

  @Test
  void test() {
    assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
