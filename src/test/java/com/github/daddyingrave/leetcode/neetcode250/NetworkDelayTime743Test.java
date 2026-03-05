package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class NetworkDelayTime743Test {
  class Solution {
    record Path(int to, int time) {
    }

    public int networkDelayTime(int[][] times, int n, int k) {
      var adj = new ArrayList<List<Path>>();
      adj.add(new ArrayList<>());
      for (int i = 1; i <= n; i++) {
        adj.add(new ArrayList<>());
      }
      for (int[] time : times) {
        adj.get(time[0]).add(new Path(time[1], time[2]));
      }

      var queue = new PriorityQueue<>(Comparator.comparingInt(Path::time));
      var visited = new HashSet<Integer>();
      queue.offer(new Path(k, 0));

      int t = 0;
      while (!queue.isEmpty()) {
        var cur = queue.poll();
        if (visited.contains(cur.to)) {
          continue;
        }

        visited.add(cur.to);
        t = cur.time;

        for (Path next : adj.get(cur.to)) {
          if (!visited.contains(next.to)) {
            queue.offer(new Path(next.to, cur.time + next.time));
          }
        }
      }

      return visited.size() == n ? t : -1;
    }
  }

  @Test
  void test() {

  }
}
