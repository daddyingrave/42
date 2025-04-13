package com.github.daddyingrave.leetcode.arrays;

public class ProductOfArrayExceptSelf238 {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    result[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result[i] = nums[i] * result[i - 1];
    }

    int postfixProduct = nums[nums.length - 1];
    result[result.length - 1] = result[result.length - 2];
    for (int i = result.length - 2; i > 0; i--) {
      result[i] = result[i - 1] * postfixProduct;
      postfixProduct *= nums[i];
    }

    result[0] = postfixProduct;

    return result;
  }
}
