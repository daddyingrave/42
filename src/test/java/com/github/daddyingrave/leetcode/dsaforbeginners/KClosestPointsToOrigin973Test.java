package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin973Test {
  public int[][] kClosest(int[][] points, int k) {
    var heap = new PriorityQueue<int[]>((left, right) -> {
      // √(x1 - x2)2 + (y1 - y2)2
      double distance = Math.pow(left[0], 2) + Math.pow(left[1], 2) -
          Math.pow(right[0], 2) + Math.pow(right[1], 2);
      if (distance == 0) {
        return 0;
      } else if (distance > 0) {
        return 1;
      } else {
        return - 1;
      }
    });

    for (int[] point : points) {
      heap.offer(point);
    }

    int[][] result = new int[k][];
    while (k > 0) {
      result[k - 1] = heap.poll();
      k--;
    }

    return result;
  }

  @Test
  void test() {
    kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
  }
}
