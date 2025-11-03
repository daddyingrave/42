package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBinaryTree110Test {
  class Solution {
    public boolean isBalanced(TreeNode root) {
      return height(root) != -1;
    }

    int height(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int left = height(node.left);
      int right = height(node.right);

      if (left == -1 || right == -1) {
        return -1;
      }

      if (Math.abs(left - right) > 1) {
        return -1;
      }

      return 1 + Math.max(left, right);
    }
  }

  @Test
  void test() {

  }
}
