package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinaStream703Test {

  class KthLargest {
    final int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
      this.k = k;
      for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
          minHeap.poll();
        }
      }
    }

    public int add(int val) {
      minHeap.offer(val);
      if (minHeap.size() > k) {
        minHeap.poll();
      }

      return minHeap.peek();
    }
  }


  @Test
  void test() {

  }
}
