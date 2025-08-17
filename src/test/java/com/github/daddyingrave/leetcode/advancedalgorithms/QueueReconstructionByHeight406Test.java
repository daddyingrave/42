package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QueueReconstructionByHeight406Test {
  class SegmentTree {
    private final int n;
    private final int[] tree;

    SegmentTree(int n) {
      this.n = n;
      tree = new int[4 * n];
      build(1, 0, n - 1);
    }

    private void build(int node, int l, int r) {
      if (l == r) {
        this.tree[node] = 1;
        return;
      }

      int mid = l + (r - l) / 2;
      build(node * 2, l, mid);
      build(node * 2 + 1, mid + 1, r);
      tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public void set(int idx, int val) {
      set(1, 0, n - 1, idx, val);
    }

    private void set(int node, int l, int r, int idx, int val) {
      if (l == r) {
        this.tree[node] = val;
        return;
      }

      int mid = l + (r - l) / 2;

      if (idx <= mid) {
        set(node * 2, l, mid, idx, val);
      } else {
        set(node * 2 + 1, mid + 1, r, idx, val);
      }

      tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int kthOne(int k) {
      int node = 1;
      int left = 0;
      int right = n - 1;

      while (left != right) {
        int mid = left + (right - left) / 2;

        int leftSum = tree[node * 2];
        if (k < leftSum) {
          node = node * 2;
          right = mid;
        } else {
          k -= leftSum;
          node = node * 2 + 1;
          left = mid + 1;
        }
      }

      return left;
    }

    public int totalOnes() {
      return tree[1];
    }
  }

  public class Solution {
    public int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, (l, r) -> l[0] == r[0] ? Integer.compare(r[1], l[1]) : Integer.compare(l[0], r[0]));

      int[][] result = new int[people.length][2];
      var segTree = new SegmentTree(people.length);

      for (int[] person : people) {
        int position = segTree.kthOne(person[1]);
        result[position] = person;
        segTree.set(position, 0);
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
