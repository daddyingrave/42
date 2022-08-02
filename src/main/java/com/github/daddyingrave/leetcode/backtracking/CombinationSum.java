package com.github.daddyingrave.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    var result = new ArrayList<List<Integer>>();

    backtrack(target, 0, candidates, new LinkedList<>(), result);

    return result;
  }

  private void backtrack(
      int left,
      int start,
      int[] nums,
      LinkedList<Integer> buf,
      List<List<Integer>> res) {
    if (left == 0) {
      res.add(new ArrayList<>(buf));
    } else if (left < 0) {
      return;
    }

    for (int i = start; i < nums.length; i++) {
      buf.add(nums[i]);
      backtrack(left - nums[i], i, nums, buf, res);
      buf.removeLast();
    }
  }
}
