package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets78Test {
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      backtrack(nums, 0, new ArrayList<>(), result);

      return result;
    }

    // 1 2 3
    //
    // i = 0
    // cur = [1, 2, 3]
    // res = [[1, 2, 3], [1, 2]]
    void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> result) {
      if (i == nums.length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      cur.add(nums[i]);
      backtrack(nums, i + 1, cur, result);
      cur.remove(cur.size() - 1);

      backtrack(nums, i + 1, cur, result);
    }
  }

  @Test
  void test() {
    new Solution().subsets(new int[]{1, 2, 3});
  }
}
