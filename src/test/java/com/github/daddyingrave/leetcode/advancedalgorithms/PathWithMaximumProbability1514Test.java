package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability1514Test {
  class Solution {
    public double maxProbability(
        int n,
        int[][] edges,
        double[] succProb,
        int start_node,
        int end_node
    ) {
      record Path(int node, double probability) {
      }

      var adjacency = new ArrayList<List<Path>>();
      for (int i = 0; i < n; i++) {
        adjacency.add(i, new ArrayList<>());
      }
      for (int i = 0; i < edges.length; i++) {
        List<Path> currentNodePaths = adjacency.get(edges[i][0]);
        var newPath = new Path(edges[i][1], succProb[i]);
        currentNodePaths.add(newPath);
        adjacency.get(newPath.node).add(new Path(edges[i][0], succProb[i]));
      }


      boolean[] visited = new boolean[n];
      var heap = new PriorityQueue<Path>(Comparator.comparing(Path::probability).reversed());
      heap.add(new Path(start_node, 1));

      while (!heap.isEmpty()) {
        var cur = heap.poll();
        if (visited[cur.node]) {
          continue;
        }
        visited[cur.node] = true;


        if (cur.node == end_node) {
          return cur.probability;
        }

        for (Path neighbor : adjacency.get(cur.node)) {
          if (!visited[neighbor.node]) {
            heap.add(new Path(neighbor.node, cur.probability * neighbor.probability));
          }
        }
      }

      return 0.0;
    }
  }

  @Test
  void test() {

  }
}
