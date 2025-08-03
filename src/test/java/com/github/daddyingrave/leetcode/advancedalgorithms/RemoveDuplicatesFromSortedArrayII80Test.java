package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesFromSortedArrayII80Test {
  // 1 2
  // U
  //   i
  public int removeDuplicates(int[] nums) {
    int unique = 2;

    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[unique - 2]) {
        nums[unique++] = nums[i];
      }
    }

    return unique;
  }

  @Test
  void test() {
    assertEquals(5, removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    assertEquals(7, removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
//    assertEquals(1, removeDuplicates(new int[]{1}));
    assertEquals(2, removeDuplicates(new int[]{1, 2}));
  }
}
