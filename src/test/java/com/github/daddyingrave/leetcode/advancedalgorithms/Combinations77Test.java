package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Combinations77Test {
  class Solution {
    public List<List<Integer>> combine(int n, int k) {
      var result = new ArrayList<List<Integer>>();
      backtrack(n, k, 1, new ArrayList<>(), result);
      return result;
    }

    // n = 4, k = 2
    // i = 1
    // cur = [0]
    // result = [ [0, 1] ]
    void backtrack(int n, int k, int i, List<Integer> cur, List<List<Integer>> result) {
      if (cur.size() == k) {
        result.add(new ArrayList<>(cur));
        return;
      }
      if (i > n) {
        return;
      }

      for (int j = i; j <= n; j++) {
        cur.add(j);
        backtrack(n, k, j + 1, cur, result);
        cur.remove(cur.size() -1);
      }
    }
  }

  @Test
  void test() {
    var res = new Solution().combine(4, 2);
    System.out.println(res);
  }
}
