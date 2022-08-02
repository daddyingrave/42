package com.github.daddyingrave.leetcode.math;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    int num = nums.length;
    for (int i = 0; i < nums.length; i++) {
      num ^= nums[i] ^ i;
    }
    return num;
  }

//  public int missingNumber(int[] nums) {
//    int seqLength = nums.length;
//    long expectedSum = (long) (seqLength + 1) * seqLength / 2;
//    long sum = 0;
//    for (int num : nums) {
//      sum += num;
//    }
//
//    return (int) (expectedSum - sum);
//  }
}
