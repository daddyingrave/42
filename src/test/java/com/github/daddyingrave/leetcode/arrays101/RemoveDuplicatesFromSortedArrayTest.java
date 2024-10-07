package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

  @Test
  void removeDuplicates() {
    var problem = new RemoveDuplicatesFromSortedArray();

    int[] given = new int[]{1, 1, 2};
    int[] expected = new int[]{1, 2};

    problem.removeDuplicates(given);

    assertArrayEquals(expected, Arrays.copyOf(given, 2));
  }

  @Test
  void removeDuplicates2() {
    var problem = new RemoveDuplicatesFromSortedArray();

    int[] given = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int[] expected = new int[]{0, 1, 2, 3, 4};

    problem.removeDuplicates(given);

    assertArrayEquals(expected, Arrays.copyOf(given, 5));
  }
}