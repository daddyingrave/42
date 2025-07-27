package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HouseRobber198Test {

  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = new int[nums.length];

    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }

    return dp[dp.length - 1];
  }

  @Test
  void test() {
    assertEquals(4, rob(new int[]{1, 2, 3, 1}));
    assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
  }
}
