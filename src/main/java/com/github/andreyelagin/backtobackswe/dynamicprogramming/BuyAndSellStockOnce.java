package com.github.andreyelagin.backtobackswe.dynamicprogramming;

public class BuyAndSellStockOnce {
  public int maxProfit(int[] prices) {
    int[] profits = new int[prices.length];
    int max = 0;
    
    for (int i = 1; i < prices.length; i++) {
      int curProfit = prices[i] - prices[i - 1];
      profits[i] = Math.max(0, curProfit + profits[i - 1]);
      max = Math.max(profits[i], max);
    }
    
    return max;
  }
}
