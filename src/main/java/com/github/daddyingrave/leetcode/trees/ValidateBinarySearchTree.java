package com.github.daddyingrave.leetcode.trees;

public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return bst(root, null, null);
  }

  public boolean bst(TreeNode root, Integer max, Integer min) {
    if (root == null) {
      return true;
    }
    
    if (max != null && root.val >= max || min != null && root.val <= min) {
      return false;
    }

    return bst(root.right, max, root.val) && bst(root.left, root.val, min);
  }
}
