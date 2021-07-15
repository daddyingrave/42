package com.github.andreyelagin.leetcode.search;

public class FirstBadVersion {

  private final int badVersion;

  FirstBadVersion(int version) {
    badVersion = version;
  }

  boolean isBadVersion(int version) {
    return version >= badVersion;
  }

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    
    while (left < right) {
      int mid = ((right - left) / 2 + left);
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}
