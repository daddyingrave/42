package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class KthLargestElementInAnArray215Test {
  Random rand = new Random();

  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 1) {
      return nums[0];
    }

    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  int quickSelect(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }

    int pivot = left + rand.nextInt(right - left);
    int selectedIndex = partition(nums, left, right, pivot);

    if (selectedIndex == k) {
      return nums[selectedIndex];
    } else if (k < selectedIndex) {
      return quickSelect(nums, left, selectedIndex - 1, k);
    } else {
      return quickSelect(nums, selectedIndex + 1, right, k);
    }
  }

  int partition(int[] nums, int left, int right, int pivotIndex) {
    int pivotValue = nums[pivotIndex];
    swap(nums, pivotIndex, right);
    int cur = left;

    for (int i = left; i <= right; i++) {
      if (nums[i] < pivotValue) {
        swap(nums, cur, i);
        cur++;
      }
    }

    swap(nums, cur, right);

    return cur;
  }

  private void swap(int[] nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }

  @Test
  void test() {
    assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    assertEquals(2, findKthLargest(new int[]{2, 1}, 1));
    assertEquals(3, findKthLargest(new int[]{3, 1, 2, 4}, 2));
  }
}
