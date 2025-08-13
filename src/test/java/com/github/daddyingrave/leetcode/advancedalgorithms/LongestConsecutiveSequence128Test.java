package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LongestConsecutiveSequence128Test {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    var set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }

    int longest = 1;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int curLength = 1;
        while (set.contains(num + curLength)) {
          curLength++;
        }
        longest = Math.max(longest, curLength);
      }
    }

    return longest;
  }

  @Test
  void test() {
    assertEquals(4, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    assertEquals(9, longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
  }
}
