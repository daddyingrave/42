package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets78Test {
  public List<List<Integer>> subsets(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    backtrack(0, nums, new ArrayList<>(), result);

    return result;
  }

  void backtrack(int index, int[] nums, List<Integer> cur, List<List<Integer>> res) {
    if (index == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }

    var newCur = new ArrayList<>(cur);
    newCur.add(nums[index]);
    backtrack(index + 1, nums, newCur, res);
    backtrack(index + 1, nums, cur, res);
  }

  @Test
  void test() {
    subsets(new int[]{1, 2, 3});
  }
}
