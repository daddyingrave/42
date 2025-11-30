package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class TaskScheduler621Test {
  class Solution {
    public int leastInterval(char[] tasks, int n) {
      int[] counts = new int[26];
      for (char task : tasks) {
        counts[task - 'A']++;
      }

      var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
      for (int count : counts) {
        if (count > 0) {
          heap.offer(count);
        }
      }

      var queue = new LinkedList<int[]>();
      int time = 0;
      while (!heap.isEmpty() || !queue.isEmpty()) {
        time++;

        if (heap.isEmpty()) {
          time = queue.peek()[1];
        } else {
          var cur = heap.poll();
          if (cur > 1) {
            queue.offer(new int[]{cur - 1, time + n});
          }
        }

        if (!queue.isEmpty() && queue.peek()[1] == time) {
          heap.offer(queue.poll()[0]);
        }
      }

      return time;
    }
  }

  @Test
  void test() {

  }
}
