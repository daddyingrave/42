package com.github.andreyelagin.backtobackswe.primitives;

public class Sort012 {
  public static int[] sortArray_0_1_2(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int i = 0;

    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, left++, i++);
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, i, right--);
      }
    }

    return nums;
  }

  private static void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
