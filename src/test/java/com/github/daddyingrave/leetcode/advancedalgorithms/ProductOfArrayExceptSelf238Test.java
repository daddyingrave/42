package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductOfArrayExceptSelf238Test {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;

    for (int i = 1; i < result.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }

    int postfix = 1;
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] *= postfix;
      postfix *= nums[i];
    }

    return result;
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
  }
}
