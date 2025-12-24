package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationSum39Test {
  class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      var result = new ArrayList<List<Integer>>();
      backtrack(0, target, candidates, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int i, int target, int[] candidates, List<Integer> cur, List<List<Integer>> result) {
      if (target == 0) {
        result.add(new ArrayList<>(cur));
        return;
      }
      if (target < 0 || i >= candidates.length) {
        return;
      }

      cur.add(candidates[i]);
      backtrack(i, target - candidates[i], candidates, cur, result);
      cur.remove(cur.size() - 1);
      backtrack(i + 1, target, candidates, cur, result);
    }
  }

  @Test
  void test() {

  }
}
