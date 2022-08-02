package com.github.daddyingrave.backtobackswe.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalSchedulingMaximization {
  public List<int[]> constructOptimalSchedule(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

    var result = new ArrayList<int[]>();
    result.add(intervals[0]);

    int previousEnd = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      if (start >= previousEnd) {
        result.add(intervals[i]);
        previousEnd = end;
      }
    }

    return result;
  }
}
