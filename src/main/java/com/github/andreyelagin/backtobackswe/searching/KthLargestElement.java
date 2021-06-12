package com.github.andreyelagin.backtobackswe.searching;

import java.util.PriorityQueue;

public class KthLargestElement {
  public int kthLargest(int[] arr, int k) {
    var heap = new PriorityQueue<Integer>();

    for (int i : arr) {
      if (heap.size() > k) {
        heap.poll();
      }

      heap.offer(i);
    }

    while (heap.size() > k) {
      heap.poll();
    }

    return heap.peek();
  }
}
