package com.github.andreyelagin.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    var result = new ArrayList<int[]>();

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    var cur = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (cur[1] > intervals[i][0]) {
        cur[1] = Math.max(intervals[i][1], cur[1]);
      } else {
        result.add(cur);
        cur = intervals[i];
      }
    }

    result.add(cur);

    int[][] arrResult = new int[result.size()][];
    for (int i = 0; i < result.size(); i++) {
      arrResult[i] = result.get(i);
    }
    return arrResult;
  }
}
