package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39Test {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    var result = new ArrayList<List<Integer>>();
    Arrays.sort(candidates);
    backtrack(candidates, 0, 0, target, new ArrayList<>(), result);

    return result;
  }

  void backtrack(int[] candidates,
                 int i,
                 int curSum,
                 int target,
                 List<Integer> curCombination,
                 List<List<Integer>> result
  ) {
    if (i >= candidates.length) {
      return;
    }

    if (curSum == target) {
      result.add(new ArrayList<>(curCombination));
      return;
    }

    if (curSum > target) {
      return;
    }

    if (candidates[i] <= target) {
      curCombination.add(candidates[i]);
      backtrack(candidates, i, curSum + candidates[i], target, curCombination, result);
      curCombination.remove(curCombination.size() - 1);
    }

    backtrack(candidates, i + 1, curSum, target, curCombination, result);
  }


  @Test
  void test() {
    combinationSum(new int[]{2, 3, 5}, 8);
    combinationSum(new int[]{2, 3, 5}, 8);
  }
}
