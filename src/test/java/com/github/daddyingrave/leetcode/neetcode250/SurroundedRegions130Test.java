package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions130Test {
  class Solution {
    public void solve(char[][] board) {
      int rows = board.length;
      int cols = board[0].length;

      for (int row = 0; row < rows; row++) {
        if (board[row][0] == 'O') {
          dfs(row, 0, board);
        }
        if (board[row][cols - 1] == 'O') {
          dfs(row, cols - 1, board);
        }
      }

      for (int col = 0; col < cols; col++) {
        if (board[0][col] == 'O') {
          dfs(0, col, board);
        }
        if (board[rows - 1][col] == 'O') {
          dfs(rows - 1, col, board);
        }
      }

      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          if (board[row][col] == 'O') {
            board[row][col] = 'X';
          }
          if (board[row][col] == '%') {
            board[row][col] = 'O';
          }
        }
      }
    }

    void dfs(int row, int col, char[][] board) {
      if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != 'O') {
        return;
      }

      board[row][col] = '%';

      dfs(row + 1, col, board);
      dfs(row - 1, col, board);
      dfs(row, col + 1, board);
      dfs(row, col - 1, board);
    }
  }

  @Test
  void test() {

  }
}
