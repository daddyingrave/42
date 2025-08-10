package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UnionFindTest {
  class UnionFind {
    Map<Integer, Integer> parents = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public UnionFind(int n) {
      for (int i = 0; i < n; i++) {
        parents.put(i, i);
        rank.put(i, 0);
      }
    }

    public int find(int val) {
      int parent = parents.get(val);
      while (parents.get(parent) != parent) {
        parents.put(parent, parents.get(parent));
        parent = parents.get(parent);
      }

      return parent;
    }

    public boolean isSameComponent(int x, int y) {
      return find(x) == find(y);
    }

    public boolean union(int x, int y) {
      int xParent = find(x);
      int yParent = find(y);
      if (xParent == yParent) {
        return false;
      }

      int xRank = rank.get(x);
      int yRank = rank.get(y);

      if (xRank > yRank) {
        parents.put(yParent, xParent);
      } else if (xRank < yRank) {
        parents.put(xParent, yParent);
      } else {
        parents.put(xParent, yParent);
        rank.merge(yParent, 1, Integer::sum);
      }

      return true;
    }

    public int getNumComponents() {
      int count = 0;
      for (var kv : parents.entrySet()) {
        if (parents.get(kv.getValue()).equals(kv.getKey())) {
          count++;
        }
      }

      return count;
    }
  }

  @Test
  void test() {

  }
}
