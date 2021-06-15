package com.github.andreyelagin.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortKSortedArrayTest {

  SortKSortedArray sortKSortedArray = new SortKSortedArray();

  @Test
  void sortNearlySortedArray() {
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5},
        sortKSortedArray.sortNearlySortedArray(new int[]{3, 4, 1, 2, 5}, 2)
    );
    assertArrayEquals(
        new int[]{4, 7, 8, 9, 10, 50, 60, 70},
        sortKSortedArray.sortNearlySortedArray(new int[]{10, 9, 8, 7, 4, 70, 60, 50}, 4)
    );
  }
}