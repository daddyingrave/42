package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColors75Test {

  @Test
  void sortColors() {
    var problem = new SortColors75();

    var actual = new int[]{2, 0, 2, 1, 1, 0};
    problem.sortColors(actual);
    assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, actual);
  }
}
