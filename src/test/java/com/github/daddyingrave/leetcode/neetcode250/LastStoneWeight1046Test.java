package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class LastStoneWeight1046Test {
  class Solution {
    public int lastStoneWeight(int[] stones) {
      var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
      for (int stone : stones) {
        heap.offer(stone);
      }

      while (heap.size() > 1) {
        int abs = Math.abs(heap.poll() - heap.poll());
        if (abs > 0 ) {
          heap.offer(abs);
        }
      }

      if (heap.isEmpty()) {
        return 0;
      } else {
        return heap.peek();
      }
    }
  }

  @Test
  void test() {

  }
}
`
