package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree1489Test {
  class Solution {

    class UnionFind {
      int[] par;
      int[] rank;

      UnionFind(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
          par[i] = i;
          rank[i] = 1;
        }
      }

      public boolean union(int v1, int v2) {
        int p1 = find(v1), p2 = find(v2);
        if (p1 == p2) return false;
        if (rank[p1] > rank[p2]) {
          par[p2] = p1;
          rank[p1] += rank[p2];
        } else {
          par[p1] = p2;
          rank[p2] += rank[p1];
        }
        return true;
      }

      int find(int v) {
        if (par[v] != v) {
          par[v] = find(par[v]);
        }
        return par[v];
      }

      int maxRank() {
        int max = rank[0];
        for (int rank : rank) {
          max = Math.max(max, rank);
        }

        return max;
      }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
      var edgesWithIndex = new ArrayList<List<Integer>>();
      for (int i = 0; i < edges.length; i++) {
        edgesWithIndex.add(List.of(edges[i][0], edges[i][1], edges[i][2], i));
      }
      edgesWithIndex.sort(Comparator.comparingInt(l -> l.get(2)));

      int mstWeight = 0;
      var uf = new UnionFind(n);
      for (var e : edgesWithIndex) {
        if (uf.union(e.get(0), e.get(1))) {
          mstWeight += e.get(2);
        }
      }

      var criticalEdges = new ArrayList<Integer>();
      var pseudoCriticalEdges = new ArrayList<Integer>();

      for (var withIndex : edgesWithIndex) {
        int n1 = withIndex.get(0);
        int n2 = withIndex.get(1);
        int edgeWeight = withIndex.get(2);
        int edgeIndex = withIndex.get(3);

        int newCriticalWeight = 0;
        var ufCritical = new UnionFind(n);

        for (var edgeForCritical : edgesWithIndex) {
          if (edgeIndex != edgeForCritical.get(3)) {
            if (ufCritical.union(edgeForCritical.get(0), edgeForCritical.get(1))) {
              newCriticalWeight += edgeForCritical.get(2);
            }
          }
        }

        if (ufCritical.maxRank() != n || newCriticalWeight > mstWeight) {
          criticalEdges.add(edgeIndex);
          continue;
        }

        int pseudoWeight = edgeWeight;
        var pseudoUf = new UnionFind(n);
        pseudoUf.union(n1, n2);

        for (var edgeForPseudo : edgesWithIndex) {
          if (pseudoUf.union(edgeForPseudo.get(0), edgeForPseudo.get(1))) {
            pseudoWeight += edgeForPseudo.get(2);
          }
        }

        if (pseudoWeight == mstWeight) {
          pseudoCriticalEdges.add(edgeIndex);
        }
      }

      return List.of(criticalEdges, pseudoCriticalEdges);
    }
  }

  @Test
  void test() {

  }
}
