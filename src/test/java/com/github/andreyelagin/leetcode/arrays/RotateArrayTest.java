package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateArrayTest {
  RotateArray rotateArray = new RotateArray();

  @Test
  void rotate() {
    var arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotateArray.rotate(arr, 3);

    assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arr);
  }

  @Test
  void rotate2() {
    var arr = new int[]{-1, -100, 3, 99};
    rotateArray.rotate(arr, 2);
    int[] expected = {3, 99, -1, -100};

    System.out.println("Expected: " + Arrays.toString(expected));
    System.out.println("Actual  : " + Arrays.toString(arr));

    assertArrayEquals(expected, arr);
  }
}