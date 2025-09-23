package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineStockSpan901Test {
  class StockSpanner {
    record Tuple(int price, int days) {
    }

    Stack<Tuple> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
      var cur = new Tuple(price, 1);
      while (!stack.isEmpty() && stack.peek().price <= cur.price) {
        var lastPrice = stack.pop();
        cur = new Tuple(price, cur.days + lastPrice.days);
      }

      stack.push(cur);

      return cur.days;
    }
  }

  /**
   * Your StockSpanner object will be instantiated and called as such:  * StockSpanner obj = new StockSpanner();  * int param_1 = obj.next(price);
   */

  @Test
  void test() {

  }
}
