package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

public class FindinMountainArray1095Test {
  interface MountainArray {
    int get(int index);

    int length();
  }

  class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
      int length = mountainArr.length();

      int left = 1;
      int right = length - 2;
      int peak = 1;

      // 1 5 2
      while (left <= right) {
        int mid = (left + right) / 2;
        int lM = mountainArr.get(mid - 1);
        int midM = mountainArr.get(mid);
        int rM = mountainArr.get(mid + 1);

        if (lM < midM && midM < rM) {
          left = mid + 1;
        } else if (lM > midM && midM > rM) {
          right = mid - 1;
        } else {
          peak = mid;
          break;
        }
      }

      int peakIndex = bs(target, mountainArr, 0, peak, false);
      if (peakIndex == -1) {
        return bs(target, mountainArr, peak, length - 1, true);
      } else {
        return peakIndex;
      }
    }

    int bs(int target, MountainArray arr, int left, int right, boolean reverse) {
      while (left <= right) {
        int mid = (left + right) / 2;
        int candidate = arr.get(mid);
        int compare = Integer.compare(target, candidate);
        if (reverse) {
          compare = -compare;
        }

        if (compare == 0) {
          return mid;
        } else if (compare < 0) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return -1;
    }
  }

  @Test
  void test() {

  }
}
