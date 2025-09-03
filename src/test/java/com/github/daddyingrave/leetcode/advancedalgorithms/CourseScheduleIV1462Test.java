package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleIV1462Test {
  class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      var adjacency = new ArrayList<List<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        adjacency.add(new ArrayList<>());
      }
      for (int[] prerequisite : prerequisites) {
        adjacency.get(prerequisite[1]).add(prerequisite[0]);
      }

      var preqs = new HashMap<Integer, Set<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        dfs(i, preqs, adjacency);
      }

      var result = new ArrayList<Boolean>();
      for (int[] query : queries) {
        result.add(preqs.get(query[1]).contains(query[0]));
      }

      return result;
    }

    Set<Integer> dfs(int node, Map<Integer, Set<Integer>> prerequisites, List<List<Integer>> adj) {
      if (prerequisites.containsKey(node)) {
        return prerequisites.get(node);
      }
      var preps = new HashSet<Integer>();
      for (Integer neighbor : adj.get(node)) {
        preps.addAll(dfs(neighbor, prerequisites, adj));
      }

      preps.add(node);
      prerequisites.put(node, preps);
      return preps;
    }
  }

  @Test
  void test() {
    new Solution().checkIfPrerequisite(6,
        new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 2}, {5, 3}},
        new int[][]{{0, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 2}, {5, 4}}
    );
  }
}
