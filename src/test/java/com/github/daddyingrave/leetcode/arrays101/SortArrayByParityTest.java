package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayByParityTest {

  @Test
  void sortArrayByParity() {
    var problem = new SortArrayByParity();

    int[] actual = new int[]{3, 1, 2, 4};
    int[] expected = new int[]{2, 4, 3, 1};

    assertArrayEquals(expected, problem.sortArrayByParity(actual));
  }

  @Test
  void sortArrayByParity1() {
    var problem = new SortArrayByParity();

    int[] actual = new int[]{1};
    int[] expected = new int[]{1};

    assertArrayEquals(expected, problem.sortArrayByParity(actual));
  }

  @Test
  void sortArrayByParity2() {
    var problem = new SortArrayByParity();

    int[] actual = new int[]{1, 3};
    int[] expected = new int[]{1, 3};

    assertArrayEquals(expected, problem.sortArrayByParity(actual));
  }
}