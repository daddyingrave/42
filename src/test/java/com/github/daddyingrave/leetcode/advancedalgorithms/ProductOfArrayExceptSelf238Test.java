package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductOfArrayExceptSelf238Test {
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] postfix = new int[nums.length];
    prefix[0] = nums[0];
    postfix[postfix.length - 1] = nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i];
    }
    for (int i = nums.length - 2; i >= 0; i--) {
      postfix[i] = postfix[i + 1] * nums[i];
    }

    int[] result = new int[nums.length];
    result[0] = postfix[1];
    result[result.length - 1] = prefix[prefix.length - 2];

    for (int i = 1; i < result.length - 1; i++) {
      result[i] = prefix[i - 1] * postfix[i + 1];
    }

    return result;
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
  }
}
