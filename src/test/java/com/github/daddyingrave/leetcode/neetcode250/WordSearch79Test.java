package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordSearch79Test {
  class Solution {
    public boolean exist(char[][] board, String word) {
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (backtrack(row, col, 0, board, word)) {
            return true;
          }
        }
      }

      return false;
    }

    boolean backtrack(int row, int col, int i, char[][] board, String word) {
      if (i == word.length()) {
        return true;
      }

      if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
          board[row][col] != word.charAt(i) || board[row][col] == '#') {
        return false;
      }

      board[row][col] = '#';
      boolean res = backtrack(row + 1, col, i + 1, board, word) ||
          backtrack(row, col + 1, i + 1, board, word) ||
          backtrack(row - 1, col, i + 1, board, word) ||
          backtrack(row, col - 1, i + 1, board, word);
      board[row][col] = word.charAt(i);

      return res;
    }
  }

  @Test
  void test() {

  }
}
