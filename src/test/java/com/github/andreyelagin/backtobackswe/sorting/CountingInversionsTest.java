package com.github.andreyelagin.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingInversionsTest {

  CountingInversions countingInversions = new CountingInversions();
  
  @Test
  void countInversions() {
    assertEquals(2, countingInversions.countInversions(new int[]{3, 1, 2}));
    assertEquals(0, countingInversions.countInversions(new int[]{1, 2, 3, 4}));
  }
}