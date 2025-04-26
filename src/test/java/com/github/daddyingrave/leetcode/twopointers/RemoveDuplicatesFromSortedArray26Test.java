package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesFromSortedArray26Test {
  public int removeDuplicates(int[] nums) {
    int uniquePtr = 0;
    int cur = 0;

    while (cur < nums.length) {
      if (nums[uniquePtr] != nums[cur]) {
        nums[++uniquePtr] = nums[cur];
      }
      cur++;
    }

    return uniquePtr + 1;
  }

  @Test
  void test() {
    assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
}
