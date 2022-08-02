package com.github.daddyingrave.backtobackswe.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseIntervalOverlaps {
  public int eraseOverlapIntervals(int[][] intervals) {
    var comparator = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    };
    
    Arrays.sort(intervals, comparator);

    int lastEnd = intervals[0][1];
    int removals = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (lastEnd <= intervals[i][0]) {
        removals++;
        lastEnd = intervals[i][1];
      }
    }
    return intervals.length - removals - 1;
  }
}
