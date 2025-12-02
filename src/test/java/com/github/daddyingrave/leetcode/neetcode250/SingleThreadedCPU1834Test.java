package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class SingleThreadedCPU1834Test {
  class Solution {
    public int[] getOrder(int[][] tasks) {
      for (int i = 0; i < tasks.length; i++) {
        tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
      }

      int[] result = new int[tasks.length];

      Arrays.sort(tasks, Comparator.comparingInt(v -> v[0]));
      var heap = new PriorityQueue<int[]>(
          (l, r) -> l[0] == r[0] ? Integer.compare(l[1], r[1]) : Integer.compare(l[0], r[0])
      );

      int i = 0;
      int idx = 0;
      int time = tasks[0][0];

      while (!heap.isEmpty() || i < tasks.length) {
        while (i < tasks.length && time >= tasks[i][0]) {
          heap.offer(new int[]{tasks[i][1], tasks[i][2]});
          i++;
        }
        if (heap.isEmpty()) {
          time = tasks[i][0];
        } else {
          int[] task = heap.poll();
          time += task[0];
          result[idx++] = task[1];
        }
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
