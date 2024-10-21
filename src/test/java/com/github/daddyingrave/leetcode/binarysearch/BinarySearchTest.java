package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

  @Test
  void search() {
    var problem = new BinarySearch();

    assertEquals(4, problem.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    assertEquals(4, problem.search(new int[]{-1, 0, 3, 5, 9}, 9));
    assertEquals(-1, problem.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
  }
}