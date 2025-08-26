package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584Test {
  class Solution {
    public int minCostConnectPoints(int[][] points) {
      record Point(int x, int y) {
      }
      record Path(Point point, int distance) {
      }

      var adjacency = new HashMap<Point, List<Path>>();
      for (int i = 0; i < points.length; i++) {
        var curPoint = new Point(points[i][0], points[i][1]);
        adjacency.put(curPoint, new ArrayList<>());
        for (int j = 0; j < points.length; j++) {
          if (i != j) {
            var neighbor = new Point(points[j][0], points[j][1]);
            int manhattanDistance = Math.abs(curPoint.x - neighbor.x) + Math.abs(curPoint.y - neighbor.y);
            adjacency.get(curPoint).add(new Path(neighbor, manhattanDistance));
          }
        }
      }

      var visited = new HashSet<Point>();
      var heap = new PriorityQueue<Path>(Comparator.comparing(Path::distance));
      heap.offer(new Path(new Point(points[0][0], points[0][1]), 0));
      int distance = 0;

      while (!heap.isEmpty()) {
        var cur = heap.poll();
        if (visited.contains(cur.point)) {
          continue;
        }

        visited.add(cur.point);
        distance += cur.distance;

        if (visited.size() == points.length) {
          return distance;
        }

        for (var neighbor : adjacency.get(cur.point)) {
          if (!visited.contains(neighbor.point)) {
            heap.add(new Path(neighbor.point, neighbor.distance));
          }
        }
      }

      return 0;
    }
  }

  @Test
  void test() {
    int dis = new Solution().minCostConnectPoints(new int[][] {
        {0,0},{2,2},{3,10},{5,2},{7,0}
    });
    System.out.println(dis);
  }
}
