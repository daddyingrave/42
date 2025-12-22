package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class IPO502Test {
  class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      var minHeap = new PriorityQueue<>(Comparator.comparingInt((int[] l) -> l[0]));
      var maxHeap = new PriorityQueue<>((int[] l, int[] r) -> Integer.compare(r[1], l[1]));

      for (int i = 0; i < profits.length; i++) {
        minHeap.offer(new int[]{capital[i], profits[i]});
      }

      while (k > 0) {
        while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
          maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.isEmpty()) {
          return w;
        }

        w += maxHeap.poll()[1];
        k--;
      }

      return w;
    }
  }

  @Test
  void test() {

  }
}
