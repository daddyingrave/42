package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39Test {
  class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      var result = new ArrayList<List<Integer>>();
      backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
      return result;
    }

    void backtrack(
        int[] candidates,
        int target,
        int i,
        int curSum,
        List<Integer> cur,
        List<List<Integer>> result
    ) {
      if (i >= candidates.length || curSum > target) {
        return;
      }
      if (curSum == target) {
        result.add(new ArrayList<>(cur));
        return;
      }

      cur.add(candidates[i]);
      backtrack(candidates, target, i, curSum + candidates[i], cur, result);
      cur.remove(cur.size() - 1);

      backtrack(candidates, target, i + 1, curSum, cur, result);
    }
  }

  @Test
  void test() {
    var res = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
    System.out.println(res);
  }
}
