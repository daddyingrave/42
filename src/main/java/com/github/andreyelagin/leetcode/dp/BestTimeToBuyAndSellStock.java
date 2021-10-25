package com.github.andreyelagin.leetcode.dp;

public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int max = 0;
    int[] profits = new int[prices.length];
    
    for (int i = 1; i < prices.length; i++) {
      int curProfit = prices[i] - prices[i - 1];
      profits[i] = Math.max(0, curProfit + profits[i - 1]);
      max = Math.max(max, profits[i]);
    }
    
    return max;
  }
}
