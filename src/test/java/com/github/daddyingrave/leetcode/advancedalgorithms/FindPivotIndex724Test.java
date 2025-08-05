package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindPivotIndex724Test {
  public int pivotIndex(int[] nums) {
    int[] prefix = new int[nums.length + 2];
    int[] postfix = new int[nums.length + 2];
    prefix[1] = nums[0];
    postfix[postfix.length - 2] = nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }
    for (int i = nums.length - 2; i >= 0; i--) {
      postfix[i + 1] = postfix[i + 2] + nums[i];
    }

    for (int i = 1; i < prefix.length - 1; i++) {
      if (prefix[i - 1] == postfix[i + 1]) {
        return i - 1;
      }
    }

    return -1;
  }

  @Test
  void test() {
    assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
    assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
  }
}
