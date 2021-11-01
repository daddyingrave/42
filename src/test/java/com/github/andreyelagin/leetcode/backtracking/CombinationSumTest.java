package com.github.andreyelagin.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

  CombinationSum solution = new CombinationSum();

  @Test
  void combinationSum() {
    assertEquals(
        List.of(List.of(2, 2, 3), List.of(7)), 
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7)
    );
  }
}