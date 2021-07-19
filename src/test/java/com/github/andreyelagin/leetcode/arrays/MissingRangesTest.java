package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissingRangesTest {

  MissingRanges missingRanges = new MissingRanges();

  @Test
  void findMissingRanges() {
    assertEquals(
        List.of("2", "4->49", "51->74", "76->99"),
        missingRanges.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99)
    );
    assertEquals(
        List.of("1"),
        missingRanges.findMissingRanges(new int[]{}, 1, 1)
    );
  }
}