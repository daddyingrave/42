package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KthLargestElementinanArray215Test {
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    int quickSelect(int[] nums, int left, int right, int k) {
      int pivot = nums[right];
      int p = left;

      for (int i = left; i < right; i++) {
        if (nums[i] <= pivot) {
          int temp = nums[i];
          nums[i] = nums[p];
          nums[p] = temp;
          p++;
        }
      }

      int temp = nums[p];
      nums[p] = nums[right];
      nums[right] = temp;

      if (p > k) {
        return quickSelect(nums, left, p - 1, k);
      } else if (k > p) {
        return quickSelect(nums, p + 1, right, k);
      } else {
        return nums[p];
      }
    }
  }

  public class Solution2 {
    private int partition(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        swap(nums, mid, left + 1);

        if (nums[left] < nums[right])
            swap(nums, left, right);
        if (nums[left + 1] < nums[right])
            swap(nums, left + 1, right);
        if (nums[left] < nums[left + 1])
            swap(nums, left, left + 1);

        int pivot = nums[left + 1];
        int i = left + 1;
        int j = right;

        while (true) {
            while (nums[++i] > pivot);
            while (nums[--j] < pivot);
            if (i > j) break;
            swap(nums, i, j);
        }

        nums[left + 1] = nums[j];
        nums[j] = pivot;
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            if (right <= left + 1) {
                if (right == left + 1 && nums[right] > nums[left])
                    swap(nums, left, right);
                return nums[k];
            }

            int j = partition(nums, left, right);

            if (j >= k) right = j - 1;
            if (j <= k) left = j + 1;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1);
    }
}

  @Test
  void test() {

  }
}
