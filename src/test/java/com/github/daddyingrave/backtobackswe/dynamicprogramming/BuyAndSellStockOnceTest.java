package com.github.daddyingrave.backtobackswe.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyAndSellStockOnceTest {

  BuyAndSellStockOnce stock = new BuyAndSellStockOnce();
  
  @Test
  void maxProfit() {
    assertEquals(5, stock.maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
    assertEquals(5, stock.maxProfit(new int[]{12,4,6,9,3,8,4}));
  }
}