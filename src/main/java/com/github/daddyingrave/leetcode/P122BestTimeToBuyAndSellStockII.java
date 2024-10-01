package com.github.daddyingrave.leetcode;

public class P122BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int totalProfit = 0;

    if (prices.length == 0 || prices.length == 1) {
      return 0;
    }

    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        totalProfit = totalProfit + (prices[i + 1] - prices[i]);
      }
    }

    return totalProfit;
  }
}
