package com.github.andreyelagin.leetcode.search;

import java.util.*;

public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    int[] result = new int[k];
    var counts = new HashMap<Integer, Integer>();
    
    for (int num : nums) {
      counts.compute(num, (key, v) -> v == null ? 1 : ++v);
    }

    var heap = new PriorityQueue<Integer>((n1, n2) -> counts.get(n1) - counts.get(n2));

    for (int num : counts.keySet()) {
      heap.offer(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    for (int i = 0; i < k; i++) {
      result[i] = heap.poll();
    }
    
    return result;
  }
}
