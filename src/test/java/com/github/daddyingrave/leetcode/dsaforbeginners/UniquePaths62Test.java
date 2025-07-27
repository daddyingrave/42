package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UniquePaths62Test {
  public int uniquePaths(int m, int n) {
    int[] curRow = new int[n];
    Arrays.fill(curRow, 1);

    for (int i = m - 2; i >= 0; i--) {
      for (int j = curRow.length - 2; j >= 0; j--) {
        curRow[j] = curRow[j] + curRow[j + 1];
      }
    }

    return curRow[0];
  }

  @Test
  void test() {
    assertEquals(28, uniquePaths(3, 7));
    assertEquals(3, uniquePaths(3, 2));
    assertEquals(1, uniquePaths(1, 2));
  }
}
