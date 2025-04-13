package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockII122Test {

  @Test
  void maxProfit() {
    var problem = new BestTimeToBuyAndSellStockII122();
    assertEquals(7, problem.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(4, problem.maxProfit(new int[]{1, 2, 3, 4, 5}));
    assertEquals(0, problem.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }
}
