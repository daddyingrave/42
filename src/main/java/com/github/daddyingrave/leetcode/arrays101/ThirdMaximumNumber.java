package com.github.daddyingrave.leetcode.arrays101;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdMaximumNumber {
  public int thirdMax(int[] nums) {
    var set = new HashSet<Integer>();
    var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    for (int num : nums) {
      if (set.add(num)) {
        heap.add(num);
      }
    }

    var first = heap.poll();
    heap.poll();
    var third = heap.poll();

    if (third != null) {
      return third;
    } else {
      return first;
    }
  }
}
