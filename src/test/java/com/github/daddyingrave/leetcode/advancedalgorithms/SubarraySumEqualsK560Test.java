package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SubarraySumEqualsK560Test {
  public int subarraySum(int[] nums, int k) {
    var map = new HashMap<Integer, Integer>();
    map.put(0, 1);
    int result = 0;
    int sum = 0;

    for (int num : nums) {
      sum += num;
      Integer sumCount = map.get(sum - k);
      if (sumCount != null) {
        result += sumCount;
      }

      map.merge(sum, 1, Integer::sum);
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
    assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
  }
}
