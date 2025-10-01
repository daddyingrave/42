package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class KokoEatingBananas875Test {
  class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int left = 1;
      int right = piles[piles.length - 1];
      int min = Integer.MAX_VALUE;

      while (left <= right) {
        int mid = (left + right) / 2;
        int from = highestIndex(piles, mid);
        int curCount = from;
        for (int i = from; i < piles.length; i++) {
          curCount += (int) Math.ceil(piles[i] / (double) mid);
          if (curCount > h) {
            break;
          }
        }

        if (curCount <= h) {
          min = Math.min(min, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return min;
    }

    int highestIndex(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
          return mid;
        } else if (target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return left;
    }
  }

  @Test
  void test() {
    assertEquals(4, new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    assertEquals(30, new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    assertEquals(23, new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
  }
}
