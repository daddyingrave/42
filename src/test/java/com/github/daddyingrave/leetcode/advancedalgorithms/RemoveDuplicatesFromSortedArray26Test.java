package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesFromSortedArray26Test {
  // 0 1 2 3 4 2 2 3 3 4
  //         U
  //                   I
  public int removeDuplicates(int[] nums) {
    int unique = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != nums[unique]) {
        nums[++unique] = nums[i];
      }
    }

    return unique + 1;
  }

  @Test
  void test() {
    assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
}
