package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PermutationsII47Test {
  class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      backtrack(new boolean[nums.length], nums, new ArrayList<>(), result);

      return result;
    }

    void backtrack(boolean[] visited, int[] nums, List<Integer> cur, List<List<Integer>> result) {
      if (cur.size() == nums.length) {
        result.add(new ArrayList<>(cur));
        return;
      }

      for (int i = 0; i < nums.length; i++) {
        if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
          continue;
        }

        cur.add(nums[i]);
        visited[i] = true;
        backtrack(visited, nums, cur, result);
        visited[i] = false;
        cur.remove(cur.size() - 1);
      }
    }
  }

  @Test
  void test() {

  }
}
