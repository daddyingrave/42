package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindtheDuplicateNumber287Test {
  class Solution {
    public int findDuplicate(int[] nums) {
      int slow = nums[0];
      int fast = nums[0];
      while (true) {
        slow = nums[slow];
        fast = nums[nums[fast]];
        if (slow == fast) {
          int newSlow = nums[0];
          while (slow != newSlow) {
            newSlow = nums[newSlow];
            slow = nums[slow];
          }

          return slow;
        }
      }
    }
  }

  @Test
  void test() {
    assertEquals(2, new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
  }
}
