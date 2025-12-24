package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationSumII40Test {
  class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      var result = new ArrayList<List<Integer>>();
      Arrays.sort(candidates);
      backtrack(0, candidates, 0, target, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int i, int[] candidates, int total, int target, List<Integer> cur, List<List<Integer>> result) {
      if (total == target) {
        result.add(new ArrayList<>(cur));
        return;
      }
      if (total > target || i >= candidates.length) {
        return;
      }

      cur.add(candidates[i]);
      backtrack(i + 1, candidates, total + candidates[i], target, cur, result);
      cur.remove(cur.size() - 1);

      while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
        i++;
      }
      backtrack(i + 1, candidates, total, target, cur, result);
    }
  }

  @Test
  void test() {

  }
}
