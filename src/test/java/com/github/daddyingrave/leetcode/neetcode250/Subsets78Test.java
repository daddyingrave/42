package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Subsets78Test {
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      backtrack(0, nums, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int i, int[] nums, List<Integer> current, List<List<Integer>> result) {
      if (i == nums.length) {
        result.add(new ArrayList<>(current));
        return;
      }

      current.add(nums[i]);
      backtrack(i + 1, nums, current, result);
      current.remove(current.size() - 1);
      backtrack(i + 1, nums, current, result);
    }
  }

  @Test
  void test() {

  }
}
