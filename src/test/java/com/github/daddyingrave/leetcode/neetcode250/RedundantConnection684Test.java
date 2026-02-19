package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RedundantConnection684Test {
  class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      var adj = new ArrayList<Set<Integer>>();
      for (int i = 0; i <= edges.length; i++) {
        adj.add(new HashSet<>());
      }
      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }

      var visited = new HashSet<Integer>();
      var cycle = new HashSet<Integer>();
      if (dfs(1, -1, adj, visited, cycle) == -1) {
        for (int j = edges.length - 1; j >= 0; j--) {
          if (cycle.contains(edges[j][0]) && cycle.contains(edges[j][1])) {
            return new int[]{edges[j][0], edges[j][1]};
          }
        }
      }

      return new int[]{};
    }

    int dfs(int node, int parent, List<Set<Integer>> adj, Set<Integer> visited, Set<Integer> cycle) {
      if (visited.contains(node)) {
        cycle.add(node);
        return node;
      }

      visited.add(node);

      for (Integer i : adj.get(node)) {
        if (i == parent) {
          continue;
        }

        int cycleNode = dfs(i, node, adj, visited, cycle);
        if (cycleNode != -1) {
          cycle.add(node);
          if (node == cycleNode) {
            return -1;
          }

          return cycleNode;
        }
      }

      return -1;
    }
  }

  @Test
  void test() {
    var sol = new Solution();
    assertArrayEquals(new int[]{2, 3}, sol.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    assertArrayEquals(new int[]{1, 4}, sol.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));

  }
}
