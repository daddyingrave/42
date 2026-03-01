package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumHeightTrees310Test {
  class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (n == 1) {
        return List.of(0);
      }

      var adj = new ArrayList<Set<Integer>>(n);
      for (int i = 0; i < n; i++) {
        adj.add(new HashSet<>());
      }
      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }

      var leaves = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        if (adj.get(i).size() == 1) {
          leaves.add(i);
        }
      }

      int remaining = n;
      while (remaining > 2) {
        remaining -= leaves.size();
        var newLeaves = new ArrayList<Integer>();

        for (int leaf : leaves) {
          for (int neighbor : adj.get(leaf)) {
            adj.get(neighbor).remove(leaf);
            if (adj.get(neighbor).size() == 1) {
              newLeaves.add(neighbor);
            }
          }
        }
        leaves = newLeaves;
      }

      return leaves;
    }
  }

  @Test
  void test() {
    assertThat(new Solution().findMinHeightTrees(
        6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}), containsInAnyOrder(3, 4)
    );
    assertThat(new Solution().findMinHeightTrees(
        5, new int[][]{{0, 1}, {3, 1}, {2, 3}, {4, 1}}), containsInAnyOrder(1, 3)
    );
  }
}
