package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotateArray189Test {
  // left = 0, right =
  // 1, 2, 3, 4, 5, 6, 7

  // 5, 6, 7, 1, 2, 3, 4
  public void rotate(int[] nums, int k) {
    int crossPoint = k % nums.length - 1;

    swap(0, nums.length - 1, nums);
    swap(0, crossPoint, nums);
    swap(crossPoint + 1, nums.length - 1, nums);
  }

  void swap(int left, int right, int[] nums) {
    while (left < right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      left++;
      right--;
    }
  }

  @Test
  void test() {
    int[] actual = new int[]{1, 2, 3, 4, 5, 6, 7};
    int[] expected = new int[]{5, 6, 7, 1, 2, 3, 4};

    rotate(actual, 3);
    assertArrayEquals(expected, actual);
  }
}
