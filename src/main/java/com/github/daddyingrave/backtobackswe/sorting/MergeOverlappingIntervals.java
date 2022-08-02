package com.github.daddyingrave.backtobackswe.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
  public int[][] mergeOverlappingIntervals(int[][] array) {
    var intervals = new ArrayList<int[]>();

    Arrays.sort(array, Comparator.comparing(ints -> ints[0]));

    int i = 1;
    int[] currentInterval = array[0];

    while (i < array.length) {
      int start = array[i][0];
      int end = array[i][1];
      
      if (start <= currentInterval[1]) {
        currentInterval[1] = Math.max(end, currentInterval[1]);
      } else {
        intervals.add(currentInterval);
        currentInterval = array[i];
      }
      i++;
    }
    
    intervals.add(currentInterval);

    var result = new int[intervals.size()][];
    for (int j = 0; j < intervals.size(); j++) {
      result[j] = intervals.get(j);
    }
    
    return result;
  }
}
