package com.github.daddyingrave.leetcode;

public class P26RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return 1;
    }

    int uniqueCount = 1;
    int lastUniqueIndex = 0;
    int lastUniqueNumber = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != lastUniqueNumber) {
        uniqueCount++;
        nums[++lastUniqueIndex] = nums[i];
        lastUniqueNumber = nums[i];
      }
    }


    return uniqueCount;
  }

//  public int removeDuplicates(int[] nums) {
//    int count = 1;
//
//    for (int i = 1; i < nums.length; i++) {
//      if (nums[i - 1] != nums[i]) {
//        nums[count] = nums[i];
//        count++;
//      }
//    }
//
//    return count;
//  }
}
