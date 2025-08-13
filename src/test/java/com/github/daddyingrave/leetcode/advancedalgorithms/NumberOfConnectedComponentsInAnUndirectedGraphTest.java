package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfConnectedComponentsInAnUndirectedGraphTest {
  public int countComponents(int n, int[][] edges) {
    var uf = new UnionFind(0, n);
    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }

    return uf.connected();
  }

  class UnionFind {
    int[] parents;
    int[] rank;

    UnionFind(int from, int to) {
      parents = new int[to - from];
      rank = new int[to - from];
      for (int i = from; i < to; i++) {
        parents[i] = i;
        rank[i] = 0;
      }
    }

    boolean union(int n1, int n2) {
      int parent1 = find(n1);
      int parent2 = find(n2);
      if (parent1 == parent2) {
        return false;
      }

      int p1Rank = rank[parent1];
      int p2Rank = rank[parent2];

      if (p1Rank > p2Rank) {
        parents[parent1] = parent2;
      } else if (p1Rank < p2Rank) {
        parents[parent2] = parent1;
      } else {
        parents[parent1] = parent2;
        rank[parent2]++;
      }

      return true;
    }

    int find(int n) {
      int cur = parents[n];
      while (cur != parents[cur]) {
        parents[cur] = parents[parents[cur]];
        cur = parents[cur];
      }

      return cur;
    }

    int connected() {
      int count = 0;
      for (int i = 0; i < parents.length; i++) {
        if (parents[i] == i) {
          count++;
        }
      }

      return count;
    }
  }

  @Test
  void test() {
    assertEquals(1, countComponents(3, new int[][]{{0, 1}, {0, 2}}));
    assertEquals(2, countComponents(6, new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 5}}));
  }
}
