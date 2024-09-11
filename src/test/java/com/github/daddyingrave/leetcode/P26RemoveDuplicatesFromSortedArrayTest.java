package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P26RemoveDuplicatesFromSortedArrayTest {

  @Test
  void removeDuplicates() {
    var problem = new P26RemoveDuplicatesFromSortedArray();
    var nums = new int[]{1, 1, 2};

    assertEquals(2, problem.removeDuplicates(nums));
    assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));
  }

  @Test
  void removeDuplicates2() {
    var problem = new P26RemoveDuplicatesFromSortedArray();
    var nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    assertEquals(5, problem.removeDuplicates(nums));
    assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, 5));
  }

  @Test
  void removeDuplicates3() {
    var problem = new P26RemoveDuplicatesFromSortedArray();
    var nums = new int[]{};

    assertEquals(0, problem.removeDuplicates(nums));
    assertArrayEquals(new int[]{}, Arrays.copyOf(nums, 0));
  }
}