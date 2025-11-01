package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumDepthofBinaryTree104Test {
  class Solution {
    public int maxDepth(TreeNode root) {
      return traverse(root, 0, 0);
    }

    int traverse(TreeNode node, int cur, int max) {
      if (node == null) {
        return Math.max(cur, max);
      }

      return Math.max(
          traverse(node.left, cur + 1, max),
          traverse(node.right, cur + 1, max)
      );
    }
  }

  @Test
  void test() {
    assertEquals(3, new Solution().maxDepth(TreeNode.TreeNodeDefault()));
    assertEquals(0, new Solution().maxDepth(null));
    assertEquals(1, new Solution().maxDepth(new TreeNode(666)));
  }
}
