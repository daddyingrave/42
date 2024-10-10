package com.github.daddyingrave.leetcode.arrays101;

public class ReplaceElementsWithGreatestElementOnRightSide {
  public int[] replaceElements(int[] arr) {
    int[] maximums = new int[arr.length + 1];
    maximums[maximums.length - 1] = - 1;

    int max = Integer.MIN_VALUE;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] > max) {
        max = arr[i];
      }

      maximums[i] = max;
    }

    System.arraycopy(maximums, 1, arr, 0, arr.length);

    return arr;
  }
}
