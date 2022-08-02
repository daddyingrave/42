package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

  RemoveDuplicatesFromSortedArray duplicates = new RemoveDuplicatesFromSortedArray();
  
  @Test
  void removeDuplicates() {
    var arr1 = new int[]{1, 1, 2};
    var arr2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    assertEquals(2, duplicates.removeDuplicates(arr1));
    assertEquals(5, duplicates.removeDuplicates(arr2));
  }
}