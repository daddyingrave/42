package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceII2407Test {

  class Solution {
    class SegmentTree {
      final int[] tree;
      int n;

      SegmentTree(int size) {
        this.n = size;
        while ((this.n & (this.n - 1)) != 0) {
          this.n++;
        }

        this.tree = new int[2 * this.n];
      }

      void set(int index, int value) {
        if (value <= tree[n + index]) {
          return;
        }

        tree[n + index] = value;
        for (int i = (n + index) >> 1; i >= 1; i >>= 1) {
          tree[i] = Math.max(tree[i << 1], tree[(i << 1) + 1]);
        }
      }

      int query(int left, int right) {
        left += n;
        right += n + 1;

        int res = 0;

        while (left < right) {
          if ((left & 1) == 1) {
            res = Math.max(res, tree[left++]);
          }
          if ((right & 1) == 1) {
            res = Math.max(res, tree[--right]);
          }

          left >>= 1;
          right >>= 1;
        }

        return res;
      }
    }

    public int lengthOfLIS(int[] nums, int k) {
      int max = 0;
      for (int num : nums) {
        max = Math.max(max, num);
      }

      var segmentTree = new SegmentTree(max + 1);
      int result = 0;
      for (int num : nums) {
        int left = Math.max(0, num - k);
        int right = Math.max(0, num - 1);
        int cur = segmentTree.query(left, right) + 1;
        result = Math.max(result, cur);
        segmentTree.set(num, cur);
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
