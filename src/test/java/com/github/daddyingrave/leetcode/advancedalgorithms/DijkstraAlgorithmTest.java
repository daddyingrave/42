package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithmTest {
  class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
      record Path(int distance, int node) {
      }

      var traversal = new HashMap<Integer, Integer>();
      var adjacency = new HashMap<Integer, Set<Path>>();
      for (int i = 0; i < n; i++) {
        adjacency.put(i, new HashSet<>());
        traversal.put(i, -1);
      }
      for (var edge : edges) {
        adjacency.get(edge.get(0)).add(new Path(edge.get(2), edge.get(1)));
      }

      var heap = new PriorityQueue<Path>(Comparator.comparing(Path::distance));

      heap.add(new Path(0, src));
      while (!heap.isEmpty()) {
        var cur = heap.poll();
        if (traversal.get(cur.node) != -1) {
          continue;
        }

        traversal.put(cur.node, cur.distance);

        for (Path neighbor : adjacency.getOrDefault(cur.node, Set.of())) {
          if (traversal.get(neighbor.node) == -1) {
            heap.add(new Path(cur.distance + neighbor.distance, neighbor.node));
          }
        }
      }

      return traversal;
    }
  }

  @Test
  void test() {
    new Solution().shortestPath(5, List.of(
        List.of(0, 1, 10),
        List.of(0, 2, 3),
        List.of(1, 3, 2),
        List.of(2, 1, 4),
        List.of(2, 3, 8),
        List.of(2, 4, 2),
        List.of(3, 4, 5)
    ), 0);
  }
}
