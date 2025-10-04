package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CapacityToShipPackagesWithinDDays1011Test {
  class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int left = 1;
      int right = 0;
      for (int weight : weights) {
        left = Math.max(left, weight);
        right += weight;
      }

      int minimalWeight = right;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (willBeShipped(weights, mid, days)) {
          minimalWeight = Math.min(minimalWeight, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return minimalWeight;
    }

    boolean willBeShipped(int[] weights, int shipWeight, int days) {
      int ships = 1;
      int curWeight = shipWeight;
      for (int weight : weights) {
        if (curWeight - weight < 0) {
          ships++;
          if (ships > days) {
            return false;
          }
          curWeight = shipWeight;
        }
        curWeight -= weight;
      }

      return true;
    }
  }

  @Test
  void test() {
    assertEquals(15, new Solution().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    assertEquals(3, new Solution().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
  }
}
