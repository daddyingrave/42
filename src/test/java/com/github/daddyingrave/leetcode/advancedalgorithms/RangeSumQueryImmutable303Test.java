package com.github.daddyingrave.leetcode.advancedalgorithms;

public class RangeSumQueryImmutable303Test {
  class NumArray {
    int[]prefixSums;

    public NumArray(int[] nums) {
      prefixSums = new int[nums.length];
      prefixSums[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        prefixSums[i] = nums[i] + prefixSums[i - 1];
      }
    }

    public int sumRange(int left, int right) {
      if (left == 0) {
        return prefixSums[right];
      }

      return prefixSums[right] - prefixSums[left - 1];
    }
  }
}
