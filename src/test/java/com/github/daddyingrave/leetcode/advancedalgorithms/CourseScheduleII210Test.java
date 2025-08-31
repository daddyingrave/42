package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleII210Test {
  class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      var adjacency = new ArrayList<List<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        adjacency.add(new ArrayList<>());
      }
      for (int i = 0; i < prerequisites.length; i++) {
        adjacency.get(prerequisites[i][0]).add(prerequisites[i][1]);
      }

      var visited = new HashSet<Integer>();
      var traversed = new ArrayList<Integer>();

      for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, traversed, visited, new HashSet<>(), adjacency)) {
          return new int[]{};
        }
      }

      Collections.reverse(traversed);
      return traversed.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    boolean dfs(int node, List<Integer> traversed, Set<Integer> visited, Set<Integer> path, List<List<Integer>> adj) {
      if (path.contains(node)) {
        return false;
      }
      if (visited.contains(node)) {
        return true;
      }

      visited.add(node);
      path.add(node);

      if (node < adj.size()) {
        for (Integer neighbor : adj.get(node)) {
          if (!dfs(neighbor, traversed, visited, path, adj)) {
            return false;
          }

          path.remove(neighbor);
        }

        traversed.add(node);
      }

      return true;
    }
  }

  @Test
  void test() {

  }
}
