package com.github.andreyelagin.backtobackswe.heaps;

import java.util.*;

public class LargestElementsInImmutableMaxHeap {
  public List<Integer> kLargestInImmutableHeap(int[] immutableHeap, int k) {
    var result = new ArrayList<Integer>();
    int curIndex = 0;
    var candidates = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o2[0], o1[0]));

    if (k == 0) {
      return result;
    }

    candidates.offer(new int[]{immutableHeap[0], 0});

    while (k > 0) {
      if (!candidates.isEmpty()) {
        int[] max = candidates.poll();
        result.add(max[0]);
        var removedIndex = max[1];

        if (leftIndex(removedIndex) < immutableHeap.length) {
          candidates.offer(new int[]{left(immutableHeap, removedIndex), leftIndex(removedIndex)});
        }
        if (rightIndex(removedIndex) < immutableHeap.length) {
          candidates.offer(new int[]{right(immutableHeap, removedIndex), rightIndex(removedIndex)});
        }
        k--;
      } else {
        break;
      }
    }

    return result;
  }


  private int leftIndex(int index) {
    return (index * 2 + 1);
  }

  private int rightIndex(int index) {
    return (index * 2 + 2);
  }

  private int left(int[] arr, int index) {
    return arr[index * 2 + 1];
  }

  private int right(int[] arr, int index) {
    return arr[index * 2 + 2];
  }
}
