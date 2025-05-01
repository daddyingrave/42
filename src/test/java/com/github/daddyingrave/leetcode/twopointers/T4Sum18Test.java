package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class T4Sum18Test {
  // -4, –1, –1, 0, 1, 2
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);

    var result = new ArrayList<List<Integer>>();
    var quad = new ArrayList<Integer>();
    kSum(nums, 4, 0, target, result, quad);

    return result;
  }

  void kSum(int[] nums, int k, int start, long target, List<List<Integer>> res, List<Integer> quad) {
    if (k == 2) {
      int left = start;
      int right = nums.length - 1;
      while (left < right) {
        long sum = nums[left] + nums[right];

        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          var updatedQuad = new ArrayList<>(quad);
          updatedQuad.add(nums[left]);
          updatedQuad.add(nums[right]);
          res.add(updatedQuad);

          left++;
          right--;

          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        }
      }
    } else {
      for (int i = start; i < nums.length - k + 1; i++) {
        if (i > start && nums[i] == nums[i - 1]) {
          continue;
        }

        quad.add(nums[i]);
        kSum(nums, k - 1, i + 1, target - nums[i], res, quad);
        quad.remove(quad.size() - 1);
      }
    }
  }

  @Test
  void test() {
    var lists = fourSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);
    assertFalse(lists.isEmpty());
  }

  @Test
  void test2() {
    var lists = fourSum(new int[]{1, -1, -1, 0}, 0);
    assertFalse(lists.isEmpty());
  }

  @Test
  void test3() {
    var lists = fourSum(new int[]{-2, 0, 1, 1, 2}, 0);
    assertEquals(2, lists.size());
  }

  @Test
  void test4() {
    var lists = fourSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}, 0);
    assertEquals(9, lists.size());
  }
}
