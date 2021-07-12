package com.github.andreyelagin.leetcode.arrays;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int ptr = 1;
    int uniquePtr = 1;
    while (ptr < nums.length) {
      if (nums[ptr] != nums[uniquePtr - 1]) {
        nums[uniquePtr++] = nums[ptr];
      }
      ptr++;
    }
    
    return uniquePtr;
  }
}
