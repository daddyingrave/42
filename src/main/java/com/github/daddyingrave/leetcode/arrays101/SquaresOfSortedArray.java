package com.github.daddyingrave.leetcode.arrays101;

public class SquaresOfSortedArray {
  public int[] sortedSquares(int[] nums) {
    int[] target = new int[nums.length];

    int start = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      start = i;
      if (nums[i + 1] >= 0) {
        break;
      }
    }

    int left = start;
    int right = start + 1;
    int targetIndex = 0;

    while (left >= 0 && right < nums.length) {
      if (Math.abs(nums[left]) <= nums[right]) {
        target[targetIndex] = (int) Math.pow(nums[left], 2.0);
        left--;
      } else {
        target[targetIndex] = (int) Math.pow(nums[right], 2.0);
        right++;
      }

      targetIndex++;
    }

    while (left >= 0) {
      target[targetIndex] = (int) Math.pow(nums[left], 2.0);
      targetIndex++;
      left--;
    }

    while (right < nums.length) {
      target[targetIndex] = (int) Math.pow(nums[right], 2.0);
      targetIndex++;
      right++;
    }

    return target;
  }
}
