package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseSchedule207Test {
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      var adj = new HashMap<Integer, Set<Integer>>();
      for (int[] prerequisite : prerequisites) {
        var prerequisiteCourses = adj.computeIfAbsent(prerequisite[0], k -> new HashSet<>());
        prerequisiteCourses.add(prerequisite[1]);
      }

      for (var kv : adj.entrySet()) {
        var visited = new HashSet<Integer>();
        visited.add(kv.getKey());
        var queue = new LinkedList<Integer>();
        for (Integer p : kv.getValue()) {
          queue.offer(p);
        }

        while (!queue.isEmpty()) {
          int size = queue.size();
          while (size > 0) {
            size--;
            int next = queue.poll();
            if (kv.getKey() == next) {
              return false;
            }
            if (visited.contains(next)) {
              continue;
            }
            visited.add(next);
            for (Integer nextCourse : adj.getOrDefault(next, Set.of())) {
              queue.offer(nextCourse);
            }
          }
        }
      }

      return true;
    }
  }

  @Test
  void test() {
    assertTrue(new Solution().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
  }
}
