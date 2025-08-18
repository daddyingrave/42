package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMedian480Test {
  class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
      var minHeap = new PriorityQueue<Integer>();
      var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
      var toDelete = new HashMap<Integer, Integer>();
      double[] result = new double[nums.length - k + 1];

      for (int i = 0; i < k; i++) {
        maxHeap.add(nums[i]);
      }
      for (int i = 0; i < k / 2; i++) {
        minHeap.add(maxHeap.poll());
      }

      int resultIndex = 0;
      if (k % 2 == 0) {
        result[resultIndex++] = (maxHeap.peek() + minHeap.peek()) / 2.0;
      } else {
        result[resultIndex++] = (double) maxHeap.peek();
      }

      for (int i = k; i < nums.length; i++) {
        toDelete.merge(nums[i - k], 1, Integer::sum);

        if (!minHeap.isEmpty() && nums[i] > minHeap.peek()) {
          minHeap.add(nums[i]);
        } else {
          maxHeap.add(nums[i]);
        }

        if (minHeap.size() - maxHeap.size() > 1) {
          maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
          minHeap.add(maxHeap.poll());
        }

        while (!minHeap.isEmpty() && toDelete.getOrDefault(minHeap.peek(), 0) > 0) {
          toDelete.put(minHeap.peek(), toDelete.get(minHeap.peek()) - 1);
          minHeap.poll();
        }
        while (!maxHeap.isEmpty() && toDelete.getOrDefault(maxHeap.peek(), 0) > 0) {
          toDelete.put(maxHeap.peek(), toDelete.get(maxHeap.peek()) - 1);
          maxHeap.poll();
        }

        if (k % 2 == 0) {
          result[resultIndex++] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
          result[resultIndex++] = (double) maxHeap.peek();
        }
      }

      return result;
    }
  }

  @Test
  void test() {
    assertArrayEquals(
        new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000},
        new Solution().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
    );
  }
}
