package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class FindTheDuplicateNumber287Test {
  // 0  1  2  3  4  5  6  7  8  9
  // 2, 5, 9, 6, 9, 3, 8, 9, 7, 1
  //                         F
  //                         S
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (fast == slow) {
        int newSlow = nums[0];
        while (slow != newSlow) {
          newSlow = nums[newSlow];
          slow = nums[slow];
        }
        return newSlow;
      }
    }
  }

  @Test
  void test() {

  }
}
