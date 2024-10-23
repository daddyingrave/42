package com.github.daddyingrave.leetcode.binarysearch;

public class FirstBadVersion {
  boolean isBadVersion(int version) {
    if (version >= 4) {
      return true;
    } else {
      return false;
    }
  }

  // call isBadVersion(3) -> false
  // call isBadVersion(5) -> true
  // call isBadVersion(4) -> true
  public int firstBadVersion(int n) {
    int left = 0;
    int right = n;

    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (!isBadVersion(mid)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
