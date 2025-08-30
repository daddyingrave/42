package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSortTest {
  class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
      var adjacency = new ArrayList<List<Integer>>();
      for (int i = 0; i < n; i++) {
        adjacency.add(new ArrayList<>());
      }
      for (int[] edge : edges) {
        adjacency.get(edge[0]).add(edge[1]);
      }

      var visited = new HashSet<Integer>();
      var traversal = new ArrayList<Integer>();

      for (int i = 0; i < n; i++) {
        if (!dfs(i, traversal, visited, new HashSet<>(), adjacency)) {
          return List.of();
        }
      }

      Collections.reverse(traversal);

      return traversal;
    }

    boolean dfs(int node, List<Integer> postOrder, Set<Integer> visited, Set<Integer> path, List<List<Integer>> adjacency) {
      if (path.contains(node)) {
        return false;
      }
      if (visited.contains(node)) {
        return true;
      }
      visited.add(node);
      path.add(node);

      var neighbors = node >= adjacency.size() ? List.<Integer>of() : adjacency.get(node);
      for (Integer nextNode : neighbors) {
        if (!dfs(nextNode, postOrder, visited, path, adjacency)) {
          return false;
        }

        path.remove(nextNode);
      }

      postOrder.add(node);

      return true;
    }
  }

  @Test
  void test() {
    new Solution().topologicalSort(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}});
  }
}
