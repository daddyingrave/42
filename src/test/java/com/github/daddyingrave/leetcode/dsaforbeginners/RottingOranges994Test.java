package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RottingOranges994Test {
  public int orangesRotting(int[][] grid) {
    int freshOranges = 0;
    var queue = new ArrayDeque<Point>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new Point(i, j));
        }
        if (grid[i][j] == 1) {
          freshOranges++;
        }
      }
    }

    int time = 0;

    int maxRow = grid.length;
    int maxCol = grid[0].length;
    while (freshOranges > 0 && !queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        var current = queue.poll();
        size--;

        for (int[] direction : directions) {
          var next = new Point(current.row + direction[0], current.col + direction[1]);
          if (next.row < 0 || next.col < 0 || next.row >= maxRow || next.col >= maxCol) {
            continue;
          }
          if (grid[next.row][next.col] == 0 || grid[next.row][next.col] == 2) {
            continue;
          }

          if (grid[next.row][next.col] == 1) {
            queue.offer(next);
            grid[next.row][next.col] = 2;
            freshOranges--;
          }
        }
      }

      time++;
    }

    return freshOranges > 0 ? -1 : time;
  }

  int[][] directions = new int[][]{
      {-1, 0}, {0, 1}, {1, 0}, {0, -1}
  };

  record Point(int row, int col) {
  }

  @Test
  void test() {
    assertEquals(4, orangesRotting(new int[][]{
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    }));
    assertEquals(-1, orangesRotting(new int[][]{
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    }));
    assertEquals(0, orangesRotting(new int[][]{
        {0, 2},
    }));
    assertEquals(0, orangesRotting(new int[][]{
        {0},
    }));
    assertEquals(-1, orangesRotting(new int[][]{
        {1},
    }));
    assertEquals(0, orangesRotting(new int[][]{
        {2},
    }));
  }
}
