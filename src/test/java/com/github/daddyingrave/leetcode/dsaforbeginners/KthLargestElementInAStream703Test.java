package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class KthLargestElementInAStream703Test {
  // 4, 5, 5, 8, 8
  // 3
  // 2 4 5 8
  // 3
  // 2 3 4 5 8
  // 5
  // 2 3 4 5 5 8
  class KthLargest {
    int k;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.heap = new PriorityQueue<>();
      for (int num : nums) {
        this.heap.offer(num);
      }
      while (heap.size() > k) {
        heap.poll();
      }
    }

    public int add(int val) {
      heap.offer(val);
      while (heap.size() > k) {
        heap.poll();
      }

      return heap.peek();
    }
  }

  @Test
  void test() {
    var problem = new KthLargest(3, new int[]{4, 5, 8, 2});
    assertEquals(4, problem.add(3));
    assertEquals(5, problem.add(5));
    assertEquals(5, problem.add(10));
  }
}
