package com.github.andreyelagin.leetcode.design;

import java.util.*;

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
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
    
    while (!queue.isEmpty()) {
      var cur = iterator.next();
      if (idle.isEmpty()) {
        for (int i = 0; i < n; i++) {
          idle.addLast(cur.task);
        }
      } else if (cur.task != idle.getFirst()) {
        idle.removeFirst();
        if (idle.isEmpty()) {
          iterator = queue.iterator();
        }
      } else {
        idle.removeFirst();
      }
      
      cur.dec();
      if (cur.count <= 0) {
        iterator.remove();
      }
      count++;
      
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
