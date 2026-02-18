package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NumberofConnectedComponentsinanUndirectedGraphTest {
  class Solution {
    public int countComponents(int n, int[][] edges) {
      var adj = new ArrayList<Set<Integer>>();
      for (int i = 0; i < n; i++) {
        adj.add(new HashSet<>());
      }

      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }

      var visited = new HashSet<Integer>();
      int connected = 0;
      for (int i = 0; i < n; i++) {
        if (!visited.contains(i)) {
          dfs(i, -1, visited, adj);
          connected++;
        }
      }

      return connected;
    }

    void dfs(int node, int parent, Set<Integer> visited, List<Set<Integer>> adj) {
      if (visited.contains(node)) {
        return;
      }

      visited.add(node);

      for (Integer i : adj.get(node)) {
        if (i == parent) {
          continue;
        }
        dfs(i, node, visited, adj);
      }
    }
  }

  @Test
  void test() {
    new Solution().countComponents(2, new int[][]{{1, 0}});
  }
}
