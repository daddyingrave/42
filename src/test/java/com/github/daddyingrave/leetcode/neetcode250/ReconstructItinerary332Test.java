package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary332Test {
  class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
      Map<String, PriorityQueue<String>> adj = new HashMap<>();
      for (List<String> ticket : tickets) {
        adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
            .add(ticket.get(1));
      }

      LinkedList<String> result = new LinkedList<>();
      Deque<String> stack = new ArrayDeque<>();
      stack.push("JFK");

      while (!stack.isEmpty()) {
        PriorityQueue<String> neighbors = adj.get(stack.peek());
        if (neighbors != null && !neighbors.isEmpty()) {
          stack.push(neighbors.poll());
        } else {
          result.addFirst(stack.pop());
        }
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
