package com.github.daddyingrave.leetcode.arrays;

import java.util.*;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return List.of();
    }
    
    var tempResult = new HashSet<List<Integer>>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum == 0) { 
          tempResult.add(List.of(nums[i], nums[l], nums[r]));
          l++;
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }
      }
    }

    return new ArrayList<>(tempResult);
  }
}
