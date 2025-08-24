package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime743Test {
  class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
      record Path(int node, int distance) {
      }

      var adjacency = new HashMap<Integer, List<Path>>();
      for (int i = 1; i <= n; i++) {
        adjacency.put(i, new ArrayList<>());
      }
      for (int[] time : times) {
        adjacency.get(time[0]).add(new Path(time[1], time[2]));
      }

      var heap = new PriorityQueue<Path>(Comparator.comparing(Path::distance));
      heap.add(new Path(k, 0));

      int[] traversal = new int[n + 1];
      Arrays.fill(traversal, Integer.MAX_VALUE);
      traversal[k] = 0;

      while (!heap.isEmpty()) {
        var cur = heap.poll();

        for (var neighbor : adjacency.get(cur.node)) {
          int newDistance = cur.distance + neighbor.distance;

          if (newDistance < traversal[neighbor.node]) {
            traversal[neighbor.node] = newDistance;
            heap.add(new Path(neighbor.node, newDistance));
          }
        }
      }

      int max = -1;
      for (int i = 1; i <= n; i++) {
        if (traversal[i] == Integer.MAX_VALUE) {
          return -1;
        }

        max = Math.max(traversal[i], max);
      }

      return max;
    }
  }

  @Test
  void test() {

  }
}
