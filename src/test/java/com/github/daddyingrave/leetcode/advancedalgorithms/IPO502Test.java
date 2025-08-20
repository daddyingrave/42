package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class IPO502Test {
  class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      record Deal(int profit, int capital) {
      }
      var maxHeap = new PriorityQueue<Deal>((l, r) -> r.profit - l.profit);
      var minHeap = new PriorityQueue<Deal>(Comparator.comparingInt(l -> l.capital));

      for (int i = 0; i < profits.length; i++) {
        minHeap.add(new Deal(profits[i], capital[i]));
      }

      for (int i = 0; i < k; i++) {
        while (!minHeap.isEmpty() && minHeap.peek().capital <= w) {
          maxHeap.add(minHeap.poll());
        }

        if (!maxHeap.isEmpty()) {
          w += maxHeap.poll().profit;
        }
      }

      return w;
    }
  }

  @Test
  void test() {
    assertEquals(
        4, new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1})
    );
  }
}
