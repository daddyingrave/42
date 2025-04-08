package com.github.daddyingrave.leetcode.arrays;

import java.util.Arrays;

public class SortAnArray912 {
  public int[] sortArray(int[] nums) {
    if (nums == null || nums.length == 1) {
      return nums;
    }

    return split(nums, 0, nums.length - 1);
  }

  int[] split(int[] nums, int left, int right) {
    if (left >= right) {
      return nums;
    }

    int mid = (right + left) / 2;
    split(nums, left, mid);
    split(nums, mid + 1, right);
    merge(nums, left, right, mid);

    return nums;
  }

  void merge(int[] nums, int left, int right, int mid) {
    var leftArr = Arrays.copyOfRange(nums, left, mid + 1);
    var rightArr = Arrays.copyOfRange(nums, mid + 1, right + 1);

    int leftPtr = 0;
    int rightPtr = 0;
    int targetPtr = left;

    while (leftPtr < leftArr.length && rightPtr < rightArr.length) {
      if (leftArr[leftPtr] <= rightArr[rightPtr]) {
        nums[targetPtr] = leftArr[leftPtr++];
      } else {
        nums[targetPtr] = rightArr[rightPtr++];
      }

      targetPtr++;
    }

    while (leftPtr < leftArr.length) {
      nums[targetPtr++] = leftArr[leftPtr++];
    }
    while (rightPtr < rightArr.length) {
      nums[targetPtr++] = rightArr[rightPtr++];
    }
  }
}
