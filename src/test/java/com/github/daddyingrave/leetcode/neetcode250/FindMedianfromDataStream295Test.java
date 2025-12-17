package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class FindMedianfromDataStream295Test {
  class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {
      if (!minHeap.isEmpty() && minHeap.peek() < num) {
        minHeap.offer(num);
      } else {
        maxHeap.offer(num);
      }

      if (maxHeap.size() - minHeap.size() > 1) {
        minHeap.offer(maxHeap.poll());
      } else if (minHeap.size() - maxHeap.size() > 1) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
      if (minHeap.size() > maxHeap.size()) {
        return minHeap.peek();
      } else if (minHeap.size() == maxHeap.size()) {
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
      } else {
        return maxHeap.peek();
      }
    }
  }

  @Test
  void test() {

  }
}
