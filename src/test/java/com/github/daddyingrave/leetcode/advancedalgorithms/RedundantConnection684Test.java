package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class RedundantConnection684Test {
  public int[] findRedundantConnection(int[][] edges) {
    var uf = new UnionFind(edges.length);
    int[] edge = new int[2];
    for (int[] e : edges) {
      if (!uf.union(e[0], e[1])) {
        edge[0] = e[0];
        edge[1] = e[1];
      }
    }

    return edge;
  }

  class UnionFind {
    final int[] parents;
    final int[] rank;

    public UnionFind(int n) {
      parents = new int[n + 1];
      rank = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        parents[i] = i;
        rank[i] = 0;
      }
    }

    public int find(int val) {
      int parent = parents[val];
      while (parents[parent] != parent) {
        parents[parent] = parents[parents[parent]];
        parent = parents[parent];
      }

      return parent;
    }

    public boolean union(int x, int y) {
      int xParent = find(x);
      int yParent = find(y);
      if (xParent == yParent) {
        return false;
      }

      int xRank = rank[x];
      int yRank = rank[y];

      if (xRank > yRank) {
        parents[yParent] = xParent;
      } else if (xRank < yRank) {
        parents[xParent] = yParent;
      } else {
        parents[xParent] = yParent;
        rank[yParent] += 1;
      }

      return true;
    }
  }

  @Test
  void test() {

  }
}
