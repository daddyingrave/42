package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubsetsII90Test {
  class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      backtrack(0, nums, new ArrayList<>(), result);

      return result;
    }

    void backtrack(int i, int[]nums, List<Integer> cur, List<List<Integer>> result) {
      if (i == nums.length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      cur.add(nums[i]);
      backtrack(i + 1, nums, cur, result);
      cur.remove(cur.size() - 1);
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        i++;
      }
      backtrack(i + 1, nums, cur, result);
    }
  }

  @Test
  void test() {

  }
}
