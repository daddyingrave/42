package com.github.daddyingrave.leetcode.arrays101;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }

    var result = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }


    return result;
  }

  // [-4,-1,0,3,10]
  public int[] sortedSquares(int[] nums) {
    int[] target = new int[nums.length];

    int mid = 0;
    for (int i = 0; i < nums.length; i++) {
      mid = i;
      if (nums[i] >= 0) {
        break;
      }
    }

    int left = mid;
    int right = mid + 1;

    int index = 0;
    while (left >= 0 && right < nums.length) {
      if (Math.abs(nums[left]) < nums[right]) {
        target[index] = (int) Math.pow(nums[left], 2);
        left--;
      } else {
        target[index] = (int) Math.pow(nums[right], 2);
        right++;
      }

      index++;
    }

    while (left >= 0) {
      target[index++] = (int) Math.pow(nums[left--], 2);
    }
    while (right < nums.length) {
      target[index++] = (int) Math.pow(nums[right++], 2);
    }

    return target;
  }
}
