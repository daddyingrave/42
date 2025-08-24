package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII47Test {
  class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      var map = new HashMap<Integer, Integer>();
      for (int num : nums) {
        map.merge(num, 1, Integer::sum);
      }

      var result = new ArrayList<List<Integer>>();
      backtrack(map, nums.length, new ArrayList<>(), result);

      return result;
    }

    void backtrack(
        Map<Integer, Integer> nums,
        int length,
        List<Integer> cur,
        List<List<Integer>> result
    ) {
      if (cur.size() == length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      for (var num : nums.keySet()) {
        if (nums.get(num) > 0) {
          cur.add(num);
          nums.put(num, nums.get(num) - 1);

          backtrack(nums, length, cur, result);

          nums.put(num, nums.get(num) + 1);
          cur.remove(cur.size() - 1);
        }
      }
    }
  }

  @Test
  void test() {
    new Solution().permuteUnique(new int[]{1, 1, 2});
  }
}
