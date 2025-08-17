package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class FindMedianFromDataStream295Test {
  class MedianFinder {
    PriorityQueue<Integer> maxHeapForSmall = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeapForBig = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
      if (!minHeapForBig.isEmpty() && minHeapForBig.peek() < num) {
        minHeapForBig.add(num);
      } else {
        maxHeapForSmall.add(num);
      }

      if (maxHeapForSmall.size() - minHeapForBig.size() > 1) {
        minHeapForBig.add(maxHeapForSmall.poll());
      } else if (minHeapForBig.size() - maxHeapForSmall.size() > 1) {
        maxHeapForSmall.add(minHeapForBig.poll());
      }
    }

    public double findMedian() {
      if (maxHeapForSmall.size() == minHeapForBig.size()) {
        return (maxHeapForSmall.peek() + minHeapForBig.peek()) / 2.0;
      } else if (maxHeapForSmall.size() > minHeapForBig.size()) {
        return maxHeapForSmall.peek();
      } else {
        return minHeapForBig.peek();
      }
    }
  }

  @Test
  void test() {
    var med = new MedianFinder();
    med.addNum(-1);
    assertEquals(-1, med.findMedian());
    med.addNum(-2);
    assertEquals(-1.5, med.findMedian());
    med.addNum(-3);
    assertEquals(-2, med.findMedian());
  }
}
