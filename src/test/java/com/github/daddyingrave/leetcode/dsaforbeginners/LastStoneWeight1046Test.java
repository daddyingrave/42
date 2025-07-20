package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class LastStoneWeight1046Test {

  public int lastStoneWeight(int[] stones) {
    var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    for (int stone : stones) {
      heap.offer(stone);
    }

    while (!heap.isEmpty()) {
      var greatest = heap.poll();
      Integer next = null;
      if (!heap.isEmpty()) {
        next = heap.poll();
      }

      if (next == null) {
        return greatest;
      }

      if (greatest - next > 0) {
        heap.offer(greatest - next);
      }
    }

    return 0;
  }

  @Test
  void test() {
    assertEquals(1, lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
  }
}
