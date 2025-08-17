package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendarI729Test {
  class MyCalendar {
    TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(l -> l[0]));

    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
      int[] event = new int[]{startTime, endTime};
      var prev = set.floor(event);
      var next = set.ceiling(event);

      if ((prev != null && prev[1] > startTime) || (next != null && next[0] < endTime)) {
        return false;
      }

      set.add(event);

      return true;
    }
  }

  @Test
  void test() {

  }
}
