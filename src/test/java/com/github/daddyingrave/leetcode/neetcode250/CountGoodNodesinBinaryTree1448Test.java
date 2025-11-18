package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountGoodNodesinBinaryTree1448Test {
  class Solution {
    public int goodNodes(TreeNode root) {
      return dfs(root, root.val);
    }

    int dfs(TreeNode node, int max) {
      if (node == null) {
        return 0;
      }

      if (node.val >= max) {
        return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
      } else {
        return dfs(node.left, max) + dfs(node.right, max);
      }
    }
  }

  @Test
  void test() {

  }
}
