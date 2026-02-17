package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseScheduleIV1462Test {
  class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      var adj = new ArrayList<Set<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        adj.add(new HashSet<>());
      }
      for (int[] prer : prerequisites) {
        adj.get(prer[1]).add(prer[0]);
      }

      var prereqs = new HashMap<Integer, Set<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        dfs(i, adj, prereqs);
      }

      var result = new ArrayList<Boolean>();
      for (int[] query : queries) {
        result.add(prereqs.get(query[1]).contains(query[0]));
      }

      return result;
    }

    Set<Integer> dfs(int course, List<Set<Integer>> adj, Map<Integer, Set<Integer>> flatPrereq) {
      if (flatPrereq.containsKey(course)) {
        return flatPrereq.get(course);
      }
      var prereqs = new HashSet<Integer>();
      for (Integer p : adj.get(course)) {
        prereqs.addAll(dfs(p, adj, flatPrereq));
      }

      prereqs.add(course);
      flatPrereq.put(course, prereqs);

      return prereqs;
    }
  }

  @Test
  void test() {

  }
}
