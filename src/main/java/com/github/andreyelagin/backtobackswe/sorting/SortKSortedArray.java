package com.github.andreyelagin.backtobackswe.sorting;

import java.util.PriorityQueue;

public class SortKSortedArray {
  public int[] sortNearlySortedArray(int[] arr, int k) {
    var result = new int[arr.length];
    var minHeap = new PriorityQueue<Integer>();
    
    for (int j = 0; j < k && j < arr.length; j++) {
      minHeap.offer(arr[j]);
    }

    for (int i = 0; i < result.length; i++) {
      if (k < result.length) {
        minHeap.offer(arr[k++]);
      }
      result[i] = minHeap.poll();
    }

    return result;
  }
}
