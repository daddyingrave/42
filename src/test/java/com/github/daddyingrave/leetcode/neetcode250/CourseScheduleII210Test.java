package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseScheduleII210Test {
  class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      var adj = new HashMap<Integer, List<Integer>>();
      for (int[] pr : prerequisites) {
        adj.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
      }

      var result = new ArrayList<Integer>();
      var cycle = new HashSet<Integer>();
      var visited = new HashSet<Integer>();

      for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, adj, cycle, visited, result)) {
          return new int[0];
        }
      }

      return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    boolean dfs(
        int course,
        Map<Integer, List<Integer>> adj,
        Set<Integer> cycle,
        Set<Integer> visited,
        List<Integer> result
    ) {
      if (cycle.contains(course)) {
        return false;
      }
      if (visited.contains(course)) {
        return true;
      }

      cycle.add(course);
      for (Integer p : adj.getOrDefault(course, List.of())) {
        if (!dfs(p, adj, cycle, visited, result)) {
          return false;
        }
      }

      cycle.remove(course);
      visited.add(course);
      result.add(course);

      return true;
    }
  }

  @Test
  void test() {

  }
}
