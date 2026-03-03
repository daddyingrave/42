package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PathWithMinimumEffort1631Test {
  class Solution {
    record Pair(int row, int col) {
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
      int rows = heights.length;
      int cols = heights[0].length;

      var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(l -> l[0]));
      minHeap.offer(new int[]{0, 0, 0});

      var visited = new HashSet<Pair>();
      while (!minHeap.isEmpty()) {
        int[] cur = minHeap.poll();
        Pair pair = new Pair(cur[1], cur[2]);

        if (visited.contains(pair)) {
          continue;
        }

        visited.add(pair);
        if (pair.row == rows - 1 && pair.col == cols - 1) {
          return cur[0];
        }

        for (int[] direction : directions) {
          int newRow = direction[0] + pair.row;
          int newCol = direction[1] + pair.col;
          var newPair = new Pair(newRow, newCol);
          if (newRow >= rows || newCol >= cols || newRow < 0 || newCol < 0 || visited.contains(newPair)) {
            continue;
          }

          minHeap.offer(new int[]{
              Math.max(cur[0], Math.abs(heights[pair.row][pair.col] - heights[newRow][newCol])),
              newRow, newCol
          });
        }
      }

      return 0;
    }
  }

  @Test
  void test() {
    new Solution().minimumEffortPath(new int[][]{
        {1, 1, 1},
        {3, 2, 4},
        {2, 5, 4}
    });
  }
}
