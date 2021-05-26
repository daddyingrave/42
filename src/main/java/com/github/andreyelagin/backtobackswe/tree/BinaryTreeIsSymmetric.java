package com.github.andreyelagin.backtobackswe.tree;

public class BinaryTreeIsSymmetric {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return checkSymmetry(root.left, root.right);
  }

  private boolean checkSymmetry(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left != null && right != null) {
      return left.val == right.val
          && checkSymmetry(left.right, right.left)
          && checkSymmetry(left.left, right.right);
    }
    
    return false;
  }
}
