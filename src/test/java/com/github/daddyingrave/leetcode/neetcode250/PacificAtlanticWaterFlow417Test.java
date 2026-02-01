package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacificAtlanticWaterFlow417Test {
  class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      boolean[][] pacific = new boolean[heights.length][heights[0].length];
      boolean[][] atlantic = new boolean[heights.length][heights[0].length];

      for (int row = 0; row < heights.length; row++) {
        dfs(row, 0, heights[row][0], pacific, heights);
        dfs(row, heights[row].length - 1, heights[row][heights[row].length - 1], atlantic, heights);
      }

      for (int col = 0; col < heights[0].length; col++) {
        dfs(0, col, heights[0][col], pacific, heights);
        dfs(heights.length - 1, col, heights[heights.length - 1][col], atlantic, heights);
      }

      var result = new ArrayList<List<Integer>>();
      for (int row = 0; row < heights.length; row++) {
        for (int col = 0; col < heights[row].length; col++) {
          if (pacific[row][col] && atlantic[row][col]) {
            result.add(List.of(row, col));
          }
        }
      }

      return result;
    }

    void dfs(int row, int col, int prevHeight, boolean[][] visited, int[][] heights) {
      if (row < 0 || col < 0 || row >= heights.length
          || col >= heights[row].length || prevHeight > heights[row][col] || visited[row][col]) {
        return;
      }

      visited[row][col] = true;

      dfs(row + 1, col, heights[row][col], visited, heights);
      dfs(row - 1, col, heights[row][col], visited, heights);
      dfs(row, col + 1, heights[row][col], visited, heights);
      dfs(row, col - 1, heights[row][col], visited, heights);
    }
  }

  @Test
  void test() {

  }
}
