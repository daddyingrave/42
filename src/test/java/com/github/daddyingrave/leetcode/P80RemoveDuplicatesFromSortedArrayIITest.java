package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P80RemoveDuplicatesFromSortedArrayIITest {

  @Test
  void removeDuplicates() {
    var problem = new P80RemoveDuplicatesFromSortedArrayII();
    var nums = new int[]{1, 1, 1, 2, 2, 3};

    assertEquals(5, problem.removeDuplicates(nums));
    assertArrayEquals(new int[]{1, 1, 2, 2, 3}, Arrays.copyOf(nums, 5));
  }

  @Test
  void removeDuplicates2() {
    var problem = new P80RemoveDuplicatesFromSortedArrayII();
    var nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

    assertEquals(7, problem.removeDuplicates(nums));
    assertArrayEquals(new int[]{0, 0, 1, 1, 2, 3, 3}, Arrays.copyOf(nums, 7));
  }
}