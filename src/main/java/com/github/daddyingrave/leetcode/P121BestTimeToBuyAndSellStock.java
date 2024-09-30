package com.github.daddyingrave.leetcode;

public class P121BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;

    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else if (maxProfit < price - minPrice) {
        maxProfit = price - minPrice;
      }
    }

    return maxProfit;
  }
}
