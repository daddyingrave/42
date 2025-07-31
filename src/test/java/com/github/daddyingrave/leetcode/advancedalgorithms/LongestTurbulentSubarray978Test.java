package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestTurbulentSubarray978Test {
  public int maxTurbulenceSize(int[] arr) {
    int max = 1;
    int left = 0;
    int right = 1;
    String prev = "";

    while (right < arr.length) {
      if (arr[right] < arr[right - 1] && !"<".equals(prev)) {
        max = Math.max(right - left + 1, max);
        right++;
        prev = "<";
      } else if (arr[right] > arr[right - 1] && !">".equals(prev)) {
        max = Math.max(right - left + 1, max);
        right++;
        prev = ">";
      } else {
        right = arr[right] == arr[right - 1] ? right + 1 : right;
        prev = "";
        left = right - 1;
      }
    }

    return max;
  }

  @Test
  void test() {
    assertEquals(5, maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    assertEquals(2, maxTurbulenceSize(new int[]{4, 8, 12, 16}));
    assertEquals(1, maxTurbulenceSize(new int[]{100}));
    assertEquals(1, maxTurbulenceSize(new int[]{100, 100, 100}));
    assertEquals(2, maxTurbulenceSize(new int[]{4, 5}));
  }
}
