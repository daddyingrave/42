package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseSchedule207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    var adjacency = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < numCourses; i++) {
      adjacency.put(i, new HashSet<>());
    }

    for (int[] prerequisite : prerequisites) {
      adjacency.get(prerequisite[0]).add(prerequisite[1]);
    }

    var visited = new HashSet<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, adjacency, visited)) {
        return false;
      }
    }

    return true;
  }

  boolean dfs(int current, Map<Integer, Set<Integer>> adjacency, Set<Integer> visited) {
    if (visited.contains(current)) {
      return false;
    }
    if (adjacency.get(current).isEmpty()) {
      return true;
    }

    visited.add(current);
    for (Integer i : adjacency.get(current)) {
      if (!dfs(i, adjacency, visited)) {
        return false;
      }
    }

    visited.remove(current);
    adjacency.put(current, Set.of());

    return true;
  }


  @Test
  void test() {
    assertTrue(canFinish(2, new int[][]{{1, 0}}));
    assertFalse(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    assertFalse(canFinish(20, new int[][]{
        {0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}
    }));
    assertTrue(canFinish(20, new int[][]{
        {1, 4}, {2, 4}, {3, 1}, {3, 2}
    }));
    assertTrue(canFinish(2, new int[][]{{0, 1}}));
  }
}
