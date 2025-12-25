package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Combinations77Test {
  class Solution {
    public List<List<Integer>> combine(int n, int k) {
      var result = new ArrayList<List<Integer>>();
      backtrack(1, n, k, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int i, int n, int k, List<Integer> cur, List<List<Integer>> result) {
      if (cur.size() == k) {
        result.add(new ArrayList<>(cur));
        return;
      }

      for (int j = i; j <= n; j++) {
        cur.add(j);
        backtrack(j + 1, n, k, cur, result);
        cur.remove(cur.size() - 1);
      }
    }
  }

  @Test
  void test() {

  }
}
