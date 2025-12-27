package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Permutations46Test {
  class Solution {
    public List<List<Integer>> permute(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      backtrack(new boolean[nums.length], nums, new ArrayList<>(), result);
      return result;
    }

    void backtrack(boolean[] picks, int[] nums, List<Integer> cur, List<List<Integer>> result) {
      if (cur.size() == nums.length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      for (int i = 0; i < nums.length; i++) {
        if (!picks[i]) {
          cur.add(nums[i]);
          picks[i] = true;
          backtrack(picks, nums, cur, result);
          cur.remove(cur.size() - 1);
          picks[i] = false;
        }
      }
    }
  }

  @Test
  void test() {

  }
}
