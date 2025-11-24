package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeMaximumPathSum124Test {
  class Solution {
    public int maxPathSum(TreeNode root) {
      int[] res = new int[]{root.val};
      dfs(root, res);
      return res[0];
    }

    int dfs(TreeNode node, int[] res) {
      if (node == null) {
        return 0;
      }

      int leftMax = dfs(node.left, res);
      int rightMax = dfs(node.right, res);
      leftMax = Math.max(leftMax, 0);
      rightMax = Math.max(rightMax, 0);

      res[0] = Math.max(res[0], node.val + leftMax + rightMax);

      return node.val + Math.max(leftMax, rightMax);
    }
  }

  @Test
  void test() {

  }
}

