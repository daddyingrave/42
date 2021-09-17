package com.github.andreyelagin.leetcode.search;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
  public int findKthLargest(int[] nums, int k) {
    var heap = new PriorityQueue<Integer>();

    for (int num : nums) {
      if (heap.size() < k) {
        heap.offer(num);
      } else {
        if (heap.peek() < num) {
          heap.remove();
          heap.offer(num);
        }
      }
    }
    
    return heap.peek();
  }
}
