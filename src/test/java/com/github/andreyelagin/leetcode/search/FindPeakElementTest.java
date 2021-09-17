package com.github.andreyelagin.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPeakElementTest {

  FindPeakElement solution = new FindPeakElement();

  @Test
  void findPeakElement() {
    assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));
    assertEquals(1, solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    assertEquals(0, solution.findPeakElement(new int[]{1}));
    assertEquals(0, solution.findPeakElement(new int[]{2, 1}));
    assertEquals(1, solution.findPeakElement(new int[]{1, 2}));
    assertEquals(3, solution.findPeakElement(new int[]{1, 2, 3, 4}));
    assertEquals(1, solution.findPeakElement(new int[]{3, 4, 3, 2, 1}));
  }
}