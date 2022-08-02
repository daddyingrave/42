package com.github.daddyingrave.leetcode.trees;

public class CountGoodNodesInBinaryTree {
  public int goodNodes(TreeNode root) {
    return rec(root, root.val);
  }
  
  private int rec(TreeNode node, int max) {
    if (node == null) {
      return 0;
    }
    int newMax = Math.max(max, node.val);
    int count = node.val >= max ? 1 : 0;
    return rec(node.left, newMax) + rec(node.right, newMax) + count;
  }
}
