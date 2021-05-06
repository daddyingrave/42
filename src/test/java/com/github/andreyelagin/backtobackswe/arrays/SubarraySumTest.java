package com.github.andreyelagin.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumTest {
  
  SubarraySum subarraySum = new SubarraySum();

  @Test
  void countSubarrays() {
    assertEquals(4, subarraySum.countSubarrays(new int[]{1, 0, -1, 1}, 0));
  }
}