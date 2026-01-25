package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FindtheTownJudge997Test {
  class Solution {
    public int findJudge(int n, int[][] trust) {
      var in = new int[n + 1];
      int[] out = new int[n + 1];

      for (int[] rel : trust) {
        out[rel[0]]++;
        in[rel[1]]++;
      }

      for (int i = 1; i < in.length; i++) {
        if (in[i] == n - 1 && out[i] == 0) {
          return i;
        }
      }

      return -1;
    }
  }

  @Test
  void test() {
    assertEquals(1, new Solution().findJudge(1, new int[][]{}));
    assertEquals(2, new Solution().findJudge(2, new int[][]{{1, 2}}));
    assertEquals(3, new Solution().findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
  }
}
