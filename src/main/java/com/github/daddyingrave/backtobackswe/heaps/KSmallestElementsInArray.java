package com.github.daddyingrave.backtobackswe.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestElementsInArray {
  public List<Integer> kSmallestElements(int[] elements, int k) {
    var result = new ArrayList<Integer>();
    var heap = new PriorityQueue<Integer>();

    for (int element : elements) {
      heap.offer(element);
    }

    for (int i = 0; i < k; i++) {
      result.add(heap.poll());
    }
    
    return result;
  }
}
