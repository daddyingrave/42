package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinCosttoConnectAllPoints1584Test {
  class Solution {
    record Point(int x, int y) {
    }

    record Path(Point p, int length) {
    }

    public int minCostConnectPoints(int[][] points) {
      var adj = new HashMap<Point, List<Path>>();
      for (int i = 0; i < points.length; i++) {
        var point = new Point(points[i][0], points[i][1]);
        adj.putIfAbsent(point, new ArrayList<>());
        for (int j = 0; j < points.length; j++) {
          if (i == j) {
            continue;
          }

          Point nextPoint = new Point(points[j][0], points[j][1]);
          adj.get(point).add(new Path(nextPoint, Math.abs(point.x - nextPoint.x) + Math.abs(point.y - nextPoint.y)));
        }
      }

      var minHeap = new PriorityQueue<>(Comparator.comparingInt(Path::length));
      minHeap.offer(new Path(new Point(points[0][0], points[0][1]), 0));
      var visited = new HashSet<Point>();
      int cost = 0;

      while (visited.size() != points.length) {
        Path currentPath = minHeap.poll();
        if (visited.contains(currentPath.p)) {
          continue;
        }

        visited.add(currentPath.p);
        cost += currentPath.length;

        for (Path neighbour : adj.get(currentPath.p)) {
          if (!visited.contains(neighbour.p)) {
            minHeap.offer(new Path(neighbour.p, neighbour.length));
          }
        }
      }

      return cost;
    }
  }

  @Test
  void test() {

  }
}
