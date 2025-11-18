package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementinaBST230Test {
  class Solution {
    public int kthSmallest(TreeNode root, int k) {
      int[] ref = new int[]{k, 0};
      dfs(root, ref);
      return ref[1];
    }

    void dfs(TreeNode node, int[] ref) {
      if (node == null) {
        return;
      }

      dfs(node.left, ref);
      ref[0]--;
      if (ref[0] == 0) {
        ref[1] = node.val;
        return;
      }
      dfs(node.right, ref);
    }
  }

  @Test
  void test() {

  }
}
