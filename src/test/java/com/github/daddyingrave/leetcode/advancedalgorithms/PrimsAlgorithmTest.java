package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithmTest {
  class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
      record Path(int node, int distance) {
      }
      var adjacency = new HashMap<Integer, List<Path>>();
      boolean[] visited = new boolean[n];
      for (int i = 0; i < n; i++) {
        adjacency.put(i, new ArrayList<>());
      }
      for (List<Integer> edge : edges) {
        adjacency.get(edge.get(0)).add(new Path(edge.get(1), edge.get(2)));
        adjacency.get(edge.get(1)).add(new Path(edge.get(0), edge.get(2)));
      }

      var heap = new PriorityQueue<Path>(Comparator.comparing(Path::distance));
      heap.add(new Path(0, 0));

      int mstLength = 0;
      int mstSize = 0;

      while (!heap.isEmpty()) {
        var cur = heap.poll();
        if (visited[cur.node]) {
          continue;
        }
        visited[cur.node] = true;

        mstSize++;
        mstLength += cur.distance;
        if (mstSize == n) {
          return mstLength;
        }

        for (Path neighbor : adjacency.get(cur.node)) {
          if (!visited[neighbor.node]) {
            heap.offer(neighbor);
          }
        }
      }

      return -1;
    }
  }

  @Test
  void test() {

  }
}
