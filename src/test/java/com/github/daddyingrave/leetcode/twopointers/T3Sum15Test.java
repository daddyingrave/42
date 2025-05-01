package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class T3Sum15Test {
  // -4, –1, –1, 0, 1, 2
  public List<List<Integer>> threeSum(int[] nums) {
    var result = new ArrayList<List<Integer>>();

    Arrays.sort(nums);

    int current = 0;
    while (current < nums.length) {
      int left = current + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[current] + nums[left] > 0) {
          break;
        }

        int sum = nums[current] + nums[left] + nums[right];
        if (sum > 0) {
          do {
            right--;
          } while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]);
        } else if (sum < 0) {
          do {
            left++;
          } while (left < right && nums[left] == nums[left - 1]);
        } else {
          result.add(List.of(nums[current], nums[left], nums[right]));
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        }
      }

      do {
        current++;
      } while (current < nums.length && nums[current] == nums[current - 1]);
    }

    return result;
  }

  @Test
  void test() {
    var lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    assertFalse(lists.isEmpty());
  }

  @Test
  void test2() {
    var lists = threeSum(new int[]{1, -1, -1, 0});
    assertFalse(lists.isEmpty());
  }

  @Test
  void test3() {
    var lists = threeSum(new int[]{-2, 0, 1, 1, 2});
    assertEquals(2, lists.size());
  }

  @Test
  void test4() {
    var lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
    assertEquals(9, lists.size());
  }
}
