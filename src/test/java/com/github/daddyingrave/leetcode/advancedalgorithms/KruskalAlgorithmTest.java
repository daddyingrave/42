package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgorithmTest {

  class Solution {
    class UnionFind {
      int[] parents;
      int[] ranks;

      UnionFind(int n) {
        parents = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
          parents[i] = i;
          ranks[i] = 1;
        }
      }

      boolean union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        if (node1Parent == node2Parent) {
          return false;
        }

        int node1Rank = ranks[node1];
        int node2Rank = ranks[node2];

        if (node1Rank > node2Rank) {
          parents[node2Parent] = node1Parent;
        } else if (node2Rank > node1Rank) {
          parents[node1Parent] = node2Parent;
        } else {
          parents[node1Parent] = node2Parent;
          ranks[node2Parent] += 1;
        }

        return true;
      }

      int find(int node) {
        int parent = parents[node];
        while (parent != parents[parent]) {
          parents[parent] = parents[parents[parent]];
          parent = parents[parent];
        }

        return parent;
      }
    }

    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
      var heap = new PriorityQueue<List<Integer>>(Comparator.comparing(l -> l.get(2)));
      heap.addAll(edges);
      var uf = new UnionFind(n);

      int totalWeight = 0;
      int edgesExpected = n - 1;
      while (!heap.isEmpty() && edgesExpected > 0) {
        var cur = heap.poll();
        if (uf.union(cur.get(0), cur.get(1))) {
          totalWeight += cur.get(2);
          edgesExpected--;
        }
      }

      if (edgesExpected == 0) {
        return totalWeight;
      } else {
        return -1;
      }
    }
  }

  @Test
  void test() {

  }
}
