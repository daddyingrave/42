package com.github.daddyingrave.leetcode.arrays101;

import java.util.Arrays;

public class HeightChecker {
  // 1,1,4,2,1,3
  //     1 1
  public int heightChecker(int[] heights) {
    int[] target = new int[heights.length];

    System.arraycopy(heights, 0, target, 0, heights.length);
    Arrays.sort(target);

    int changes = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != target[i]) {
        changes++;
      }
    }

    return changes;
  }
}
