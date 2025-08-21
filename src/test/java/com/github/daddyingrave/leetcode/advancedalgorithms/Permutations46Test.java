package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Permutations46Test {
  class Solution {
    public List<List<Integer>> permute(int[] nums) {
      var permutations = new
    }
  }

  class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
      return backtrack(nums, 0);
    }

    List<List<Integer>> backtrack(int[] nums, int i) {
      if (i == nums.length) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());
        return permutations;
      }

      var permutations = backtrack(nums, i + 1);
      ArrayList<List<Integer>> newPermutations = new ArrayList<>();
      for (var permutation : permutations) {
        for (int j = 0; j < permutation.size() + 1; j++) {
          var permutationCopy = new ArrayList<>(permutation);
          permutationCopy.add(j, nums[i]);
          newPermutations.add(permutationCopy);
        }
      }

      return newPermutations;
    }
  }

  @Test
  void test() {
    var res = new Solution().permute(new int[]{1, 2, 3});
    System.out.println(res);
  }
}
