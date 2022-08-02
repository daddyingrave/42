package com.github.daddyingrave.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstAndLastPositionOfElementInSortedArrayTest {

  FindFirstAndLastPositionOfElementInSortedArray position = new FindFirstAndLastPositionOfElementInSortedArray();

  @Test
  void searchRange() {
    assertArrayEquals(
        new int[]{3, 4},
        position.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)
    );
    assertArrayEquals(
        new int[]{-1, -1},
        position.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)
    );
    assertArrayEquals(
        new int[]{-1, -1},
        position.searchRange(new int[]{}, 0)
    );
    assertArrayEquals(
        new int[]{0, 0},
        position.searchRange(new int[]{1}, 1)
    );
  }
}