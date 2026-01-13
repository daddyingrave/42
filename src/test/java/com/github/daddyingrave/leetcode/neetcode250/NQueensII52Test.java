package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NQueensII52Test {
  class Solution {
    public int totalNQueens(int n) {
      var result = new int[1];
      backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>(), result);

      return result[0];
    }

    void backtrack(
        int row,
        int n,
        Set<Integer> colSet,
        Set<Integer> positiveDiagonal,
        Set<Integer> negativeDiagonal,
        int[] count
    ) {
      if (row == n) {
        count[0]++;
        return;
      }

      for (int col = 0; col < n; col++) {
        if (colSet.contains(col) || positiveDiagonal.contains(row + col) || negativeDiagonal.contains(row - col)) {
          continue;
        }

        colSet.add(col);
        positiveDiagonal.add(row + col);
        negativeDiagonal.add(row - col);

        backtrack(row + 1, n, colSet, positiveDiagonal, negativeDiagonal, count);

        colSet.remove(col);
        positiveDiagonal.remove(row + col);
        negativeDiagonal.remove(row - col);
      }
    }
  }

  @Test
  void test() {

  }
}
