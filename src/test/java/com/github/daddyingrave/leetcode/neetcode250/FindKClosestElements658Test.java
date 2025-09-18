package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindKClosestElements658Test {
  class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int left = 0;
      int right = arr.length - 1;
      while (left < right) {
        int mid = (left + right) / 2;
        if (arr[mid] < x) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }


      left = left - 1;
      right = left + 1;
      while (right - left - 1 < k) {
        if (left < 0) {
          right++;
        } else if (right >= arr.length) {
          left--;
        } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
          left--;
        } else {
          right++;
        }
      }

      var result = new ArrayList<Integer>();
      for (int i = left + 1; i < right; i++) {
        result.add(arr[i]);
      }

      return result;
    }
  }

  @Test
  void test() {
    assertEquals(List.of(1, 2, 3, 4), new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    assertEquals(List.of(1, 1, 2, 3), new Solution().findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
    assertEquals(List.of(3, 3, 4), new Solution().findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
  }
}
