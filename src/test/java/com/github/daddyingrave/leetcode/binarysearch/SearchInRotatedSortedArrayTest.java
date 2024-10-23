package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

  @Test
  void search() {
    var problem = new SearchInRotatedSortedArray();

    System.out.println(5 / 2);

    assertEquals(4, problem.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    assertEquals(0, problem.search(new int[]{1, 3}, 1));
    assertEquals(0, problem.search(new int[]{1}, 1));
    assertEquals(0, problem.search(new int[]{3, 1}, 3));
    assertEquals(1, problem.search(new int[]{3, 1}, 1));
    assertEquals(3, problem.search(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2));
    assertEquals(7, problem.search(new int[]{2,3,4,5,6,7,8,9,1}, 9));
  }
}