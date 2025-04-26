package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumIIInputArrayIsSorted167Test {
  // 9
  // 2,7,11,15
  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    int sum = numbers[left] + numbers[right];
    while (sum != target) {
      if (sum < target) {
        left++;
      } else {
        right--;
      }

      sum = numbers[left] + numbers[right];
    }

    return new int[]{left + 1, right + 1};
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
    assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
    assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
  }
}
