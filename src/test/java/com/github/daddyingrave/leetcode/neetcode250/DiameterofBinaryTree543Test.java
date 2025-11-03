package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiameterofBinaryTree543Test {
  class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
      int[] res = new int[1];
      traverse(root, res);
      return res[0];
    }

    int traverse(TreeNode node, int[] res) {
      if (node == null) {
        return 0;
      }

      int left = traverse(node.left, res);
      int right = traverse(node.right, res);
      res[0] = Math.max(res[0], left + right);

      return 1 + Math.max(left, right);
    }
  }

  @Test
  void test() {
    assertEquals(3, new Solution().diameterOfBinaryTree(TreeNode.TreeNodeDefault()));
  }
}
