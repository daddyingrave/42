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

    PriorityQueue<TaskCounter> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < subCount.length; i++) {
      if (subCount[i] > 0) {
        queue.add(new TaskCounter((char) ('A' + i), subCount[i]));
      }
    }

    Deque<Character> idle = new LinkedList<>();
    var iterator = queue.iterator();

    while (iterator.hasNext()) {
      var cur = iterator.next();
      count++;
      if (idle.isEmpty()) {
        for (int i = 0; i < n; i++) {
          idle.addLast(cur.task);
        }
        cur.dec();
      } else if (cur.task != idle.getFirst()) {
        idle.removeFirst();
        cur.dec();
      } else {
        while (idle.size() > 0 && idle.getFirst() == cur.task) {
          count++;
          idle.removeFirst();
        }
        continue;
      }

      if (cur.count <= 0) {
        iterator.remove();
      }

      if (idle.isEmpty()) {
        iterator = queue.iterator();
      }

      if (!iterator.hasNext()) {
        iterator = queue.iterator();
      }
    }

    return count;
  }

  private static class TaskCounter implements Comparable<TaskCounter> {
    public char task;
    public int count;

    public TaskCounter(char task, int count) {
      this.task = task;
      this.count = count;
    }

    public void dec() {
      this.count--;
    }

    @Override
    public int compareTo(TaskCounter o) {
      return this.count - o.count;
    }
  }
}
