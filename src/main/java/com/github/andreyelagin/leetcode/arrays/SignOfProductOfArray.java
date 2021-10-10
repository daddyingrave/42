package com.github.andreyelagin.leetcode.arrays;

public class SignOfProductOfArray {
  public int arraySign(int[] nums) {
    int negativeCount = 0;
    int zeroCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        negativeCount++;
      } else if (nums[i] == 0) {
        return 0;
      }
    }

    if (negativeCount % 2 > 0) {
      return -1;
    } else {
      return 1;
    }
  }
}
