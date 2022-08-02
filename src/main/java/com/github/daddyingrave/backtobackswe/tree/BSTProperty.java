package com.github.daddyingrave.backtobackswe.tree;

public class BSTProperty {
  public boolean isValidBST(TreeNode root) {
    return traverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean traverse(TreeNode node, int min, int max) {
    if (node == null) {
      return true;
    } else if (node.val <= min || node.val >= max) {
      return false;
    }

    return traverse(node.left, min, node.val) && traverse(node.right, node.val, max);
  }
}
