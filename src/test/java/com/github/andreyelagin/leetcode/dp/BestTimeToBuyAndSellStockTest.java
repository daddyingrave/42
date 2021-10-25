package com.github.andreyelagin.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

  BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

  @Test
  void maxProfit() {
    assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
}