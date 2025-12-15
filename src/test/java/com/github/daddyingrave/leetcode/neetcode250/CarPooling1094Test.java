package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class CarPooling1094Test {
  class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
      Arrays.sort(trips, Comparator.comparingInt((int[] o) -> o[1]));

      var heap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[2]));
      var curCapacity = 0;
      for (int[] trip : trips) {
        curCapacity += trip[0];
        while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) {
          int[] earliestTrip = heap.poll();
          curCapacity -= earliestTrip[0];
        }
        if (curCapacity > capacity) {
          return false;
        }

        heap.offer(trip);
      }

      return true;
    }
  }

  @Test
  void test() {
    assertTrue(new Solution().carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
  }
}
