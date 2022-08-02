package com.github.daddyingrave.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

  QuickSort quickSort = new QuickSort();
  
  @Test
  void quicksort() {
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5},
        quickSort.quicksort(new int[]{5, 4, 3, 2, 1})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5, 6},
        quickSort.quicksort(new int[]{6, 5, 4, 3, 2, 1})
    );
    var arr = new int[]{1, 3, 2, 4, 5, 7, 9, 6, 10, 8};
    Arrays.sort(arr);
    assertArrayEquals(
        arr,
        quickSort.quicksort(new int[]{1, 3, 2, 4, 5, 7, 9, 6, 10, 8})
    );
  }
}