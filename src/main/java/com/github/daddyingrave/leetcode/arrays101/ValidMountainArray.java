package com.github.daddyingrave.leetcode.arrays101;

public class ValidMountainArray {
  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }

    int stop = 0;

    while (stop + 1 < arr.length && arr[stop + 1] > arr[stop]) {
      stop++;
    }

    if (stop == 0 || stop == arr.length - 1) {
      return false;
    }

    while (stop + 1 < arr.length && arr[stop + 1] < arr[stop]) {
      stop++;
    }


    return stop == arr.length - 1;
  }
}
