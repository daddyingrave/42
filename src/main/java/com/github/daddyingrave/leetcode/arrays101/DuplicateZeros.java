package com.github.daddyingrave.leetcode.arrays101;

public class DuplicateZeros {
  public void duplicateZeros(int[] arr) {
    int possibleDups = 0;
    int length = arr.length - 1;

    // Find the number of zeros to be duplicated
    for (int left = 0; left <= length - possibleDups; left++) {
      if (arr[left] == 0) {
        // Edge case: This zero can't be duplicated
        if (left == length - possibleDups) {
          arr[length] = 0;
          length--;
          break;
        }
        possibleDups++;
      }
    }

    // Start from the last element
    int last = length - possibleDups;

    // Copy zero twice, and non zero once
    for (int i = last; i >= 0; i--) {
      if (arr[i] == 0) {
        arr[i + possibleDups] = 0;
        possibleDups--;
        arr[i + possibleDups] = 0;
      } else {
        arr[i + possibleDups] = arr[i];
      }
    }
  }

  public void duplicateZeros2(int[] arr) {
    int[] tmp = new int[arr.length];

    int index = 0;
    int cur = 0;

    while (index < arr.length) {
      if (arr[cur] == 0) {
        tmp[index] = 0;
        index++;

        if (index < arr.length) {
          tmp[index] = 0;
          index++;
        }
      } else {
        tmp[index] = arr[cur];
        index++;
      }

      cur++;
    }

    System.arraycopy(tmp, 0, arr, 0, tmp.length);
  }
}
