package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

  NextPermutation solution = new NextPermutation();
  
  @Test
  void nextPermutation() {
    var arr = new int[]{1, 2, 3};
    solution.nextPermutation(arr);
    assertArrayEquals(new int[]{1, 3, 2}, arr);
  }

  @Test
  void nextPermutation2() {
    var arr = new int[]{3, 2, 1};
    solution.nextPermutation(arr);
    assertArrayEquals(new int[]{1, 2, 3}, arr);
  }

  @Test
  void nextPermutation3() {
    var arr = new int[]{1, 1, 5};
    solution.nextPermutation(arr);
    assertArrayEquals(new int[]{1, 5, 1}, arr);
  }

  @Test
  void nextPermutation4() {
    var arr = new int[]{1};
    solution.nextPermutation(arr);
    assertArrayEquals(new int[]{1}, arr);
  }

  @Test
  void nextPermutation5() {
    var arr = new int[]{1, 4, 3, 2};
    solution.nextPermutation(arr);
    assertArrayEquals(new int[]{2, 1, 3, 4}, arr);
  }
}