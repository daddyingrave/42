package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductOfArrayExceptSelf238Test {

  @Test
  void productExceptSelf() {
    var problem = new ProductOfArrayExceptSelf238();

    assertArrayEquals(new int[]{24, 12, 8, 6}, problem.productExceptSelf(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{0, 0, 9, 0, 0}, problem.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    assertArrayEquals(new int[]{3, 2}, problem.productExceptSelf(new int[]{2, 3}));
  }
}
