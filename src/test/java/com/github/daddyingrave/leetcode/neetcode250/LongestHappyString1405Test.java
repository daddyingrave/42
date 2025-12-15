package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class LongestHappyString1405Test {
  class Solution {
    public String longestDiverseString(int a, int b, int c) {
      record Pair(char ch, int count) {
      }
      var heap = new PriorityQueue<Pair>(Comparator.comparingInt(Pair::count).reversed());

      if (a > 0) {
        heap.offer(new Pair('a', a));
      }
      if (b > 0) {
        heap.offer(new Pair('b', b));
      }
      if (c > 0) {
        heap.offer(new Pair('c', c));
      }

      var result = new StringBuilder();
      while (!heap.isEmpty()) {
        var mostFreq = heap.poll();
        if (result.length() > 1 && result.charAt(result.length() - 1) == mostFreq.ch &&
            result.charAt(result.length() - 2) == mostFreq.ch
        ) {
          if (heap.isEmpty()) {
            break;
          }
          var second = heap.poll();
          result.append(second.ch);
          second = new Pair(second.ch, second.count - 1);
          if (second.count > 0) {
            heap.offer(second);
          }
          heap.offer(mostFreq);
        } else {
          result.append(mostFreq.ch);
          mostFreq = new Pair(mostFreq.ch, mostFreq.count - 1);
          if (mostFreq.count > 0) {
            heap.offer(mostFreq);
          }
        }
      }

      return result.toString();
    }
  }

  @Test
  void test() {

  }
}
