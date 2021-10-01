package com.github.andreyelagin.leetcode.design;

import java.util.*;

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    if (n == 0) {
      return tasks.length;
    }

    int count = 0;
    int[] subCount = new int[26];
    for (char task : tasks) {
      subCount[task - 'A']++;
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[1] != r[1] ? r[1] - l[1] : l[0] - r[0]);
    for (int i = 0; i < subCount.length; i++) {
      if (subCount[i] > 0) {
        queue.add(new int[]{'A' + i, subCount[i]});
      }
    }

    while (!queue.isEmpty()) {
      int guard = n + 1;

      var temp = new ArrayList<int[]>();
      while (guard > 0 && !queue.isEmpty()) {
        var cur = queue.poll();
        cur[1]--;
        temp.add(cur);
        count++;
        guard--;
      }

      for (int[] ints : temp) {
        if (ints[1] > 0) {
          queue.offer(ints);
        }
      }
      if (queue.isEmpty()) {
        break;
      }

      count += guard;
    }

    return count;
  }
}
