package com.github.andreyelagin.leetcode.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortColorsTest {

  SortColors solution = new SortColors();

  @Test
  void sortColors() {
    int[] arr = new int[]{2, 0, 2, 1, 1, 0};
    int[] expected = new int[]{0, 0, 1, 1, 2, 2};

    solution.sortColors(arr);

    assertArrayEquals(expected, arr);
  }

  @Test
  void sortColors2() {
    int[] arr = new int[]{2, 0, 1};
    int[] expected = new int[]{0, 1, 2};

    solution.sortColors(arr);

    assertArrayEquals(expected, arr);
  }

  @Test
  void sortColors3() {
    int[] arr = new int[]{0};
    int[] expected = new int[]{0};

    solution.sortColors(arr);

    assertArrayEquals(expected, arr);
  }

  @Test
  void sortColors4() {
    int[] arr = new int[]{1};
    int[] expected = new int[]{1};

    solution.sortColors(arr);

    assertArrayEquals(expected, arr);
  }
}