package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class SwimInRisingWater778Test {
  class Solution {
    public int swimInWater(int[][] grid) {
      int rows = grid.length;
      int cols = grid[0].length;

      boolean[][] visited = new boolean[rows][cols];
      int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

      var heap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
      heap.add(new int[]{grid[0][0], 0, 0});
      visited[0][0] = true;

      while (!heap.isEmpty()) {
        var cur = heap.poll();

        int time = cur[0];
        int curRow = cur[1];
        int curCol = cur[2];
        if (curRow == rows - 1 && curCol == cols - 1) {
          return time;
        }

        for (int[] direction : directions) {
          int nextRow = curRow + direction[0];
          int nextCol = curCol + direction[1];
          if (nextRow >= rows || nextCol >= cols || nextRow < 0 || nextCol < 0) {
            continue;
          }
          if (visited[nextRow][nextCol]) {
            continue;
          }

          visited[nextRow][nextCol] = true;
          heap.offer(new int[]{Math.max(time, grid[nextRow][nextCol]), nextRow, nextCol});
        }
      }

      return rows * cols;
    }
  }

  @Test
  void test() {
    assertEquals(16, new Solution().swimInWater(new int[][]{
        {0, 1, 2, 3, 4},
        {24, 23, 22, 21, 5},
        {12, 13, 14, 15, 16},
        {11, 17, 18, 19, 20},
        {10, 9, 8, 7, 6}
    }));
    assertEquals(3, new Solution().swimInWater(new int[][]{
        {0, 2},
        {1, 3},
    }));
  }
}
