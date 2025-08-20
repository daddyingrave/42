package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90Test {
  class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      backtrack(nums, 0, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> result) {
      if (i == nums.length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      cur.add(nums[i]);
      backtrack(nums, i + 1, cur, result);
      cur.remove(cur.size() - 1);

      while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
        i++;
      }
      backtrack(nums, i + 1, cur, result);
    }
  }

  @Test
  void test() {
    new Solution().subsetsWithDup(new int[]{1, 2, 2});
  }
}
