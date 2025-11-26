package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class KClosestPointstoOrigin973Test {
  class Solution {
    public int[][] kClosest(int[][] points, int k) {
      var heap = new PriorityQueue<double[]>(Comparator.comparingDouble(dot -> dot[0]));
      for (int[] point : points) {
        heap.offer(new double[]{
            Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2)), point[0], point[1]
        });
      }

      int[][] result = new int[k][];
      while (k > 0) {
        double[] point = heap.poll();
        result[k - 1] = new int[]{(int) point[1], (int) point[2]};
        k--;
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
