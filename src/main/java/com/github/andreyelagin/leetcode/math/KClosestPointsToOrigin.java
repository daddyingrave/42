package com.github.andreyelagin.leetcode.math;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
  public int[][] kClosest(int[][] points, int k) {
    var heap = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getKey));
    int[] start = new int[]{0, 0};

    for (int i = 0; i < points.length; i++) {
      heap.add(Map.entry(distance(start, points[i]), i));
    }

    int[][] result = new int[k][];
    while (k > 0) {
      result[k - 1] = points[heap.poll().getValue()];
      k--;
    }
    
    return result;
  }

  private int distance(int[] p1, int[] p2) {
    return (int) (Math.pow(p2[0] - p1[0], 2) + Math.pow(p1[1] - p2[1], 2));
  }
}
