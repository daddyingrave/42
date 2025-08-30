package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule207Test {
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      var adjacency = new ArrayList<List<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        adjacency.add(new ArrayList<>());
      }
      for (int[] prerequisite : prerequisites) {
        adjacency.get(prerequisite[0]).add(prerequisite[1]);
      }

      var visited = new HashSet<Integer>();
      for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, new HashSet<>(), visited, adjacency)) {
          return false;
        }
      }

      return true;
    }

    boolean dfs(
        int node,
        Set<Integer> currentPath,
        Set<Integer> visited,
        List<List<Integer>> adj
    ) {
      if (currentPath.contains(node)) {
        return false;
      }
      if (visited.contains(node)) {
        return true;
      }

      currentPath.add(node);
      visited.add(node);

      if (node < adj.size()) {
        for (Integer next : adj.get(node)) {
          if (!dfs(next, currentPath, visited, adj)) {
            return false;
          }
          currentPath.remove(next);
        }
      }

      return true;
    }
  }

  @Test
  void test() {

  }
}
