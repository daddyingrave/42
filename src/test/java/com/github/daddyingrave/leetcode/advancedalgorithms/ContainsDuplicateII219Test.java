package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsDuplicateII219Test {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    var set = new HashSet<Integer>();
    int left = 0;
    int right = 0;

    while (right < nums.length) {
      if (right - left > k) {
        set.remove(nums[left]);
        left++;
      }
      if (set.contains(nums[right])) {
        return true;
      }

      set.add(nums[right]);

      right++;
    }


    return false;
  }

  @Test
  void test() {
    assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
  }
}
