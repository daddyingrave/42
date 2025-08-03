package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumIIInputArrayIsSorted167Test {
  // 2, 7, 11, 15
  // L
  //           R
  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      if (numbers[left] + numbers[right] > target) {
        right--;
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        result[0] = left + 1;
        result[1] = right + 1;
        break;
      }
    }

    return result;
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
    assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
    assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
  }
}
