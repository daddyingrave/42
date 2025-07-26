package com.github.daddyingrave.leetcode.dsaforbeginners;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DesignGraphTest {
  class Graph {

    Map<Integer, Set<Integer>> adjacency = new HashMap<>();

    // "addEdge", 1, 2,
    // "addEdge", 2, 3,
    // "hasPath", 1, 3,
    // "hasPath", 3, 1,
    // "removeEdge", 1, 2,
    // "hasPath", 1, 3
    public Graph() {
    }

    public void addEdge(int src, int dst) {
      if (!adjacency.containsKey(src)) {
        adjacency.put(src, new HashSet<>());
      }
      if (!adjacency.containsKey(dst)) {
        adjacency.put(dst, new HashSet<>());
      }

      adjacency.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
      if (!adjacency.containsKey(src)) {
        return false;
      } else if (!adjacency.get(src).contains(dst)) {
        return false;
      }

      adjacency.get(src).remove(dst);

      return true;
    }

    public boolean hasPath(int src, int dst) {
      if (!adjacency.containsKey(src)) {
        return false;
      } else {
        return bfs(src, dst);
      }
    }

    boolean bfs(int src, int dst) {
      var queue = new ArrayDeque<Integer>();
      var visited = new HashSet<Integer>();
      queue.offer(src);
      visited.add(src);

      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size > 0) {
          var cur = queue.poll();
          size--;

          if (cur == dst) {
            return true;
          }

          var neighbours = adjacency.get(cur);
          for (Integer neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
              queue.offer(neighbour);
              visited.add(neighbour);
            }
          }
        }
      }

      return false;
    }
  }
}
