package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OpentheLock752Test {
  class Solution {
    public int openLock(String[] deadends, String target) {
      var deads = new HashSet<List<Integer>>();
      for (String deadend : deadends) {
        deads.add(List.of(
            deadend.charAt(0) - '0',
            deadend.charAt(1) - '0',
            deadend.charAt(2) - '0',
            deadend.charAt(3) - '0'
        ));
      }
      if (deads.contains(List.of(0, 0, 0, 0))) {
        return -1;
      }
      var t = List.of(
          target.charAt(0) - '0',
          target.charAt(1) - '0',
          target.charAt(2) - '0',
          target.charAt(3) - '0'
      );

      var queue = new LinkedList<List<Integer>>();
      var visited = new HashSet<List<Integer>>();
      queue.add(List.of(0, 0, 0, 0));
      visited.add(List.of(0, 0, 0, 0));
      int turns = 0;

      while (!queue.isEmpty()) {
        int curItems = queue.size();
        while (curItems > 0) {
          var cur = queue.poll();
          if (cur.equals(t)) {
            return turns;
          }

          for (int i = 0; i < 4; i++) {
            var nextCur = new ArrayList<>(cur);
            nextCur.set(i, (nextCur.get(i) + 1) % 10);
            if (!deads.contains(nextCur) && !visited.contains(nextCur)) {
              visited.add(nextCur);
              queue.offer(nextCur);
            }

            nextCur = new ArrayList<>(cur);
            nextCur.set(i, (nextCur.get(i) + 10 - 1) % 10);
            if (!deads.contains(nextCur) && !visited.contains(nextCur)) {
              visited.add(nextCur);
              queue.offer(nextCur);
            }
          }

          curItems--;
        }

        turns++;
      }

      return -1;
    }
  }

  @Test
  void test() {
    assertEquals(20, new Solution().openLock(new String[]{"1111", "0120", "2020", "3333"}, "5555"));
    assertEquals(6, new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
  }
}
