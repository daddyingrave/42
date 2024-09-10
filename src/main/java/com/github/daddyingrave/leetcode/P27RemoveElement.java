package com.github.daddyingrave.leetcode;

public class P27RemoveElement {
  // Optimal
  // public int removeElement(int[] nums, int val) {
  //        int index = 0;
  //        for (int i = 0; i < nums.length; i++) {
  //            if (nums[i] != val) {
  //                nums[index] = nums[i];
  //                index++;
  //            }
  //        }
  //        return index;
  //    }

  public int removeElement(int[] nums, int val) {
    int currentIndex = 0;
    int latestIndex = nums.length - 1;

    while (currentIndex < latestIndex) {
      if (nums[currentIndex] == val) {
        swap(nums, currentIndex, latestIndex);

        latestIndex--;
        if (nums[currentIndex] != val) {
          currentIndex++;
        }
      } else {
        currentIndex++;
      }
    }


    return currentIndex;
  }

  private void swap(int[] arr, int left, int right) {
    var tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }
}
