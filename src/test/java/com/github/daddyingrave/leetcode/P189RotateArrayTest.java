package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P189RotateArrayTest {

  @Test
  void rotate() {
    var problem = new P189RotateArray();

    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    int[] numsExpected = new int[]{5, 6, 7, 1, 2, 3, 4};

    problem.rotate(nums, 3);

    assertArrayEquals(numsExpected, nums);
  }

  @Test
  void rotate2() {
    var problem = new P189RotateArray();

    int[] nums = new int[]{-1, -100, 3, 99};
    int[] numsExpected = new int[]{3, 99, -1, -100};

    problem.rotate(nums, 2);

    assertArrayEquals(numsExpected, nums);
  }

  @Test
  void rotate3() {
    var problem = new P189RotateArray();

    int[] nums = new int[]{-1, -100, 3, 99};
    int[] numsExpected = new int[]{-100, 3, 99, -1};

    problem.rotate(nums, 3);

    assertArrayEquals(numsExpected, nums);
  }

  @Test
  void rotate4() {
    var problem = new P189RotateArray();

    int[] nums = new int[]{-1};
    int[] numsExpected = new int[]{-1};

    problem.rotate(nums, 2);

    assertArrayEquals(numsExpected, nums);
  }

  @Test
  void rotate5() {
    var problem = new P189RotateArray();

    int[] nums = new int[]{1, 2, 3, 4, 5};
    int[] numsExpected = new int[]{4, 5, 1, 2, 3};

    problem.rotate(nums, 2);

    assertArrayEquals(numsExpected, nums);
  }
}