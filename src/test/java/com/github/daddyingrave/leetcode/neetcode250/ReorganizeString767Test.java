package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ReorganizeString767Test {
  class Solution {
    public String reorganizeString(String s) {
      record Pair(char ch, int count) {
      }

      var heap = new PriorityQueue<Pair>(Comparator.comparingInt(Pair::count).reversed());
      var map = new HashMap<Character, Integer>();
      for (int i = 0; i < s.length(); i++) {
        map.compute(s.charAt(i), (ch, count) -> count == null ? 1 : count + 1);
      }

      map.forEach((ch, count) -> heap.offer(new Pair(ch, count)));
      Pair prev = null;
      var sb = new StringBuilder();
      while (!heap.isEmpty() || prev != null) {
        if (prev != null && heap.isEmpty()) {
          return "";
        }


        var cur = heap.poll();
        sb.append(cur.ch);
        cur = new Pair(cur.ch, cur.count - 1);

        if (prev != null) {
          heap.offer(prev);
          prev = null;
        }

        if (cur.count > 0) {
          prev = cur;
        }
      }

      return sb.toString();
    }
  }

  @Test
  void test() {

  }
}
