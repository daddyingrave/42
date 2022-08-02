package com.github.daddyingrave.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

  SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

  @Test
  void searchTest() {
//    assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//    assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//    assertEquals(-1, solution.search(new int[]{1}, 0));
//    assertEquals(-1, solution.search(new int[]{1, 3}, 0));
    assertEquals(0, solution.search(new int[]{1, 3}, 1));
  }

  @Test
  void findStart() {
    assertEquals(4, solution.findStart(new int[]{4, 5, 6, 7, 0, 1, 2}));
    assertEquals(1, solution.findStart(new int[]{7, 0, 1, 2, 4, 5, 6}));
  }

  @Test
  void rotatedIndexTest() {
    // 4, 5, 6, 7, 0, 1, 2 array
    // 0, 1, 2, 3, 4, 5, 6 actual index
    // 3, 4, 5, 6, 0, 1, 2 rotated index
    assertEquals(3, solution.rotatedIndex(7, 3, 0));
    assertEquals(4, solution.rotatedIndex(7, 3, 1));
    assertEquals(5, solution.rotatedIndex(7, 3, 2));
    assertEquals(6, solution.rotatedIndex(7, 3, 3));
    assertEquals(0, solution.rotatedIndex(7, 3, 4));
    assertEquals(1, solution.rotatedIndex(7, 3, 5));
    assertEquals(2, solution.rotatedIndex(7, 3, 6));
  }
}