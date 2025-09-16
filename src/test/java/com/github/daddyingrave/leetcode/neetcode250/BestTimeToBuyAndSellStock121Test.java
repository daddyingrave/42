package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BestTimeToBuyAndSellStock121Test {
  class Solution {
    public int maxProfit(int[] prices) {
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

      for (int price : prices) {
        if (price < minPrice) {
          minPrice = price;
        } else {
          maxProfit = Math.max(maxProfit, price - minPrice);
        }
      }

      return maxProfit;
    }
  }

  @Test
  void test() {

  }
}
