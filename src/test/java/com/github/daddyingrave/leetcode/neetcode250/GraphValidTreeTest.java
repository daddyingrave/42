package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GraphValidTreeTest {
  class Solution {
    public boolean validTree(int n, int[][] edges) {
      var adj = new ArrayList<Set<Integer>>();
      for (int i = 0; i < n; i++) {
        adj.add(new HashSet<>());
      }

      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }

      var visited = new HashSet<Integer>();
      return dfs(0, -1, adj, visited, new HashSet<>()) && visited.size() == n;
    }

    boolean dfs(int node, int parent, List<Set<Integer>> adj, Set<Integer> visited, Set<Integer> path) {
      if (path.contains(node)) {
        return false;
      }

      visited.add(node);
      path.add(node);

      for (Integer child : adj.get(node)) {
        if (child == parent) {
          continue;
        }
        if (visited.contains(child) ||!dfs(child, node, adj, visited, path)) {
          return false;
        }
      }

      path.remove(node);

      return true;
    }
  }

  @Test
  void test() {

  }
}
