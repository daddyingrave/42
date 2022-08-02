package com.github.daddyingrave.leetcode.arrays;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int first = nums[0];
    for (int i = 1; i < nums.length; i++) {
      first = first ^ nums[i];
    }
    
    return first;
  }
}
