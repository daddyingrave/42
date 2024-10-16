package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllNumbersDisappearedInAnArrayTest {

  @Test
  void findDisappearedNumbers() {
    var problem = new FindAllNumbersDisappearedInAnArray();

    assertEquals(List.of(5, 6), problem.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    assertEquals(List.of(2), problem.findDisappearedNumbers(new int[]{1, 1}));
  }
}