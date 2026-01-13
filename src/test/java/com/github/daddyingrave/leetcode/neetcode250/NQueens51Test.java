package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class NQueens51Test {
  class Solution {
    public List<List<String>> solveNQueens(int n) {
      String[][] board = new String[n][n];
      for (String[] strings : board) {
        Arrays.fill(strings, ".");
      }

      var result = new ArrayList<List<String>>();
      backtrack(0, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), result);

      return result;
    }

    void backtrack(
        int row,
        String[][] board,
        Set<Integer> colSet,
        Set<Integer> positiveDiagonal,
        Set<Integer> negativeDiagonal,
        List<List<String>> result
    ) {
      if (row == board.length) {
        result.add(Arrays.stream(board).map(r -> String.join("", r)).toList());
        return;
      }

      for (int col = 0; col < board.length; col++) {
        if (colSet.contains(col) || positiveDiagonal.contains(row + col) || negativeDiagonal.contains(row - col)) {
          continue;
        }

        colSet.add(col);
        positiveDiagonal.add(row + col);
        negativeDiagonal.add(row - col);
        board[row][col] = "Q";

        backtrack(row + 1, board, colSet, positiveDiagonal, negativeDiagonal, result);

        colSet.remove(col);
        positiveDiagonal.remove(row + col);
        negativeDiagonal.remove(row - col);
        board[row][col] = ".";
      }
    }
  }

  @Test
  void test() {

  }
}
