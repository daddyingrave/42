package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathSum112Test {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return backtrack(root, targetSum, 0);
  }

  boolean backtrack(TreeNode node, int targetSum, int curSum) {
    if (node == null) {
      return false;
    }

    curSum += node.val;
    if (curSum == targetSum && node.left == null && node.right == null) {
      return true;
    } else {
      return backtrack(node.left, targetSum, curSum) || backtrack(node.right, targetSum, curSum);
    }
  }

  @Test
  void test() {
    assertTrue(hasPathSum(TreeNode.TreeNodeDefault(), 381));
  }
}
