package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchForARangeTest {

  @Test
  void searchRange() {
    var problem = new SearchForARange();

    assertArrayEquals(new int[]{0, 2}, problem.searchRange(new int[]{0, 0, 0, 1, 2, 3}, 0));
    assertArrayEquals(new int[]{0, 2}, problem.searchRange(new int[]{3, 3, 3}, 3));
    assertArrayEquals(new int[]{0, 1}, problem.searchRange(new int[]{1, 1, 2}, 1));
    assertArrayEquals(new int[]{0, 1}, problem.searchRange(new int[]{2, 2}, 2));
    assertArrayEquals(new int[]{1, 1}, problem.searchRange(new int[]{1, 4}, 4));
    assertArrayEquals(new int[]{0, 0}, problem.searchRange(new int[]{1, 3}, 1));
    assertArrayEquals(new int[]{3, 4}, problem.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    assertArrayEquals(new int[]{-1, -1}, problem.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    assertArrayEquals(new int[]{-1, -1}, problem.searchRange(new int[]{}, 0));
  }
}